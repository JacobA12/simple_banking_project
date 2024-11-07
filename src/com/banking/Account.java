package com.banking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountNumber;
    private String accountHolder;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public Account(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = new BigDecimal("0.0");
        this.transactions = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        transactions.add(new Transaction("deposit", amount));
    }

    public boolean withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            transactions.add(new Transaction("withdrawal", amount));
            return true;
        } else {
            return false;
        }
    }
}
