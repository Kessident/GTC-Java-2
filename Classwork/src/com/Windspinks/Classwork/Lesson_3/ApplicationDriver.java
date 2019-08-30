package com.Windspinks.Classwork.Lesson_3;

import java.util.Formatter;
import java.util.Scanner;

public class ApplicationDriver {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Please enter your first name. ");
        String firstName = capitalize(scn.nextLine());


        System.out.println("Please enter your last name. ");
        String lastName = capitalize(scn.nextLine());

        System.out.println("Please enter your age. ");
        int age = scn.nextInt();

        System.out.println("Please enter your gender as a single character. ");
        Character gender = scn.next().toUpperCase().charAt(0);

        //Consume newline
        scn.nextLine();

        System.out.println("Please enter the first name for each sibling you have. Separate the names with a space. ");
        String temp = scn.nextLine();
        String[] siblings;
        if (temp.length() > 0) {
            siblings = temp.split(" ");
            capitalize(siblings);
        } else {
            siblings = new String[0];
        }

        System.out.println("Please enter the first name for each parent. Separate the names with a space. ");
        String[] parents = scn.nextLine().split(" ");
        capitalize(parents);

        Application classwork = new Application(firstName, lastName, age, gender, siblings, parents);

        StringBuilder theBigOne = new StringBuilder();
        Formatter formatting = new Formatter(theBigOne);
//        theBigOne.append("Hello " + classwork.getFirstName() + " " + classwork.getLastName());
        formatting.format("Hello %s %s!\n", classwork.getFirstName(), classwork.getLastName());
        formatting.format("You're looking well for a %s of %d years. I'm sure %s ", classwork.getGenderFull(), classwork.getAge(), classwork.getParents()[0]);
        for (int i = 1; i < classwork.getParents().length; i++) {
            formatting.format("and %s ", classwork.getParents()[i]);
        }

        formatting.format("would be very proud if they could see you right now. ");
        formatting.format("I'm also sure that ");
        //If Siblings
        if (classwork.getSiblings().length > 0) {
            formatting.format("%s", classwork.getSiblings()[0]);

            //If 3+ Siblings use commas
            if (classwork.getSiblings().length > 2) {
                //All but last sibling
                formatting.format(", %s,", classwork.getSiblings()[1]);
                for (int i = 2; i < classwork.getSiblings().length - 1; i++) {
                    formatting.format(" %s,", classwork.getSiblings()[i]);
                }
            }

            //If 2+ siblings, use "and sibling" for last
            if (classwork.getSiblings().length > 1) {
                formatting.format(" and %s", classwork.getSiblings()[classwork.getSiblings().length - 1]);
            }
            formatting.format(" would cheer you on in your quest to conquer Java!");
        } else { //No Siblings
            formatting.format("they would cheer you on in your quest to conquer Java!");
        }


        System.out.println(formatting);

    }

    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    private static void capitalize(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > 0) {
                array[i] = capitalize(array[i]);
            }
        }
    }
}
