package com.Windspinks;

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
