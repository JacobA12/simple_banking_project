package com.banking;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static int nextAccountNumber = 1000;
    private Map<Integer, Account> accounts;

    public Bank(){
        this.accounts = new HashMap<>();
    }

    public int createAccount(String accountHolder){
        int accountNumber = nextAccountNumber++;
        Account newAccount = new Account(accountNumber, accountHolder);
        accounts.put(accountNumber, newAccount);
        return accountNumber;
    }

    public Account getAccount(int accountNumber){
        return accounts.get(accountNumber);
    }

    public void deleteAccount(int accountNumber){
        accounts.remove(accountNumber);
    }



}
