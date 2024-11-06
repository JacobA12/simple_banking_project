package com.banking;

import com.banking.user.UserManager;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static int nextAccountNumber = 1000;
    private Map<Integer, Account> accounts;
    private UserManager userManager;

    public Bank() {
        this.accounts = new HashMap<>();
        this.userManager = new UserManager();
    }

    public boolean registerUser(String username, String password) {
        return userManager.registerUser(username, password);
    }

    public boolean authenticateUser(String username, String password) {

        return userManager.authenticateUser(username, password);
    }

    public int createAccount(String username, String password, String accountHolder) {
        if (!userManager.authenticateUser(username, password)) {
            throw new IllegalStateException("User not authenticated");
        }
        int accountNumber = nextAccountNumber++;
        Account newAccount = new Account(accountNumber, accountHolder);
        accounts.put(accountNumber, newAccount);
        return accountNumber;
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }


    public void deleteAccount(int accountNumber) {
        accounts.remove(accountNumber);
    }


}
