/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.array;
import java.util.Random;

/**
 *
 * @author ejones2025
 */

public class Array {
    static String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    
    public static void main(String[] args) {
        weekDays = shuffleArray();
        
        System.out.println("All days of the week:");
        for (String day : weekDays) {
            System.out.println(day);
        }

        String[] weekdays = new String[5]; //resizing array to 5
        System.arraycopy(weekDays, 1, weekdays, 0, 5); //resizing array to 5
        
        System.out.println("\nWeekdays only:"); //print resizing array
        for (String day : weekdays) {
            System.out.println(day);
        }
    }
    
    static String[] shuffleArray() {
        String[] shuffle = weekDays.clone();
        Random generator = new Random();
        for (int i = shuffle.length - 1; i > 0; i--) {
            int index = generator.nextInt(i + 1);
            String temp = shuffle[i];
            shuffle[i] = shuffle[index];
            shuffle[index] = temp;
        }
        return shuffle;
    }
}

