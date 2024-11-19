/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shoppinglist;

/**
 *
 * @author ejones2025
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> shoppingList = new ArrayList<>();
        
        System.out.println("What would you like to add to your shopping list?");
        while (true) { 
            System.out.println("Add item: \nType 'done' when you are finished");
            String item = scanner.nextLine();
            if (item.equalsIgnoreCase("done")){
                break;
            }
            shoppingList.add(item);
        }
        System.out.println("\nWould you like to remove anything? If so, type the number of the item on the list. ");
        int removeIndex = scanner.nextInt();
        //scanner.nextLine();
        
        if (removeIndex > 0 & removeIndex <= shoppingList.size()) {
            shoppingList.remove(removeIndex - 1);
            System.out.println("\nUpdated shopping list: ");
            displayList(shoppingList);
        } 
        else {
            System.out.println("Invalid. No items were removed.");
        }
        scanner.close();
    }
    private static void displayList(ArrayList<String> shoppingList) {
        //int i = 0;
        if (shoppingList.isEmpty()) {
            System.out.println("The shopping list is empty");
        }
        else {
            for (int i = 0; i<shoppingList.size(); i++) {
                System.out.println((i + 1) + ". " + shoppingList.get(i));
            }
        }
    }
}