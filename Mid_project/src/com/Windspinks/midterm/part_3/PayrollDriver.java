package com.Windspinks.midterm.part_3;

import java.util.Scanner;

public class PayrollDriver {
    public static void run() {
        String empName;
        int empID;
        double hourlyRate;
        double hoursWorked;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee's name: ");
        empName = input.nextLine();
        System.out.print("Enter employee's ID number: ");
        empID = input.nextInt();
        System.out.print("Enter employee's hourly rate: ");
        hourlyRate = input.nextDouble();
        System.out.print("Enter hours worked: ");
        hoursWorked = input.nextDouble();

        Payroll emp1 = new Payroll(empName, empID);
        emp1.setHourlyRate(hourlyRate);
        emp1.setHoursWorked(hoursWorked);

        System.out.printf("Employee %d, name %s, has worked %.2f hours at $%.2f/hr, for a gross total of $%.2f",
            emp1.getIdNum(), emp1.getEmpName(), emp1.getHoursWorked(), emp1.getHourlyRate(), emp1.getGrossPay());
    }


}
