package com.banking.user;

public class UserTest {
    public static void main(String[] args) {
        testUserCreation();
        testHashPassword();
        System.out.println("All User tests passed.");
    }

    public static void testUserCreation() {
        User user = new User("username", "password");
        assert "username".equals(user.getUsername()) : "Username should be 'username'";
        assert user.getSalt() != null : "Salt should not be null";
        assert user.getHashedPassword() != null : "HashedPassword should not be null";
        assert !"password".equals(user.getHashedPassword()) : "Password should be hashed";
    }

    public static void testHashPassword() {
        User user = new User("username", "password");
        String hashedPassword = user.hashPassword("password", user.getSalt());
        assert user.getHashedPassword().equals(hashedPassword) : "Hashed password should match";
    }
}
