package com.Windspinks;

import java.util.Scanner;

public class SumOfDigits {
    public static void sumOfDigits() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter a series of single digit numbers with no spaces (Ex. 650435)");
        System.out.println("This program will give you the sum of all digits entered, as well as highest and lowest");
        System.out.print(">>> ");
        String digitString = scn.nextLine();

        int total = 0;
        int lowest = Integer.parseInt(digitString.substring(0, 1));
        int highest = Integer.parseInt(digitString.substring(0, 1));

        for (Character c : digitString.toCharArray()) {
            if (c >= '0' && c <= '9') {
                int intChar = c - '0';

                //ASCII form to "actual" digit
                total += intChar;

                if (intChar < lowest) {
                    lowest = intChar;
                } else if (intChar > highest) {
                    highest = intChar;
                }
            } else {
                System.out.println("Invalid character.");
            }
        }

        System.out.printf("total is %d, lowest digit is %d, highest digit is %d", total, lowest, highest);
    }
}
