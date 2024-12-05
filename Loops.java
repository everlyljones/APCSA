/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loops;

/**
 *
 * @author ejones2025
 */

public class Loops {

public static void main(String[] args) {
    System.out.println("a");
    a();
    System.out.println("b");
    b();
    System.out.println("c");
    c();
    System.out.println("d");
    d();
}

public static void a() {
    final int MAX_ROWS = 10;
    for (int row = 1; row <= MAX_ROWS; row++){
        for (int star = 10; star >= row; star--) {
            System.out.print("*");
        }
        System.out.println();
    }
}
public static void b() {
    final int MAX_ROWS = 10;
    for (int row = 1; row <= MAX_ROWS; row++){
        for (int star = 1; star <= row; star++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
public static void c() {
    final int MAX_ROWS = 10;
    for (int row = 1; row <= MAX_ROWS; row++){
        for (int space =1; space <= row; space++){
            System.out.print(" ");
        }
        for (int star = 9; star >= row; star--) {
            System.out.print("*");
        }
        System.out.println();
    }
}
public static void d() {
    final int MAX_ROWS = 5;
    for (int row = 1; row <= MAX_ROWS; row++){
        for (int space =4; space >= row; space--){
            System.out.print("_");
        }
        for (int star = 1; star < (row*2); star++) {
            System.out.print("*");
        }
        System.out.println();
    }
    
    for (int row = 1; row <= MAX_ROWS; row++){
        for (int space =1; space <= row; space++){
            System.out.print("_");
        }
        for (int star = 9; star > (row*2); star--) {
            System.out.print("*");
        }
        System.out.println();
    }
}
}

   