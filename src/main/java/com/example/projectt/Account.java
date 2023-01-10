package com.example.projectt;

public abstract class Account extends Bank{
    // instance variables
    protected String accountNumber;
    protected double balance;

    // constructor
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // methods
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void updateBalance();
}

