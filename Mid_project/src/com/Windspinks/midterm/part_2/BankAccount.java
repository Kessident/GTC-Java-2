package com.Windspinks.midterm.part_2;

public abstract class BankAccount {
    protected double balance;
    protected int numDeposits;
    protected int numWithdrawals;
    protected double annualInterestRate;
    protected double serviceCharges;

    public BankAccount(double balance, double annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumDeposits() {
        return numDeposits;
    }

    public int getNumWithdrawals() {
        return numWithdrawals;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
        numDeposits++;
    }

    public void withdraw(double withdrawalAmount) {
        balance -= withdrawalAmount;
        numWithdrawals++;
    }

    public void calcInterest() {
        double monthlyInterestRate = annualInterestRate / 12;
        double monthlyInterest = balance * monthlyInterestRate;
        balance += monthlyInterest;
    }

    public void monthlyProcess(){
        balance -= serviceCharges;
        calcInterest();
        numWithdrawals = 0;
        numDeposits = 0;
        serviceCharges = 0;
    }
}
