/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.randomnumberprogramming;

import java.util.Random;

/**
 *
 * @author ejones2025
 */
public class RandomNumberProgramming {

    public static void main(String[] args) {
        Random generator = new Random();
        int num1;
        int num2;
        int num3;
        num1 = generator.nextInt(8);
        num2 = generator.nextInt(8);
        num3 = generator.nextInt(8);
        
        int num4;
        String strN4 = "";
        num4 = generator.nextInt(655);
        if(num4<10){
            strN4="00" + num4;
        } else if (num4<100){
            strN4="0" + num4;
        } else {
            strN4="" + num4;
        }
        int num5;
        int num6;
        int num7;
        int num8;
        num5 = generator.nextInt(10);
        num6 = generator.nextInt(10);
        num7 = generator.nextInt(10);
        num8 = generator.nextInt(10);
        
        System.out.println("A random float: " + num1 + num2 + num3 + "-" + strN4 + "-" + num5 + num6 + num7 + num8);
    }

}