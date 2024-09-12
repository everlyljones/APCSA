/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author ejones2025
 */

import java.awt.*;
import javax.swing.*;

public class Main extends JPanel{
public Main(){
super();
}
/* Create a paintComponent() method to override the one in
JPanel.This is where the drawing happens. We don't have
to call it in our program, it gets called automatically
whenever the panel needs to be redrawn, like when it is
made visible or moved or whatever.
*/
public void paintComponent(Graphics g){
g.drawOval(75, 65, 120, 100);
g.drawLine(82, 93, 90, 50);
g.drawLine(90, 50, 98, 77);
g.drawLine(150, 67, 158, 47);
g.drawLine(158, 47, 175, 77);
g.drawOval(110, 90, 10, 10);
g.drawOval(140, 90, 10, 10);
g.drawLine(125, 120, 135, 120);
g.drawLine(125, 120, 130, 125);
g.drawLine(130, 125, 135, 120);
g.drawLine(130, 125, 130, 135);
g.drawLine(120, 135, 140, 135);

}
public static void main(String arg[]){
JFrame frame = new JFrame("BasicJPanel");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400,300);
// Create a new identifier for a BasicJPanel called "panel",
// then create a new BasicJPanel object for it to refer to.
Main panel = new Main();
// Make the panel object the content pane of the JFrame.
// This puts it into the drawable area of frame, and now
// we do all our drawing to panel, using paintComponent(), above.
frame.setContentPane(panel);
frame.setVisible(true);
}
}