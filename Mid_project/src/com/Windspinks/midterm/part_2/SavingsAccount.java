package com.Windspinks.midterm.part_2;

public class SavingsAccount extends BankAccount {
    private boolean isActive;

    public SavingsAccount(double balance, double annualInterestRate) {
        super(balance, annualInterestRate);
    }

    @Override
    public void deposit(double depositAmount) {
        super.deposit(depositAmount);
        isActive = getBalance() > 25;
    }

    @Override
    public void withdraw(double withdrawalAmount) {
        if (isActive) {
            super.withdraw(withdrawalAmount);
        }
    }

    @Override
    public void monthlyProcess() {
        serviceCharges += (numWithdrawals - 4);
        super.monthlyProcess();
        if (balance < 25) {
            isActive = false;
        }
    }
}
