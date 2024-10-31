/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mathclass;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ejones2025
 */
public class MathClass {

    public static void main(String[] args) {
        Random generator = new Random();
        int num1;
        double roundedsin = 0.0;
        double roundedcos = 0.0;
        double roundedtan = 0.0;
        num1 = generator.nextInt(91);
        
        roundedsin = Math.sin(num1);
        roundedcos = Math.cos(num1);
        roundedtan = Math.tan(num1);
        
        roundedsin = roundAvoid(roundedsin, 3);
        roundedcos = roundAvoid(roundedcos, 3);
        roundedtan = roundAvoid(roundedtan, 3);
        System.out.println("Number:" + num1 + " Sine: " + roundedsin + " Cosine: " + roundedcos + " Tanget: " + roundedtan);
   
        
        int num2;
        num2 = generator.nextInt(19) + 1;
        int r = num2;
        double roundedarea = 0.0;
        double roundedvolume = 0.0;
        
        roundedarea = Math.PI * (r * r);
        roundedvolume = Math.PI * (r * r * r) * 4/3;
                
        roundedarea = roundAvoid(roundedarea, 3);
        roundedvolume = roundAvoid(roundedvolume, 3);
        
        System.out.println("Radius:" + num2 + " Area: " + roundedarea + " Volume: " + roundedvolume);
        
        
        int num3;
        num3 = generator.nextInt(99999000) + 1000;
        double roundedlog10 = 0.0;
        double roundednaturallog = 0.0;
        double roundedsquaredroot = 0.0;
        
        roundedlog10 = Math.log10(num3);
        roundednaturallog = Math.log(num3);
        roundedsquaredroot = Math.pow(num3, .5);
        
        
        roundedlog10 = roundAvoid(roundedlog10, 5);
        roundednaturallog = roundAvoid(roundednaturallog, 5);
        roundedsquaredroot = roundAvoid(roundedsquaredroot, 5);
        
        System.out.println("Number:" + num3 + " Squared Root:" + roundedsquaredroot + " Natural Log:" + roundednaturallog + " Log10:" + roundedlog10);
       
        int num4;
        num4 = generator.nextInt(999999999);
        long c = 299792458;
        double roundedmass = 0.0;
        //roundedmass = Math.divideExact(num3, c);
        //roundedmass = roundAvoid(roundedmass, 10);
        System.out.println("Number:" + num4 + " Mass:" + roundAvoid((num4/(c*c)), 19));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a real number: ");
        double realNumber = scanner.nextDouble();
        System.out.print("Enter an integer: ");
        int exponent = scanner.nextInt();
        System.out.print("Enter the number of decimal places for rounding: ");
        int decimalPlaces = scanner.nextInt();
        double result = Math.pow(realNumber, exponent);
        double roundedResult = Math.round(result * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
        System.out.printf("Result: %.2f%n", roundedResult);
        
        scanner.close();
        
    }
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
   