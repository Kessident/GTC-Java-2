package com.Windspinks;

public class EmployeeDriver {

    public static void employeeDemo() {
        Employee emp1 = new Employee("Susan Meyers", 47899, "Accounting", "Vice President");
        Employee emp2 = new Employee("Mark Jones", 39119);
        emp2.setDepartment("IT");
        emp2.setPosition("Programmer");
        Employee emp3 = new Employee();
        emp3.setName("Joy Rogers");
        emp3.setIdNumber(81774);
        emp3.setDepartment("Manufacturing");
        emp3.setPosition("Engineer");

        System.out.printf("%-16s %-13s %-17s %s\n", "Name", "ID Number", "Department", "Position");
        System.out.printf("%-16s %-13s %-17s %s\n", emp1.getName(), emp1.getIdNumber(), emp1.getDepartment(), emp1.getPosition());
        System.out.printf("%-16s %-13s %-17s %s\n", emp2.getName(), emp2.getIdNumber(), emp2.getDepartment(), emp2.getPosition());
        System.out.printf("%-16s %-13s %-17s %s\n", emp3.getName(), emp3.getIdNumber(), emp3.getDepartment(), emp3.getPosition());
    }
}
