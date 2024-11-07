package com.banking.user;

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
        User newUser = new User(username, password);
        users.put(username, newUser);
        return true;
    }

    public boolean authenticateUser(String username, String password){
        User user = users.get(username);
        if(user == null){
            return false;
        }

        return user.hashPassword(password, user.getSalt()).equals(user.getHashedPassword());

    }
}
