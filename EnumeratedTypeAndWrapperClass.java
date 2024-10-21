/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.enumeratedtypeandwrapperclass;

/**
 *
 * @author ejones2025
 */
public class EnumeratedTypeAndWrapperClass {

    enum Week {Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday}
    enum Year {January, Febuary, March, April, May, June, July, August, September, October, November, December}
    
    public static void main(String[] args) {
        Week day1, day2, day3, day4, day5, day6, day7;
        day1 = Week.Monday;
        day2 = Week.Tuesday;
        day3 = Week.Wednesday;
        day4 = Week.Thursday;
        day5 = Week.Friday;
        day6 = Week.Saturday;
        day7 = Week.Sunday;
        
        Year month1, month2, month3, month4, month5, month6, month7, month8, month9, month10, month11, month12;
        month1 = Year.January;
        month2 = Year.Febuary;
        month3 = Year.March;
        month4 = Year.April;
        month5 = Year.May;
        month6 = Year.June;
        month7 = Year.July;
        month8 = Year.August;
        month9 = Year.September;
        month10 = Year.October;
        month11 = Year.November;
        month12 = Year.December;
        
        int num1;
        num1 = (2025);
        
        System.out.println("Day 1:" + day1);
        System.out.println("Day 2:" + day2); 
        System.out.println("Day 3:" + day3);
        System.out.println("Day 4:" + day4); 
        System.out.println("Day 5:" + day5);
        System.out.println("Day 6:" + day6);
        System.out.println("Day 7:" + day7);
        System.out.println( );
        System.out.println("Month 1:" + month1);
        System.out.println("Month 2:" + month2);
        System.out.println("Month 3:" + month3);
        System.out.println("Month 4:" + month4);
        System.out.println("Month 5:" + month5);
        System.out.println("Month 6:" + month6);
        System.out.println("Month 7:" + month7);
        System.out.println("Month 8:" + month8);
        System.out.println("Month 9:" + month9);
        System.out.println("Month 10:" + month10);
        System.out.println("Month 11:" + month11);
        System.out.println("Month 12:" + month12);
        System.out.println( );
        System.out.println("ejones" + num1 + "@cchsdons.com");
        System.out.println("In computer language, you graduate in: "+ num1);
       
        
    }
}
