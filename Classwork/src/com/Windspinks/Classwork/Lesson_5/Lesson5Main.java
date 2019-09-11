package com.Windspinks.Classwork.Lesson_5;

import java.util.Scanner;

public class Lesson5Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String fName;
        String lName;
        int age;
        double height;
        double weight;

        System.out.print("Enter your first name: ");
        fName = scn.nextLine();
        System.out.print("Enter your last name: ");
        lName = scn.nextLine();
        System.out.print("Enter your age: ");
        age = scn.nextInt();
        System.out.print("Enter your height (in feet): ");
        height = scn.nextDouble();
        System.out.print("Enter your weight (in pounds): ");
        weight = scn.nextDouble();

        Form newForm = new Form(fName, lName, age, height, weight);

        try {
            newForm.validate();
        } catch (FormException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
