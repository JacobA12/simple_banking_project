package com.banking.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Base64;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserManager {
    private Map<String, User> users;

    public UserManager(){
        this.users = new HashMap<>();
    }

    public boolean registerUser(String username, String password){
        if(users.containsKey(username)){
            return false;
        }
        User newUser = new User(username, password);
        users.put(username, newUser);
        return true;
    }

    public boolean authenticateUser(String username, String password){
        User user = users.get(username);
        if(user == null){
            return false;
        }
        String hashedPassword = hashPassword(password, user.getSalt());
        return hashedPassword.equals(user.getHashedPassword());
    }

    private String hashPassword(String password, String salt){
        return Base64.getEncoder().encodeToString((password+salt).getBytes());
    }

}
