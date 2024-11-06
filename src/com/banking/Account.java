package com.banking;

import java.math.BigDecimal;

public class Account {
    private String ownerName;
    private int accountNumber;
    private BigDecimal balance;

    public Account(String ownerName, int accountNumber) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = new BigDecimal("0");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public boolean withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) == 1) {
            balance = balance.subtract(amount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "ownerName='" + ownerName + '\'' + ", accountNumber=" + accountNumber + ", balance=" + balance + '}';
    }
}
