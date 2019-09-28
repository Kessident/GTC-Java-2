package com.Windspinks.midterm.part_3;

public class InvalidNameException extends Exception {
    public InvalidNameException() {
        super("Invalid name entered: Empty String");
    }
}
