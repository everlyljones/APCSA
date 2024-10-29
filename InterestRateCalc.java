/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interestratecalc;

/**
 *
 * @author ejones2025
 */
import java.util.Scanner;
import java.text.NumberFormat;

public class InterestRateCalc { 
public static void main(String[] args) { 
    // Scanner for user input 
    Scanner scanner = new Scanner(System.in);

    // Prompt user for loan amount 
    System.out.print("Enter the financial amount (e.g., 1000000): "); 
    double amount = scanner.nextDouble();

    // Create an instance of InterestRateCalculator 
    InterestRateCalculator calculator = new InterestRateCalculator();

    // Calculate amount with interest 
    double totalWithInterest = calculator.calculateTotalWithInterest(amount); 

    // Prompt user for number of months for repayment System.out.print("Enter the number of months for repayment: "); 
    int months = scanner.nextInt(); 

    calculator.displayRepaymentSchedule(totalWithInterest, months);
    System.out.println(calculator.getResult());
 }
}




// File: InterestRateCalculator.java

class InterestRateCalculator {
    // Public constant RATE (interest rate)
    public static final double RATE = 0.035; // 3.5% interest rate
    private String result = "";
    // Method to calculate total amount with interest added initially
    public double calculateTotalWithInterest(double principal) {
        return principal * (1 + RATE);
    }

    // Method to display repayment schedule with monthly breakdown
    public void displayRepaymentSchedule(double totalWithInterest, int months) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        
        percentFormat.setMinimumFractionDigits(1);
        double remainingBalance = totalWithInterest;
        double totalPaid = 0.0;
        result = "\nRepayment Schedule:";
        //System.out.println("\nRepayment Schedule:"); 
        result = result + "\n" + "Interest Rate: " + percentFormat.format(RATE) + "-------------------------------------------------";
        //System.out.println("Interest Rate: " + percentFormat.format(RATE));
        //System.out.println("-------------------------------------------------");

        for (int month = 1; month <= months; month++) {
            double monthlyPayment = remainingBalance / months;
            double interest = monthlyPayment * RATE;
            double totalMonthlyPayment = monthlyPayment + interest;

            // Update total paid and remaining balance
            totalPaid += totalMonthlyPayment;
            remainingBalance -= monthlyPayment;

            //System.out.printf("Month %d: Payment: %s, Total Paid So Far: %s%n",
                    //month, currencyFormat.format(totalMonthlyPayment),
                    //currencyFormat.format(totalPaid));
            result = result + "\nMonth %d: Payment: %s, Total Paid So Far: %s%n" + currencyFormat.format(totalMonthlyPayment) + " " + currencyFormat.format(totalPaid);
            // Reduce months left for calculation purposes
            months--;
        }
        
        //System.out.println("-------------------------------------------------");
        //System.out.println("Final Total Paid: " + currencyFormat.format(totalPaid));
    }
    public String getResult (){
        return result;
    }
}
