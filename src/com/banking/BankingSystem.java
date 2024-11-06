package com.banking;
import com.banking.database.DatabaseSetup;

import java.util.Scanner;
public class BankingSystem {
    public static void main(String[] args) {
        DatabaseSetup.createNewTables();
    }
}
