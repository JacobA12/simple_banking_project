package com.banking.user;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users;

    public UserManager(){
        this.users = new HashMap<>();
    }

    public boolean registerUser(String username, String password){
        if(users.containsKey(username)){
            return false;
        }
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        User newUser = new User(username, hashedPassword, salt);
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

    public String hashPassword(String password, String salt){
        return Base64.getEncoder().encodeToString((password+salt).getBytes());
    }

    private String generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
}
