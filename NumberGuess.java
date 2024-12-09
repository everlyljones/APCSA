/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberguess;

/**
 *
 * @author ejones2025
 */
import java.util.Scanner;
import java.util.Random;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        
        int userGuess = 0; 
        int attempts = 0; 

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Can you guess it?");
        

        while (userGuess != randomNumber) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;  


            if (userGuess < randomNumber) {
                System.out.println("Oops! Your guess is too low. Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Oops! Your guess is too high. Try again.");
            }
        }

    
        System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
        System.out.println("It took you " + attempts + " attempts to guess the number.");
        

        scanner.close();
    }
}