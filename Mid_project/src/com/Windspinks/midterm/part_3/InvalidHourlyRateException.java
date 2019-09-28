package com.Windspinks.midterm.part_3;

public class InvalidHourlyRateException extends Exception {
    public InvalidHourlyRateException(double hourlyRate) {
        super("Invalid hourly rate entered, must be between 0 and 25: " + hourlyRate);
    }
}
