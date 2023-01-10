package com.example.projectt;

public class CheckingAccount extends Account {
    private double monthlyFee;

    public CheckingAccount(String accountNumber, double balance, double monthlyFee) {
        super(accountNumber, balance);
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void updateBalance() {
        balance -= monthlyFee;
    }
}
