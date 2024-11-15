/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mystore;

/**
 *
 * @author ejones2025
 */
import java.util.Scanner;

public class MyStore {
    private static final double MAX_BUDGET = 250.00;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Item[] items = {
            new Item("T-Shirt", 29.99),
            new Item("Shoes", 125.99),
            new Item("Jeans", 60.99),
            new Item("Jacket", 250.00),
            new Item("Hat", 25.99),
            new Item("Shorts", 75.99),
            new Item("Blouse", 88.99),
        };
        
        double totalSpent = 0.0;
        int itemCount = 0;
        
        System.out.println("Weclome! Your max budget is $" + MAX_BUDGET);
        System.out.println("Available items:");
        
        for (Item item : items) {
            System.out.println(item);
        }
        
        while (true) {
            System.out.println("Enter an item name to add to cart (type 'exit' when finished):");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for shopping! You bought " + itemCount + " items. You spent $" + totalSpent);
                break;
            }
            
            Item selectedItem = null;
            for (Item item : items) {
                if (item.getName().equalsIgnoreCase(input)) {
                    selectedItem = item;
                    break;
                }
            }
            
            if (selectedItem == null) {
                System.out.println( "Item not found, please try again.");
                continue;
            }
            if (totalSpent + selectedItem.getPrice() > MAX_BUDGET) {
                System.out.println("You have exceeded the budget. You now have $" + (MAX_BUDGET - totalSpent) + " left.");
            } else {
                totalSpent += selectedItem.getPrice();
                itemCount++;
                System.out.println("Added " + selectedItem.getName() + " to cart. Total spent: $" + totalSpent + ". Items in cart: " + itemCount);
            }
        }
        scanner.close();
    }
}
class Item { 
    private String strName;
    private double dblPrice;
    
    public Item(String name, double price) {
        this.strName = name;
        this.dblPrice = price;
    }
    
    public String getName() {
        return strName;
    }
    
    public void setName(String name) {
        this.strName = name;
    }
    
    public double getPrice() {
        return dblPrice;
    }
    
    public void setPrice(double price) {
        this.dblPrice = price;
    }
    
    @Override
    public String toString() {
        return "Item:" + strName + ", Price: $" + dblPrice;
    }
    
}