/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberguess;

/**
 *
 * @author ejones2025
 */

/*
Plan:
random number generator 
does not give viewers the number
random import
scanner import
print welcome to game and how it works 
player enters number guess
infinite attempts 
use if statements to show what do if the number is greater than or less than the guess
print how many attempts it took
*/

// imports
import java.util.Scanner;
import java.util.Random;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //insert scanner
        
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // random number generator (raanges from 1 to 100)
        
        int userGuess = 0; 
        int attempts = 0; 

        System.out.println("Welcome to guess the number!\nI have selected a number between 1 and 100. \nCan you guess it?"); //game starts and how to play game

        while (userGuess != randomNumber) {
            System.out.print("Enter your guess: "); //player enters guess once screen says this
            userGuess = scanner.nextInt();
            attempts++;  //infinite attempts


            if (userGuess < randomNumber) { // if guess is less than the number, then game lets you try again
                System.out.println("Oops! Your guess is too low. Please try again.");
            } else if (userGuess > randomNumber) { // if guess is greater than the number, then game lets you try again
                System.out.println("Oops! Your guess is too high. Please try again.");
            }
        }

    
        System.out.println("Congrats! You guessed the correct number: " + randomNumber); //once you guess the correct number you win
        System.out.println("It took you " + attempts + " attempts to guess the number."); //game tells you how many attmepts it took you
        

        scanner.close(); // close scanner
    }
}