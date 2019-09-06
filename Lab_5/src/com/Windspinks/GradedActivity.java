package com.Windspinks;

public class GradedActivity {
    private double score;

    public GradedActivity() {
    }

    public GradedActivity(double score) {
        this.score = score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public char getGrade() {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
