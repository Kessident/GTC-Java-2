package com.Windspinks.midterm.part_3;

public class InvalidIDException extends Exception {
    public InvalidIDException(int invalidID) {
        super("Invalid ID Number entered: " + invalidID);
    }
}
