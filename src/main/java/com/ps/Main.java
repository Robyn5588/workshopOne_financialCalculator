package com.ps;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("FINANCIAL CALCULATOR");
        System.out.println("1) Mortgage Calculator");
        System.out.println("2) CD Calculator");
        System.out.println("3) Present Value of Annuity Calculator\n");
        System.out.print("Please Select a Calculator to use: ");
        int giveCommand = scanner.nextInt();

        // All 3 calculators need the principal amount/deposit/monthly payout, interest rate, and the duration of years
        System.out.print("\nEnter the Amount of Money: ");
        float principal = scanner.nextFloat();

        System.out.print("Enter the Interest Rate: ");
        float interestRate = (scanner.nextFloat() / 100);

        System.out.print("Enter the Duration of Years: ");
        int duration = scanner.nextInt();

        // Results are not put here because each case has 1 or 2 unique results

        switch(giveCommand){
            case 1:
                int numMoPayments = 12 * duration;
                float moInterestRate = interestRate / 12;
                float moPayments = (float) (principal * ( moInterestRate * Math.pow((1+moInterestRate),numMoPayments)) / (Math.pow((1 + moInterestRate), numMoPayments ) - 1));
                float totalInterest = (moPayments * numMoPayments) - principal;

                System.out.printf("%nThe Total Monthly Payment is: $%.2f%n", moPayments);
                System.out.printf("The Total Interest Rate is: $%.2f%n", totalInterest);
                break;
            case 2: //  Added leap year calculations
                System.out.print("\n Enter the Current Year: ");
                int currentYear =  scanner.nextInt();
                float futureValue = 0;
                float currentAmount = principal;
                int finalYear = currentYear + duration;
                while (currentYear < finalYear)
                {
                    if (currentYear % 4 == 0)
                    {
                        futureValue = (float) (currentAmount * Math.pow((1 + (interestRate / 366)), (366)));
                    }
                    else
                    {
                        futureValue = (float) (currentAmount * Math.pow((1 + (interestRate / 365)), (365)));
                    }
                    currentAmount = futureValue;
                    currentYear++;
                }
                //float futureValue = (float) ( principal * Math.pow((1+(interestRate / 365)),(365 * duration)));
                float interestEarned = (futureValue - principal);

                System.out.printf("%nThe Future Value is: $%.2f%n", futureValue);
                System.out.printf("The Interest Earned is: $%.2f%n", interestEarned);
                break;
            case 3:
                int totalNumPeriod = 12 * duration;
                float periodInterestRate = interestRate / 12;
                float presentValue = (float) (principal * ((1 - Math.pow((1 + periodInterestRate), -totalNumPeriod)) / periodInterestRate));

                System.out.printf("%nThe Present Value of the Annuity is: $%.2f%n", presentValue);
                break;
            default:
                System.out.println("\nInvalid option, Try Again");
        }


    }
}