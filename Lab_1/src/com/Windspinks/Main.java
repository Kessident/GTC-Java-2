package com.Windspinks;

import java.util.Scanner;

/*
 * Charles Dodge
 * CIST 2372 CRN 23159
 * Lab
 */
public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int selection = 0;

        System.out.println("Lab 1");
        while (true) {
            System.out.println("\t1 - Bank Charges");
            System.out.println("\t2 - Population");
            System.out.println("\t3 - Test Average");
            System.out.println("\t4 - Payroll");

            selection = input.nextInt();

            switch (selection) {
                case 1:
                    bankCharges();
                    break;
                case 2:
                    population();
                    break;
                case 3:
                    testAverage();
                    break;
                case 4:
                    payroll();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    public static void bankCharges() {
        int monthlyFee = 10;
        int checksWritten = 0;

        System.out.print("How many checks were written this month? ");
        checksWritten = input.nextInt();

        double checkFee = 0;
        if (checksWritten >= 60) {
            int checksOver60 = checksWritten - 60;
            checkFee += checksOver60 * 0.04;

            checksWritten -= checksOver60;
        }

        if (checksWritten >= 40) {
            int checksOver40 = checksWritten - 40;
            checkFee += checksOver40 * 0.06;

            checksWritten -= checksOver40;
        }

        if (checksWritten >= 20) {
            int checksOver20 = checksWritten - 20;
            checkFee += checksOver20 * 0.08;

            checksWritten -= checksOver20;
        }

        checkFee += checksWritten * 0.10;

        checkFee += monthlyFee;

        System.out.printf("The check fee for this month is $%.2f.\n\n", checkFee);
    }

    public static void population() {
        int numOrganisms, daysToMultiply;
        double averageDailyIncrease;

        System.out.print("Enter starting number of organisms: ");
        numOrganisms = input.nextInt();
        while (numOrganisms < 2) {
            System.out.print("Starting number must be at least 2: ");
            numOrganisms = input.nextInt();
        }

        System.out.print("Enter average daily increase as percentage: ");
        averageDailyIncrease = input.nextDouble();
        while (averageDailyIncrease < 0) {
            System.out.print("Average daily increase must not be negative: ");
            averageDailyIncrease = input.nextDouble();
        }

        //Convert percentage increase to decimal, add 100% for easier maths
        averageDailyIncrease /= 100.0;
        averageDailyIncrease++;

        System.out.print("Enter number of days to let organisms multiply: ");
        daysToMultiply = input.nextInt();
        while (daysToMultiply < 1) {
            System.out.print("Days to multiply must be at least 1");
            daysToMultiply = input.nextInt();
        }

        System.out.println("\n\tDay 0");
        System.out.printf("Number of organisms: %d\n", numOrganisms);

        for (int i = 1; i <= daysToMultiply; i++) {
            numOrganisms *= averageDailyIncrease;

            System.out.println("\tDay " + i);
            System.out.printf("Number of organisms: %d\n", numOrganisms);
        }
    }

    public static void testAverage() {
        double[] testScores = new double[5];

        System.out.println("Enter 5 test scores");
        for (int i = 0; i < 5; i++) {
            System.out.print("Test score " + (i + 1) + ": ");
            testScores[i] = input.nextDouble();
        }
        double averageTestScore = calcAverage(testScores[0], testScores[1], testScores[2], testScores[3], testScores[4]);
        char averageTestLetter = determineGrade(averageTestScore);

        System.out.println("The average test score is: " + averageTestScore + "(" + averageTestLetter + ")");

        System.out.println("Score \t Letter Grade");
        for (int i = 0; i < 5; i++) {
            System.out.println(testScores[i] + "\t\t" + determineGrade(testScores[i]));
        }
        System.out.println();
    }

    private static double calcAverage(double score1, double score2, double score3, double score4, double score5) {
        return (score1 + score2 + score3 + score4 + score5) / 5;
    }

    private static char determineGrade(double score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void payroll() {
        Payroll payrollObj = new Payroll();
        int hoursWorked;
        double payRate;

        for (int empID: payrollObj.getEmployeeIDs()){
            System.out.print("Enter employee " + empID + "'s hours: ");
            hoursWorked = input.nextInt();
            while (hoursWorked < 0) {
                System.out.print("Hours worked must not be negative: ");
                hoursWorked = input.nextInt();
            }
            payrollObj.setHours(empID, hoursWorked);

            System.out.print("Enter employee " + empID + "'s pay rate: ");
            payRate = input.nextInt();
            while (payRate < 6) {
                System.out.print("Pay rate worked must be at least 6.00: ");
                payRate = input.nextInt();
            }
            payrollObj.setPayrate(empID, payRate);
        }

        System.out.println("EmployeeID\t\t Gross Wages");
        for (int empID : payrollObj.getEmployeeIDs()) {
            System.out.printf("%d \t\t %.2f\n", empID, payrollObj.getWages(empID));
        }
    }
}
