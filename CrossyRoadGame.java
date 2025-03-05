/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crossyroadgame;

/**
 *
 * @author ejones2025
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

// Base class for all game objects
abstract class GameObject {
    protected int x, y, width, height;
    protected Color color;

    public GameObject(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public abstract void update();
    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}

// Player class with inheritance for upgrades
class Player extends GameObject {
    private int speed;
    private boolean canDash;
    
    public Player(int x, int y) {
        super(x, y, 30, 30, Color.BLUE);
        this.speed = 5;
        this.canDash = false;
    }

    public void move(int dx, int dy) {
        x += dx * speed;
        y += dy * speed;
    }
    
    public void enableDash() {
        this.canDash = true;
    }
    
    public boolean canDash() {
        return canDash;
    }

    @Override
    public void update() {}
}

// Vehicle class
class Vehicle extends GameObject {
    private int speed;
    private boolean movingLeft;
    
    public Vehicle(int x, int y, int speed, int width, int height, Color color, boolean movingLeft) {
        super(x, y, width, height, color);
        this.speed = speed;
        this.movingLeft = movingLeft;
    }

    @Override
    public void update() {
        if (movingLeft) {
            x -= speed;
            if (x < -width) x = 600;
        } else {
            x += speed;
            if (x > 600) x = -width;
        }
    }

    public void increaseSpeed() {
        speed += 1;
    }
}

// Game panel for rendering and game logic
class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Player player;
    private ArrayList<Vehicle> vehicles;
    private Timer timer;
    private int score;
    private boolean movingUp;
    
    public GamePanel() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.BLACK);
        player = new Player(280, 350);
        vehicles = new ArrayList<>();
        timer = new Timer(100, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        initializeVehicles();
        score = 0;
        movingUp = true;
    }
    
    private void initializeVehicles() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int width = rand.nextInt(50) + 30;
            int height = rand.nextInt(20) + 20;
            boolean movingLeft = rand.nextBoolean();
            int x = movingLeft ? 600 : -width;
            vehicles.add(new Vehicle(x, 50 + i * 60, rand.nextInt(5) + 2, width, height, Color.WHITE, movingLeft));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        for (Vehicle vehicle : vehicles) {
            vehicle.draw(g);
        }
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Vehicle vehicle : vehicles) {
            vehicle.update();
            if (player.getBounds().intersects(vehicle.getBounds())) {
                JOptionPane.showMessageDialog(this, "Game Over! Final Score: " + score);
                System.exit(0);
            }
        }
        if ((movingUp && player.y <= 0) || (!movingUp && player.y >= 350)) {
            score++;
            movingUp = !movingUp;
            player.y = movingUp ? 350 : 0;
            for (Vehicle vehicle : vehicles) {
                vehicle.increaseSpeed();
            }
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) player.move(0, -1);
        if (key == KeyEvent.VK_DOWN) player.move(0, 1);
        if (key == KeyEvent.VK_LEFT) player.move(-1, 0);
        if (key == KeyEvent.VK_RIGHT) player.move(1, 0);
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}

// Main game frame
public class CrossyRoadGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Crossy Road");
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}