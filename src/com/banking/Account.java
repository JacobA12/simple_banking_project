package com.banking;

import java.math.BigDecimal;

public class Account {
    private String ownerName;
    private int accountNumber;
    private BigDecimal balance;

    public Account(String ownerName, int accountNumber){
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = new BigDecimal("0");
    }
}
