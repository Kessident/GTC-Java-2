package com.Windspinks;

public abstract class BankAccount {
    protected double balance;
    protected int numDeposits;
    protected int numWithdrawals;
    protected double annualInterestRate;
    protected double monthlyServiceFees;

    public BankAccount() {
    }

    public BankAccount(double balance_, double annualInterestRate_) {
        this.balance = balance_;
        this.annualInterestRate = annualInterestRate_;
    }

    public void deposit (double depositAmount) {
        balance += depositAmount;
        numDeposits++;
    }

    public void withdraw(double withdrawAmount) {
        balance -= withdrawAmount;
        numWithdrawals++;
    }

    public void calcInterest() {
        double monthlyInterestRate = annualInterestRate / 12.0;
        double monthlyInterest = balance * monthlyInterestRate;
        balance += monthlyInterest;
    }

    public void monthlyProcess() {
        balance -= monthlyServiceFees;
        calcInterest();
        numDeposits = 0;
        numWithdrawals = 0;
        monthlyServiceFees = 0;
    }
}
