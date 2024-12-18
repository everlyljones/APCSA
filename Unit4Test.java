/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unit4test;

/**
 *
 * @author ejones2025
 */

//add imports
import java.util.ArrayList;
import java.util.Random;

public class Unit4Test {
    public static void main(String[] args) {
        // create an array list
        ArrayList<Card> hand = new ArrayList<>();
        Random random = new Random();

        Card highestCard = null;

        // give 5 cards
        while (hand.size() < 5) {
            Card newCard = new Card();
            boolean isDuplicate = false;

            // check for duplicates
            for (Card card : hand) {
                if (card.getSuit().equals(newCard.getSuit()) && card.getValue() == newCard.getValue()) {
                    isDuplicate = true;
                    break;
                }
            }

            // add card
            if (!isDuplicate) {
                hand.add(newCard);


                if (highestCard == null || newCard.getValue() > highestCard.getValue()) {
                    highestCard = newCard;
                }
            }
        }

        // display cards
        System.out.println("Deal Cards:");
        for (Card card : hand) {
            System.out.println(card);
        }
        System.out.println("\nThe highest card is: " + highestCard);
    }
}

class Card {
    private String suit; 
    private int value; 
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"}; // Card suits
    private static final Random RANDOM = new Random(); // random number generator

    // constructor
    public Card() {
        this.suit = SUITS[RANDOM.nextInt(SUITS.length)]; // random suit
        this.value = RANDOM.nextInt(13) + 1; // random number
    }

   
    public String getSuit() {
        return suit;
    }

 
    public int getValue() {
        return value;
    }

    // Override toString method for display
    @Override
    public String toString() {
        return "Card{" +
               "suit=" + suit + '\'' +
               ", value=" + value +
               '}';
    }
}

