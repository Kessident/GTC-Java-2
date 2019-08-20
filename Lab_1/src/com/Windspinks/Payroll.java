package com.Windspinks;

public class Payroll {
    private static int[] employeeID = {
        5658845,
        4520125,
        7895122,
        8777541,
        8451277,
        1302850,
        7580489 };
    private static int[] hours = new int[7];
    private static double[] payrate = new double[7];
    private static double[] wages = new double[7];

    public int[] getEmployeeIDs() {
        return employeeID;
    }

    public void setHours(int empID, int hoursWorked) {
        int subscript = employeeSubscript(empID);
        if (subscript > -1) {
            hours[subscript] = hoursWorked;
        }
    }
    public double getHours(int empID) {
        int subscript = employeeSubscript(empID);
        if (subscript > -1) {
            return hours[subscript];
        } else {
            return -1;
        }
    }

    public void setPayrate(int empID, double newPayrate){
        int subscript = employeeSubscript(empID);
        if (subscript > -1) {
            payrate[subscript] = newPayrate;
        }
    }
    public double getPayrate(int empID){
        int subscript = employeeSubscript(empID);
        if (subscript > -1) {
            return payrate[subscript];
        } else {
            return -1;
        }
    }

    public double getWages(int empID){
        int subscript = employeeSubscript(empID);
        if (subscript > -1) {
            wages[subscript] = hours[subscript] * payrate[subscript];
            return wages[subscript];
        } else {
            return -1;
        }
    }




    //Returns subscript of @Param empID, else -1
    private int employeeSubscript(int empID) {
        int subscript = -1;
        for (int i = 0; i < employeeID.length; i++) {
            if (employeeID[i] == empID) {
                subscript = i;
            }
        }

        return subscript;
    }
}
