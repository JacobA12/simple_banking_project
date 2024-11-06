package com.banking.user;

import com.banking.database.DatabaseConnection;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {
    private Map<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public boolean registerUser(String username, String password) {
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        String sql = "INSERT INTO users(username, hashed_password, salt) VALUES(?,?,?)";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.setString(3, salt);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    public boolean authenticateUser(String username, String password) {
        String sql = "SELECT hashed_password, salt FROM users WHERE username = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("hashed_password");
                String salt = rs.getString("salt");
                String hashedPassword = hashPassword(password, salt);

                return hashedPassword.equals(storedHashedPassword);
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    private String hashPassword(String password, String salt) {
        return Base64.getEncoder().encodeToString((password + salt).getBytes());
    }

}
