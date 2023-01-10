package com.example.projectt;

import java.util.ArrayList;
import java.util.List;



public class Bank {
    private final List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void updateAccountBalances() {
        for (Account account : accounts) {
            account.updateBalance();
        }
    }

    public double getTotalBalance() {
        double total = 0.0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
}
