/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.zoomanagementsystem;

/**
 *
 * @author ejones2025
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class ZooManagementSystem extends JFrame {
    // GUI components
    private JTextField nameField, ageField, speciesField, colorField, foodField;
    private JTextArea textArea;
    private ArrayList<Animal> animalsList = new ArrayList<>();

    public ZooManagementSystem() {
        super("Zoo Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 500);
        setLocationRelativeTo(null);

        // Panel for form inputs (5 rows, 2 columns)
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Species:"));
        speciesField = new JTextField();
        inputPanel.add(speciesField);

        inputPanel.add(new JLabel("Color:"));
        colorField = new JTextField();
        inputPanel.add(colorField);

        inputPanel.add(new JLabel("Food:"));
        foodField = new JTextField();
        inputPanel.add(foodField);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton registerBtn = new JButton("Register Animal");
        JButton loadBtn = new JButton("Load Animals");
        JButton summaryBtn = new JButton("Show Summary");
        buttonPanel.add(registerBtn);
        buttonPanel.add(loadBtn);
        buttonPanel.add(summaryBtn);

        // Text area for output messages
        textArea = new JTextArea(12, 45);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Action listener for Register button
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String ageText = ageField.getText().trim();
                String species = speciesField.getText().trim();
                String color = colorField.getText().trim();
                String food = foodField.getText().trim();

                if (name.isEmpty() || ageText.isEmpty() || species.isEmpty() ||
                    color.isEmpty() || food.isEmpty()) {
                    textArea.append("Please fill all fields.\n");
                    return;
                }

                int age;
                try {
                    age = Integer.parseInt(ageText);
                } catch (NumberFormatException ex) {
                    textArea.append("Invalid age. Enter a number.\n");
                    return;
                }

                Animal animal = new Animal(name, age, species, color, food);
                try (FileWriter fw = new FileWriter("animals.csv", true);
                     PrintWriter pw = new PrintWriter(fw)) {
                    pw.println(animal.name + "," + animal.age + "," +
                               animal.species + "," + animal.color + "," + animal.food);
                    textArea.append("Animal registered: " + name + "\n");
                    animalsList.add(animal);
                } catch (IOException ex) {
                    textArea.append("Error writing to file: " + ex.getMessage() + "\n");
                }

                nameField.setText("");
                ageField.setText("");
                speciesField.setText("");
                colorField.setText("");
                foodField.setText("");
            }
        });

        // Action listener for Load button
        loadBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animalsList.clear();
                File csvFile = new File("animals.csv");
                if (!csvFile.exists()) {
                    textArea.append("No data file found.\n");
                    return;
                }
                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length == 5) {
                            try {
                                int age = Integer.parseInt(parts[1]);
                                Animal animal = new Animal(parts[0], age, parts[2], parts[3], parts[4]);
                                animalsList.add(animal);
                            } catch (NumberFormatException nfex) {
                                // Skip invalid age
                            }
                        }
                    }
                    textArea.append("Loaded " + animalsList.size() + " animals from file.\n");
                } catch (IOException ex) {
                    textArea.append("Error reading file: " + ex.getMessage() + "\n");
                }
            }
        });

        // Action listener for Summary button
        summaryBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("\n=== Animal Summary ===\n");
                for (Animal a : animalsList) {
                    textArea.append("Name: " + a.name +
                                    ", Age: " + a.age +
                                    ", Species: " + a.species +
                                    ", Color: " + a.color +
                                    ", Food: " + a.food + "\n");
                }
                textArea.append("Total animals registered: " + animalsList.size() + "\n\n");
            }
        });

        setVisible(true);
    }

    static class Animal {
        String name, species, color, food;
        int age;
        Animal(String name, int age, String species, String color, String food) {
            this.name = name;
            this.age = age;
            this.species = species;
            this.color = color;
            this.food = food;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ZooManagementSystem());
    }
}
