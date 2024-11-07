package com.banking;

import com.banking.user.UserManager;
import java.util.Scanner;
import java.math.BigDecimal;

public class BankingSystem {
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Banking System Main Menu:");
            System.out.println("1. Register User");
            System.out.println("2. Authenticate User");
            System.out.println("3. Create Account");
            System.out.println("4. View Account");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Transfer");
            System.out.println("8. View Transaction History");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    authenticateUser(scanner);
                    break;
                case 3:
                    createAccount(scanner);
                    break;
                case 4:
                    viewAccount(scanner);
                    break;
                case 5:
                    deposit(scanner);
                    break;
                case 6:
                    withdraw(scanner);
                    break;
                case 7:
                    transfer(scanner);
                    break;
                case 8:
                    viewTransactionHistory(scanner);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (bank.registerUser(username, password)) {
            System.out.println("User registered successfully.");
        } else {
            System.out.println("User registration failed. Username may already exist.");
        }
    }

    private static void authenticateUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (bank.authenticateUser(username, password)) {
            System.out.println("User authenticated successfully.");
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }
    }

    // Implement other methods for createAccount, viewAccount, deposit, withdraw, transfer, viewTransactionHistory...
    private static void createAccount(){

    }
}
