package com.Windspinks.midterm.part_3;

public class InvalidHoursWorkedException extends Exception {
    public InvalidHoursWorkedException(double invalidHours) {
        super("Invalid hours, must be between 0 and 84: " + invalidHours);
    }
}
