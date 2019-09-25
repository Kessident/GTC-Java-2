package com.Windspinks;
/*
 * Charles Dodge
 * CIST 2372 CRN 23159
 * Lab 7
 */
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("---Uppercase File Converter---");
        UppercaseFileConverter.run();

        System.out.println("\n---FileArray---");
        fileArrayTest();
    }

    private static void fileArrayTest() {

        int[] someNumbers = {1, 2, 3, 4, 5};
        File fileArrayFile = new File("fileArray.dat");

        try {
            FileArray.writeArray(fileArrayFile, someNumbers);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        int[] thoseSameNumbers = new int[5];
        try {
            System.out.println("int array size 5");
            FileArray.readArray(fileArrayFile, thoseSameNumbers);
            Arrays.stream(thoseSameNumbers).forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        int[] arrayTooBig = new int[10];
        try {
            System.out.println("int array size 10");
            FileArray.readArray(fileArrayFile, arrayTooBig);
            Arrays.stream(arrayTooBig).forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        int[] arrayTooSmall = new int[3];
        try {
            System.out.println("int array size 3");
            FileArray.readArray(fileArrayFile, arrayTooSmall);
            Arrays.stream(arrayTooSmall).forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
