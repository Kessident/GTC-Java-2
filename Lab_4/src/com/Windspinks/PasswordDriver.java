package com.Windspinks;

import java.util.Scanner;

public class PasswordDriver {
    public static void passwordDemo() {
        Scanner scn = new Scanner(System.in);
        System.out.println("This program will check if an entered password is valid");
        System.out.println("A valid password has at least 6 characters, and at least 1 uppercase, 1 lowercase, and 1 digit");
        System.out.print(">>> ");

        String newPassString = scn.nextLine();

        Password password = new Password(newPassString);

        if (password.isValid()){
            System.out.println("That is a valid password");
        } else {
            System.out.println("That is not a valid password");
        }
    }
}
