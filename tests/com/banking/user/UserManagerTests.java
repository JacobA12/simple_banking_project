package com.banking.user;

import com.banking.database.DatabaseSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        DatabaseSetup.createNewTables();
        userManager = new UserManager();
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
    public void testRegisterUser() {
        boolean registered = userManager.registerUser("test_user", "password123");
        assertTrue(registered, "User should be registered successfully");

        boolean duplicate = userManager.registerUser("test_user", "newpassword");
        assertFalse(duplicate, "Duplicate usernames should not be allowed");
    }

    @Test
    public void testAuthenticateUser() {
        userManager.registerUser("test_user", "password123");
        boolean authenticated = userManager.authenticateUser("test_user", "password123");
        assertTrue(authenticated, "User should be authenticated with correct credentials");

        boolean failedAuth = userManager.authenticateUser("test_user", "wrongpassword");
        assertFalse(failedAuth, "User should not be authenticated with incorrect credentials");
    }
}
