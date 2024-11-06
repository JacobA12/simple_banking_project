package com.banking.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:sqlite:bankingapp.db";

    public static Connection connect(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Connection to SQLite has been established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
