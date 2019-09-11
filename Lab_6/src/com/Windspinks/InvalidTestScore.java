package com.Windspinks;
/*
 * Charles Dodge
 * CIST 2372 CRN 23159
 * Lab 6 TestScores
 */
public class InvalidTestScore extends IllegalArgumentException {
    InvalidTestScore(double d) {
        super("Illegal test score: " + d);
    }
}
