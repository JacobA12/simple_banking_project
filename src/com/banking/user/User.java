package com.banking.user;

import java.security.SecureRandom;
import java.util.Base64;

public class User {
    private String username;
    private String hashedPassword;
    private String salt;

    public User(String username, String password){
        this.username = username;
        this.salt = generateSalt();
        this.hashedPassword = hashPassword(password, this.salt);
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getSalt() {
        return salt;
    }

    private String generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    private String hashPassword(String password, String salt){
        return Base64.getEncoder().encodeToString((password+salt).getBytes());
    }
}
