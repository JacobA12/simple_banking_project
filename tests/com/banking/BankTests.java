package com.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class BankTests {

    @Test
    public void testUserRegistration() {
        Bank bank = new Bank();
        boolean registered = bank.registerUser("john_doe", "password123");
        assertTrue(registered, "User should be registered successfully");

        boolean duplicate = bank.registerUser("john_doe", "newpassword");
        assertFalse(duplicate, "Duplicate usernames should not be allowed");
    }

    @Test
    public void testUserAuthentication() {
        Bank bank = new Bank();
        bank.registerUser("john_doe", "password123");

        boolean authenticated = bank.authenticateUser("john_doe", "password123");
        assertTrue(authenticated, "User should be authenticated with correct credentials");

        boolean failedAuth = bank.authenticateUser("john_doe", "wrongpassword");
        assertFalse(failedAuth, "User should not be authenticated with incorrect credentials");
    }

    @Test
    public void testAccountCreation() {
        Bank bank = new Bank();
        bank.registerUser("john_doe", "password123");
        bank.authenticateUser("john_doe", "password123");

        int accountNumber = bank.createAccount("john_doe", "password123", "John Doe");
        Account account = bank.getAccount(accountNumber);

        assertNotNull(account, "Account should be created successfully");
        assertEquals("John Doe", account.getAccountHolder(), "Account holder name should match");
    }

    @Test
    public void testDepositAndWithdraw() {
        Bank bank = new Bank();
        bank.registerUser("john_doe", "password123");
        bank.authenticateUser("john_doe", "password123");

        int accountNumber = bank.createAccount("john_doe", "password123", "John Doe");
        Account account = bank.getAccount(accountNumber);

        account.deposit(new BigDecimal("100.00"));
        assertEquals(new BigDecimal("100.00"), account.getBalance(), "Balance should be 100.00 after deposit");

        boolean withdrew = account.withdraw(new BigDecimal("50.00"));
        assertTrue(withdrew, "Withdrawal should be successful");
        assertEquals(new BigDecimal("50.00"), account.getBalance(), "Balance should be 50.00 after withdrawal");

        boolean failedWithdraw = account.withdraw(new BigDecimal("100.00"));
        assertFalse(failedWithdraw, "Withdrawal should fail due to insufficient funds");
    }

    @Test
    public void testDuplicateUserRegistration() {
        Bank bank = new Bank();
        boolean firstRegistration = bank.registerUser("jane_doe", "password123");
        boolean secondRegistration = bank.registerUser("jane_doe", "password123");
        assertTrue(firstRegistration, "First user registration should be successful");
        assertFalse(secondRegistration, "Second user registration with the same username should fail");
    }
}
