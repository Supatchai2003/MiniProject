package bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM atmcpe = new ATM();
        Scanner scanner = new Scanner(System.in);

        int numberOfAccounts;

        // Step 1: Ask for the number of accounts
        while (true) {
            System.out.print("Step 1 Enter the number of accounts: ");
            numberOfAccounts = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            if (numberOfAccounts > 0) {
                break; // Exit the loop when valid number is entered
            } else {
                System.out.println("Please enter a valid number of accounts.");
            }
        }

        System.out.println("---------------------------------------");
        System.out.println("Step 2. Enter details of each account.");

        // Step 2: Loop to enter details for each account
        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.println("-----------------------------------");
            System.out.println("Account " + (i + 1));

            // Get Account ID and ensure it's 13 characters
            String accountId;
            while (true) {
                System.out.print("Account ID (13 digits): ");
                accountId = scanner.nextLine();
                if (accountId.length() == 13) {
                    break;  // Exit the loop when the account ID is exactly 13 characters
                } else {
                    System.out.println("Invalid Account ID. Please enter exactly 13 characters.");
                }
            }

            // Get account details
            System.out.print("Account Name (Max 50 characters): ");
            String accountName = scanner.nextLine();
            while (accountName.length() > 50) {
                System.out.println("Account name can't exceed 50 characters. Please enter again.");
                System.out.print("Account Name (Max 50 characters): ");
                accountName = scanner.nextLine();
            }

            System.out.print("PIN (4 digits): ");
            String pin = scanner.nextLine();
            while (pin.length() != 4) {
                System.out.println("PIN must be 4 digits. Please enter again.");
                System.out.print("PIN (4 digits): ");
                pin = scanner.nextLine();
            }

            double balance;
            // Ensure balance does not exceed 1,000,000
            while (true) {
                System.out.print("Balance: ");
                balance = scanner.nextDouble();
                scanner.nextLine();  // Consume the newline character
                if (balance <= 1000000) {
                    break;
                } else {
                    System.out.println("Initial balance cannot exceed 1,000,000. Please enter a valid amount.");
                }
            }

            // Add the account to ATM system
            atmcpe.addAccount(new Bank(accountName, accountId, pin, balance));
        }

        // Login process
        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("ATM ComputerThanyaburi Bank");
            // Prompt for login details
            System.out.print("Enter account ID to login: ");
            String loginAccountId = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String loginPin = scanner.nextLine();

            // Check if account exists and PIN is correct
            Bank account = atmcpe.login(loginAccountId, loginPin);

            if (account != null) {
                System.out.println("Welcome, " + account.getAccountName() + "!");
                atmcpe.ATMMenu(account); // Show ATM menu after successful login
                break; // Exit login loop
            } else {
                System.out.println("Invalid Account ID or PIN. Please try again.");
            }
        }
        scanner.close();
    }
}