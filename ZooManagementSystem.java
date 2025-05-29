/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.zoomanagementsystem;

/**
 *
 * @author ejones2025
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class ZooManagementSystem extends JFrame {
    private JTextField nameField, ageField, speciesField, colorField, foodField;
    private JComboBox<String> enclosureComboBox;
    private JTextArea textArea;
    private ArrayList<Animal> animalsList = new ArrayList<>();

    public ZooManagementSystem() {
        super("Zoo Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 550);
        setLocationRelativeTo(null);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
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

        inputPanel.add(new JLabel("Enclosure:"));
        enclosureComboBox = new JComboBox<>(new String[] {
            "Savannah Habitat", "Aquatic Zone", "Bird Aviary", "Reptile House", "Jungle Enclosure"
        });
        inputPanel.add(enclosureComboBox);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton registerBtn = new JButton("Register Animal");
        JButton loadBtn = new JButton("Load Animals");
        JButton summaryBtn = new JButton("Show Summary");
        buttonPanel.add(registerBtn);
        buttonPanel.add(loadBtn);
        buttonPanel.add(summaryBtn);

        // Output area
        textArea = new JTextArea(12, 50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Layout
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Register button logic
        registerBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String ageText = ageField.getText().trim();
            String species = speciesField.getText().trim();
            String color = colorField.getText().trim();
            String food = foodField.getText().trim();
            String enclosure = (String) enclosureComboBox.getSelectedItem();

            if (name.isEmpty() || ageText.isEmpty() || species.isEmpty() ||
                color.isEmpty() || food.isEmpty() || enclosure == null) {
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

            Animal animal = new Animal(name, age, species, color, food, enclosure);
            try (FileWriter fw = new FileWriter("animals.csv", true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println(animal.name + "," + animal.age + "," +
                           animal.species + "," + animal.color + "," +
                           animal.food + "," + animal.enclosure);
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
            enclosureComboBox.setSelectedIndex(0);
        });

        // Load button logic
        loadBtn.addActionListener(e -> {
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
                    if (parts.length == 6) {
                        try {
                            int age = Integer.parseInt(parts[1]);
                            Animal animal = new Animal(parts[0], age, parts[2], parts[3], parts[4], parts[5]);
                            animalsList.add(animal);
                        } catch (NumberFormatException nfex) {
                            // Skip invalid record
                        }
                    }
                }
                textArea.append("Loaded " + animalsList.size() + " animals from file.\n");
            } catch (IOException ex) {
                textArea.append("Error reading file: " + ex.getMessage() + "\n");
            }
        });

        // Summary button logic
        summaryBtn.addActionListener(e -> {
            textArea.append("\n=== Animal Summary ===\n");
            for (Animal a : animalsList) {
                textArea.append("Name: " + a.name +
                                ", Age: " + a.age +
                                ", Species: " + a.species +
                                ", Color: " + a.color +
                                ", Food: " + a.food +
                                ", Enclosure: " + a.enclosure + "\n");
            }
            textArea.append("Total animals registered: " + animalsList.size() + "\n\n");
        });

        setVisible(true);
    }

    static class Animal {
        String name, species, color, food, enclosure;
        int age;
        Animal(String name, int age, String species, String color, String food, String enclosure) {
            this.name = name;
            this.age = age;
            this.species = species;
            this.color = color;
            this.food = food;
            this.enclosure = enclosure;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ZooManagementSystem::new);
    }
}