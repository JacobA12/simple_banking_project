package com.banking;

import com.banking.database.DatabaseSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank;

    @BeforeEach
    public void setUp() {
        DatabaseSetup.createNewTables();
        bank = new Bank();
    }

    @AfterEach
    public void tearDown() {
        // Drop the tables after each test to ensure a clean slate
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS users");
            stmt.execute("DROP TABLE IF EXISTS accounts");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCreateAccount() {
        bank.registerUser("test_user", "password123");
        bank.authenticateUser("test_user", "password123");

        int accountNumber = bank.createAccount("test_user", "John Doe");
        Account account = bank.getAccount(accountNumber);

        assertNotNull(account, "Account should be created successfully");
        assertEquals("John Doe", account.getAccountHolder(), "Account holder name should match");
    }

    @Test
    public void testDepositAndWithdraw() {
        bank.registerUser("test_user", "password123");
        bank.authenticateUser("test_user", "password123");

        int accountNumber = bank.createAccount("test_user", "John Doe");
        Account account = bank.getAccount(accountNumber);

        account.deposit(new BigDecimal("100.00"));
        assertEquals(new BigDecimal("100.00"), account.getBalance(), "Balance should be 100.00 after deposit");

        boolean withdrew = account.withdraw(new BigDecimal("50.00"));
        assertTrue(withdrew, "Withdrawal should be successful");
        assertEquals(new BigDecimal("50.00"), account.getBalance(), "Balance should be 50.00 after withdrawal");

        boolean failedWithdraw = account.withdraw(new BigDecimal("100.00"));
        assertFalse(failedWithdraw, "Withdrawal should fail due to insufficient funds");
    }
}
