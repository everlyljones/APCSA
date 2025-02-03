/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.deckofcards;

/**
 *
 * @author ejones2025
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
    public static void main(String[] args) {
        String [][] deckOfCards = new String[4][13];
        String[] suits = { "Hearts", "Clubs", "Spades", "Diamonds"};
        String[] ranks = { "Ace", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        
        ArrayList<String> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deckOfCards[i][j] = ranks[j] + " of " + suits[i];
                deck.add(deckOfCards[i][j]);
            }
        }
        
        Collections.shuffle(deck, new Random());
        
        String[][] hands = new String[4][5];
        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                hands[i][j] = deck.get(cardIndex++);
            }
        }
        
        for (int i = 0; i  <4; i++) {
            System.out.println("Hand " + (i+1) + ":");
            for (int j = 0; j < 5; j ++) {
                System.out.println(" " + hands[i][j]);
            }
            System.out.println();
        }
    }
}
