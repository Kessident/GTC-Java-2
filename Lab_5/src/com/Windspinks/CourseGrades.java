package com.Windspinks;
/*
 * Charles Dodge
 * CIST 2372 CRN 23159
 * Lab 05 Course Grades
 */
public class CourseGrades {
    private GradedActivity[] grades;

    public CourseGrades() {
        grades = new GradedActivity[4];
    }

    public CourseGrades(GradedActivity lab, PassFailExam PFExam, GradedActivity essay, FinalExam finalExam) {
        grades = new GradedActivity[4];
        grades[0] = lab;
        grades[1] = PFExam;
        grades[2] = essay;
        grades[3] = finalExam;
    }

    public void setLab(GradedActivity lab) {
        grades[0] = lab;
    }

    public void setPassFailExam(PassFailExam PFExam) {
        grades[1] = PFExam;
    }

    public void setEssay(GradedActivity essay) {
        grades[2] = essay;
    }

    public void setFinalExam(FinalExam finalExam) {
        grades[3] = finalExam;
    }

    @Override
    public String toString() {
        return "Lab score: " + grades[0].getScore() + "\tGrade: " + grades[0].getGrade() + '\n' +
            "Pass Fail Exam score: " + grades[1].getScore() + "\tGrade: " + grades[1].getGrade() + '\n' +
            "Essay score: " + grades[2].getScore() + "\tGrade: " + grades[2].getGrade() + '\n' +
            "Final Exam score: " + grades[3].getScore() + "\tGrade: " + grades[3].getGrade() + '\n';
    }
}
