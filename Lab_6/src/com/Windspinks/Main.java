package com.Windspinks;

public class Main {

    public static void main(String[] args) {
        double[] illegalScores = {20, 170, 10, 28, 42, 78, -38, 61, 87, 32};
        double[] properScores = {53, 93, 56, 6, 29, 8, 44, 22, 80, 59};
        TestScores someIllegal = new TestScores(illegalScores);
        TestScores noIllegals = new TestScores(properScores);

        try {
            System.out.println("Average test score: " + someIllegal.getAverage());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Average test score: " + noIllegals.getAverage());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
