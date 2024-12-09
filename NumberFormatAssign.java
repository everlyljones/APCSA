/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberformatassign;

/**
 *
 * @author ejones2025
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class NumberFormatAssign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Task 1: Calculate the percentage of girls and boys in the school.");
        System.out.print("Enter the total number of students at the school: ");
        int totalStudents = scanner.nextInt();
        System.out.print("Enter the number of girls at the school: ");
        int girls = scanner.nextInt();
        
        int boys = totalStudents - girls; 
        double girlsPercentage = (double) girls / totalStudents * 100;
        double boysPercentage = (double) boys / totalStudents * 100;
        
  
        System.out.printf("Percentage of girls: %.2f%%\n", girlsPercentage);
        System.out.printf("Percentage of boys: %.2f%%\n", boysPercentage);

        
        System.out.println("\nTask 2: Convert USD to GBP.");
        System.out.print("Enter the total amount in dollars and cents (e.g., 100.50): ");
        double usdAmount = scanner.nextDouble();
        
        double exchangeRate = 0.83; 
        double gbpAmount = usdAmount * exchangeRate;

        Locale britishLocale = Locale.UK;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(britishLocale);
        System.out.printf("Amount in GBP: %s (Exchange rate: 1 USD = 0.83 GBP)\n", currencyFormatter.format(gbpAmount));

        System.out.println("\nTask 3: Format Pi to a given number of decimal places.");
        System.out.print("Enter an integer between 0 and 15 to specify the number of decimal places: ");
        int decimalPlaces = scanner.nextInt();
        
        if (decimalPlaces < 0 || decimalPlaces > 15) {
            System.out.println("Invalid input. Please enter a number between 0 and 15.");
        } else {
            String formatString = "#." + "#".repeat(decimalPlaces); // Create format string dynamically
            DecimalFormat piFormatter = new DecimalFormat(formatString);
            double pi = Math.PI;
            System.out.println("Pi to " + decimalPlaces + " decimal places: " + piFormatter.format(pi));
        }

        System.out.println("\nTask 4: Generate a random large number and display it.");
        Random random = new Random();
        long min = 100_000_000;
        long max = 999_000_000_000_000_000L; // Maximum value (999e18)
        long randomNumber = min + (long) (random.nextDouble() * (max - min));

        DecimalFormat largeNumberFormatter = new DecimalFormat("#,###");
        System.out.println("Generated random number: " + largeNumberFormatter.format(randomNumber));

        scanner.close();
    }
}
