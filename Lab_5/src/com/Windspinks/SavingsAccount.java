package com.Windspinks;

public class SavingsAccount extends BankAccount {
    private boolean isActive;

    @Override
    public void withdraw(double withdrawAmount) {
        if (isActive) {
            super.withdraw(withdrawAmount);
        }

        if (balance < 25) {
            isActive = false;
        }
    }

    @Override
    public void deposit(double depositAmount) {
        super.deposit(depositAmount);

        if (!isActive && balance > 25) {
            isActive = true;
        }
    }

    @Override
    public void monthlyProcess() {
        if (numWithdrawals > 4) {
            monthlyServiceFees = numWithdrawals - 4;
        }
        super.monthlyProcess();

        if (balance < 25) {
            isActive = false;
        }
    }
}
