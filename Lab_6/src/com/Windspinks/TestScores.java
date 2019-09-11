package com.Windspinks;

public class TestScores {
    double[] testScores;

    public TestScores() {
        testScores = new double[0];
    }

    public TestScores(double[] scores) {
        testScores = scores;

    }

    public double getAverage() {
        double average = 0;
        for (double d : testScores) {
            if (d < 0 || d > 100) {
                throw new InvalidTestScore(d);
            }
            average += d;
        }
        average /= testScores.length;

        return average;
    }
}
