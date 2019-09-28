package com.Windspinks.midterm.part_3;

public class Payroll {
    private String empName;
    private int idNum;
    private double hourlyRate;
    private double hoursWorked;

    public Payroll(String empName, int idNum) throws InvalidNameException, InvalidIDException {
        if (empName == null || empName.trim().isEmpty()) {
            throw new InvalidNameException();
        }
        this.empName = empName;
        if (idNum <= 0) {
            throw new InvalidIDException(idNum);
        }
        this.idNum = idNum;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) throws InvalidNameException {
        if (empName == null || empName.trim().isEmpty()) {
            throw new InvalidNameException();
        }
        this.empName = empName;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) throws InvalidIDException {
        if (idNum <= 0) {
            throw new InvalidIDException(idNum);
        }
        this.idNum = idNum;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) throws InvalidHourlyRateException {
        if (hourlyRate < 0 || hourlyRate > 25) {
            throw new InvalidHourlyRateException(hourlyRate);
        }
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) throws InvalidHoursWorkedException {
        if (hoursWorked < 0 || hoursWorked > 84) {
            throw new InvalidHoursWorkedException(hoursWorked);
        }
        this.hoursWorked = hoursWorked;
    }

    public double getGrossPay() {
        return hourlyRate * hoursWorked;
    }
}
