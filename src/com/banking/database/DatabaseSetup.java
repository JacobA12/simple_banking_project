package com.banking.database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseSetup {
    public static void createNewTables() {
        String userTable = "CREATE TABLE IF NOT EXISTS users ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "username TEXT NOT NULL UNIQUE,"
                + "hashed_password TEXT NOT NULL,"
                + "salt TEXT NOT NULL);";

        String accountTable = "CREATE TABLE IF NOT EXISTS accounts ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "account_number INTEGER NOT NULL,"
                + "account_holder TEXT NOT NULL,"
                + "balance REAL NOT NULL,"
                + "user_id INTEGER,"
                + "FOREIGN KEY (user_id) REFERENCES users (id));";

        try (Connection conn = DatabaseConnection.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(userTable);
            stmt.execute(accountTable);
            System.out.println("Tables created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}
