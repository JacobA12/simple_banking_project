package com.banking;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String bankName;
    private Map<Integer, Account> accounts;

    public Bank(String name){
        this.name = name;
        this.accounts= new HashMap<>();
    }

    public void addAccount(Account account){

    }

    public void deposit(int accountNumber, BigDecimal amount){

    }

    public void withdraw(int accountNumber, BigDecimal amount){

    }

    public void getAccountInfo(int accountNumber){

    }


}
