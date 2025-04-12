package com.ps;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("FINANCIAL CALCULATOR");
        System.out.println("1) Mortgage Calculator ");
        System.out.println("2) CD Calculator");
        System.out.print("Please Select a Calculator to use: ");
        int giveCommand = scanner.nextInt();

        // The first two calculators need the principal/deposit, interest rate, and the duration of time
        System.out.print("Enter the Principal Amount: ");
        float principal = scanner.nextFloat();

        System.out.print("Enter the Interest Rate: ");
        float interestRate = (scanner.nextFloat() / 100);

//        System.out.println("value of interest rate is: " + interestRate);

        System.out.print("Enter the Duration of Years: ");
        int duration = scanner.nextInt();

        // Results are not put here because each case has 2 unique results

        switch(giveCommand){
            case 1:
                int numMoPayments = 12 * duration;
                float moInterestRate = interestRate / 12;
                float moPayments = (float) (principal * ( moInterestRate * Math.pow((1+moInterestRate),numMoPayments)) / (Math.pow((1 + moInterestRate), numMoPayments ) - 1));
                float totalInterest = (moPayments * numMoPayments) - principal;

                System.out.println("The Total Monthly Payment is: $" + moPayments);
                System.out.println("The Total Interest Rate is: $" + totalInterest);
                break;
            case 2:
                float futureValue = (float) ( principal * Math.pow((1+(interestRate / 365)),(365 * duration)));
                float interestEarned = (futureValue - principal);

                System.out.println("The Future Value is: $" + futureValue);
                System.out.println("The Interest Earned is: $" + interestEarned );
                break;
            default:
                System.out.println("Invalid option");
        }


    }
}