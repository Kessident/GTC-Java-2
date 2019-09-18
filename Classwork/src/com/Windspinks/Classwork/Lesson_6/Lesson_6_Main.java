package com.Windspinks.Classwork.Lesson_6;

import javax.swing.*;

public class Lesson_6_Main {

    public static void main(String[] args) {
        String input;
        input = JOptionPane.showInputDialog("Enter something");
        int moreInput = Integer.parseInt(input);
        if (input == null || input.length() == 0) {
            System.out.println("How rude of you");
        } else {
            System.out.println("Would you look at that? " + input);
        }

        System.exit(0);
    }
}
