package com.Windspinks;
/*
 * Charles Dodge
 * CIST 2372 CRN 23159
 * Lab 05 Course Grades
 */
public class PassFailActivity extends GradedActivity {
    private double minPassingScore;

    public PassFailActivity(double minPassingScore) {
        this.minPassingScore = minPassingScore;
    }

    @Override
    public char getGrade() {
        if (getScore() >= minPassingScore) {
            return 'P';
        } else {
            return 'F';
        }
    }
}
