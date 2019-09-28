package com.Windspinks.midterm.part_3;

public class Payroll {
    private String empName;
    private int idNum;
    private double hourlyRate;
    private double hoursWorked;

    public Payroll(String empName, int idNum) {
        this.empName = empName;
        this.idNum = idNum;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getGrossPay() {
        return hourlyRate * hoursWorked;
    }
}
