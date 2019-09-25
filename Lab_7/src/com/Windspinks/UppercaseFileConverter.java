package com.Windspinks;
/*
 * Charles Dodge
 * CIST 2372 CRN 23159
 * Lab 7 Uppercase File Converter
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class UppercaseFileConverter {

    public static void run() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the location of a file to read from: ");
        File inputFilePath = new File(userInput.nextLine());
        Scanner inputFileScanner = null;

        while (inputFileScanner == null) {
            try {
                inputFileScanner = new Scanner(inputFilePath);
            } catch (FileNotFoundException ex) {
                System.out.println(inputFilePath + " does not exist.");
                System.out.print("Please enter a valid file path: ");
                inputFilePath = new File(userInput.nextLine());
            }
        }

        System.out.print("Enter the location of a file to write to: ");
        File outputFilePath = new File(userInput.nextLine());

        PrintWriter outputFile = null;
        while (outputFile == null) {
            try {
                outputFile = new PrintWriter(outputFilePath);
            } catch (FileNotFoundException ex) {
                System.out.print("File error, Enter another location: ");
                outputFilePath = new File(userInput.nextLine());
            }
        }

        while (inputFileScanner.hasNext()) {
            outputFile.println(inputFileScanner.nextLine().toUpperCase());
        }
        inputFileScanner.close();
        outputFile.close();
    }
}
