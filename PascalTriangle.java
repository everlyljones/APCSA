/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pascaltriangle;

/**
 *
 * @author ejones2025
 */
import java.util.*;

public class PascalTriangle {
    // Recursive function to compute the Nth row of Pascal's Triangle
    public static List<Integer> getPascalRow(int n) {
        if (n == 0) {
            return Arrays.asList(1);
        }
        List<Integer> prevRow = getPascalRow(n - 1);
        List<Integer> newRow = new ArrayList<>();
        
        newRow.add(1); // First element is always 1
        for (int i = 0; i < prevRow.size() - 1; i++) {
            newRow.add(prevRow.get(i) + prevRow.get(i + 1)); // Sum of adjacent elements
        }
        newRow.add(1); // Last element is always 1
        
        return newRow;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the row number: ");
        int N = scanner.nextInt();
        scanner.close();
        
        System.out.println("Row " + N + " of Pascal's Triangle: " + getPascalRow(N));
    }
}
10