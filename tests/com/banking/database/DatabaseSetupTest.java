package com.banking.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseSetupTest {

    private static final String DATABASE_URL = "jdbc:sqlite:bankingapp.db";

    @BeforeEach
    public void setUp() {
        DatabaseSetup.createNewTables();
    }

    @AfterEach
    public void tearDown() {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS users");
            stmt.execute("DROP TABLE IF EXISTS accounts");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testTablesCreation() {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery("SELECT 1 FROM users");
            stmt.executeQuery("SELECT 1 FROM accounts");
        } catch (SQLException e) {
            fail("Tables should be created successfully");
        }
    }
}
