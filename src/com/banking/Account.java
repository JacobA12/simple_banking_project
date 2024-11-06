package com.banking;

import java.math.BigDecimal;

public class Account {
    private int accountNumber;
    private String accountHolder;
    private BigDecimal balance;

    public Account(int accountNumber, String accountHolder){
        this.accountNumber = accountNumber;
        this.accountHolder=accountHolder;
        this.balance = new BigDecimal("0.0");
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

    public void deposit(BigDecimal amount){
        balance = balance.add(amount);
    }

    public boolean withdraw(BigDecimal amount){
        if(balance.compareTo(amount) >= 0){
            balance = balance.subtract(amount);
            return true;
        }else{
            return false;
        }
    }
}
