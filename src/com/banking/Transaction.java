package com.banking;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private String type;
    private BigDecimal amount;
    private Date date;

    public Transaction(String type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
