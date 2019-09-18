package com.Windspinks.Classwork.Lesson_6;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private double balance;
    private String firstName;
    private String lastName;
    private ArrayList<String> transactions;

    public Account(double balance, String firstName, String lastName) {
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
            "balance=" + balance +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", transactions=" + transactions +
            '}';
    }
}
