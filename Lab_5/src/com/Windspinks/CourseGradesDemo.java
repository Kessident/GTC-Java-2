package com.Windspinks;
/*
 * Charles Dodge
 * CIST 2372 CRN 23159
 * Lab 05 Course Grades
 */
public class CourseGradesDemo {

    public static void courseDemo() {
        GradedActivity activity = new GradedActivity(85);
        PassFailExam PFExam = new PassFailExam(20, 3, 70);
        GradedActivity essay = new GradedActivity(80);
        FinalExam finalExam = new FinalExam(50, 10);

        CourseGrades grades = new CourseGrades(activity, PFExam, essay, finalExam);

        System.out.println(grades);
    }
}
