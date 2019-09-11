package com.Windspinks;

public class InvalidTestScore extends IllegalArgumentException {
    InvalidTestScore(double d) {
        super("Illegal test score: " + d);
    }
}
