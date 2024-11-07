package com.banking.user;

public class UserManagerTest {
    public static void main(String[] args) {
        testRegisterUserSuccess();
        testRegisterUserFailure();
        testAuthenticateUserSuccess();
        testAuthenticateUserFailure();
        testAuthenticateNonExistentUser();
        System.out.println("All UserManager tests passed.");
    }

    public static void testRegisterUserSuccess() {
        UserManager userManager = new UserManager();
        assert userManager.registerUser("username", "password") : "User should be registered successfully";
    }

    public static void testRegisterUserFailure() {
        UserManager userManager = new UserManager();
        userManager.registerUser("username", "password");
        assert !userManager.registerUser("username", "password") : "User should not be registered twice";
    }

    public static void testAuthenticateUserSuccess() {
        UserManager userManager = new UserManager();
        userManager.registerUser("username", "password");
        assert userManager.authenticateUser("username", "password") : "User should be authenticated successfully";
    }

    public static void testAuthenticateUserFailure() {
        UserManager userManager = new UserManager();
        userManager.registerUser("username", "password");
        assert !userManager.authenticateUser("username", "wrongpassword") : "User should not be authenticated with wrong password";
    }

    public static void testAuthenticateNonExistentUser() {
        UserManager userManager = new UserManager();
        assert !userManager.authenticateUser("nonexistent", "password") : "Non-existent user should not be authenticated";
    }
}
