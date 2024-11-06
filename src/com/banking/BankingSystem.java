package com.banking;
import java.util.Scanner;
public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.registerUser("john_doe", "password123");
        bank.registerUser("john_doe", "password1234");
        boolean isAuthenticated = bank.authenticateUser("john_doe", "password123");
        boolean isAuthenticated2 = bank.authenticateUser("john_doe", "password1234");

        if (isAuthenticated){
            System.out.println("User Authenticated Successfully");
            int accountNumber = bank.createAccount("john_doe","password123", "John Doe");
            System.out.println("Account created with number: " + accountNumber);
        }else{
            System.out.println("Authentication Failed");

        }if (isAuthenticated2){
            System.out.println("User Authenticated Successfully");
            int accountNumber = bank.createAccount("john_doe","password1234", "john_doe");
            System.out.println("Account created with number: " + accountNumber);
        }else{
            System.out.println("Authentication Failed");
        }


    }
}
