/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.radiuscalc;

/**
 *
 * @author ejones2025
 */
import java.util.Scanner;

public class RadiusCalc {

    /**
     * @param args the command line arguments
     */
    //carry out calculations for circular items
    //such as a circle, a sphere, a cone, a column
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program calculates round item numbers such as \n" +
                "1 - Area of a circle (pi r^2)\n" +
                "2 - Volume of a sphere (4/3 pi r^3)\n" +
                "3 - Volume of a cone (pi r^2 h/3)\n" +
                "4 - Volume of a column (pi r^2 h)");
        System.out.println("Type the number for which one you want to calculate");
        
        int i = scanner.nextInt();
        if (i == 1){
            cCalc(scanner); 
        }else if (i == 2){
            sCalc(scanner);  
        }else if(i == 3){
            cCalc2(scanner);
        }else if(i == 4){
            cCalc3(scanner); 
        }
    }

    public static void cCalc3(Scanner s){
        System.out.println("enter the radius of your cone, then height of your cone");
        int r = s.nextInt();
        int h = s.nextInt();
        double result = Math.PI * Math.pow(r, 2) * h;
        System.out.println("Volume of the column: " + result);
    }

    public static void cCalc2(Scanner s){
        System.out.println("enter the radius of your cone, then height of your cone");
        int r = s.nextInt();
        int h = s.nextInt();
        double result = (Math.PI * Math.pow(r, 2) * h) / 3;
        System.out.println("Volume of the cone: " + result);
    }

    public static void cCalc(Scanner s){
        System.out.println("enter the radius of your circle:");
        int r = s.nextInt();
        double result = Math.PI * Math.pow(r, 2);
        System.out.println("Area of the circle: " + result);
    }

    public static void sCalc(Scanner s){
        System.out.println("enter the radius of your sphere:");
        int r = s.nextInt();
        double result = (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
        System.out.println("Volume of the sphere: " + result);
    }
}
