package com.Windspinks.Classwork.Lesson_5;

public class Form {
    private String firstName;
    private String lastName;
    private int age;
    private double height;
    private double weight;
    private boolean isValidated = false;

    public Form() {
    }

    public Form(String firstName, String lastName, int age, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    public void validate() throws FormException {
        StringBuilder ExceptionMessage = new StringBuilder();
        for (Character c : firstName.toCharArray()) {
            if (Character.isDigit(c)) {
                ExceptionMessage.append("Illegal character in first name: ").append(c).append('\n');
            }
        }

        for (Character c : lastName.toCharArray()) {
            if (Character.isDigit(c)) {
                ExceptionMessage.append("Illegal character in last name: ").append(c).append('\n');
            }
        }

        if (age < 18 || age > 99) {
            ExceptionMessage.append("Illegal age: ").append(age).append('\n');
        }

        if (height < 1 || height > 9) {
            ExceptionMessage.append("Illegal height: ").append(height).append('\n');
        }

        if (weight < 70 || weight > 2000) {
            ExceptionMessage.append("Illegal weight: ").append(weight).append('\n');
        }

        if (ExceptionMessage.length() == 0) {
            isValidated = true;
        } else {
            throw new FormException(ExceptionMessage.toString());
        }
    }
}


/*
String: firstName - can contain only letters, no numbers.
String: lastName - can contain only letters, no numbers
int: age - valid ages are between 18 - 99
double: height - cannot be less than 1 or greater than 9
double: weight - cannot be less than 70 or greater than 2000
boolean: isValidated - false by default
 */