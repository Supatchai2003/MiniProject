package lab2;

import java.util.*;

public class ATMSystem {
    private static Manager manager;
    private static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: รายละเอียดของผู้จัดการ
        if (manager == null) {
            System.out.println("---------------------------------");
            System.out.println("Add a manager account"); // เพิ่มข้อมูลผู้จัดการ
            System.out.print("Enter Manager ID (13): "); // รหัสบัตรปชช ของผู้จัดการ
            String id = scanner.nextLine();
            while (id.length() != 13) {
                System.out.println("Manager ID must be 13 digits. Please enter again.");
                System.out.print("ID (13 digits): ");
                id = scanner.nextLine();
            }
            System.out.print("Enter Manager Name (50): "); // ชื่อผู้จัดการ
            String name = scanner.nextLine();
            while (name.length() > 50) {
                System.out.println("Manager name can't exceed 50 characters. Please enter again.");
                System.out.print("Manager Name (Max 50 characters): ");
                name = scanner.nextLine();
            }
            System.out.print("Enter Manager Gender (Male/Female): "); // เพศ
            String gender = scanner.nextLine();
            System.out.print("Enter Manager Login (13): "); // เป็นเลขของบัญชีในการล็อกอิน
            String login = scanner.nextLine();
            while (login.length() != 13) {
                System.out.println("Manager Login must be 13 digits. Please enter again.");
                System.out.print("Manager Login (13 digits): ");
                login = scanner.nextLine();
            }
            System.out.print("Enter Manager Password(4): "); // พาสเวิร์ด ผู้จัดการ
            String password = scanner.nextLine();
            while (password.length() != 4) {
                System.out.println("PIN must be 4 digits. Please enter again.");
                System.out.print("PIN (4 digits): ");
                password = scanner.nextLine();
            }
            manager = new Manager(id, name, gender, login, password);
        }
        // การล็อกอิน ผู้จัดการ
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("---------------------------------");
            System.out.print("Login Account Manager "); // ล็อกอิน บัญชีผู้จัดการ
            System.out.print("Manager Login: ");
            String login = scanner.nextLine();
            System.out.print("Manager Password: ");
            String password = scanner.nextLine();

            if (manager.getLogin().equals(login) && manager.getPassword().equals(password)) {
                loggedIn = true;
                System.out.println("Manager login successfully.");
            } else {
                System.out.println("cannot Account Manager!!! Try again.");
            }
        }
        // Step 2: เพิ่มบัญชีผู้ใช้
        System.out.println("---------------------------------");
        System.out.print("Enter the number of accounts to create (max 5): ");
        int numAccounts = Integer.parseInt(scanner.nextLine());
        numAccounts = Math.min(numAccounts, 5);

        for (int i = 0; i < numAccounts; i++) {
            System.out.println("---------------------------------");
            System.out.println("Enter details for Account " + (i + 1) + ":");
            System.out.print("Enter ID (13 digits): ");
            String id = scanner.nextLine();
            while (id.length() != 13) {
                System.out.println("ID Account must be 13 digits. Please enter again.");
                System.out.print("ID Account (13 digits): ");
                id = scanner.nextLine();
            }
            System.out.print("Enter Name (Max 50 characters): ");
            String name = scanner.nextLine();
            while (name.length() > 50) {
                System.out.println("Account name can't exceed 50 characters. Please enter again.");
                System.out.print("Account Name (Max 50 characters): ");
                name = scanner.nextLine();
            }
            System.out.print("Enter Gender (Male/Female): ");
            String gender = scanner.nextLine();
            System.out.print("Enter Login (13 digits): ");
            String login = scanner.nextLine();
            while (login.length() != 13) {
                System.out.println("Login Account must be 13 digits. Please enter again.");
                System.out.print("Login Account (13 digits): ");
                login = scanner.nextLine();
            }
            System.out.print("Enter Password (4 digits): ");
            String password = scanner.nextLine();
            while (password.length() != 4) {
                System.out.println("PIN must be 4 digits. Please enter again.");
                System.out.print("PIN (4 digits): ");
                password = scanner.nextLine();
            }
            System.out.print("Enter Initial Balance (Max 1,000,000): ");
            double balance = Double.parseDouble(scanner.nextLine());
            while (balance > 1000000 || balance < 0) {
                System.out.println("Initial balance must be between 0 and 1,000,000. Please enter a valid amount.");
                System.out.print("Enter Initial Balance (Max 1,000,000): ");
                balance = Double.parseDouble(scanner.nextLine());
            }
            accounts.add(new Account(id, name, gender, login, password, balance));
        }

        // Step 3: ATM Menu
        boolean AccLogin = true;
        while (AccLogin) {
            System.out.println("---------------------------------");
            System.out.print("Enter Account Login: ");
            String login = scanner.nextLine();
            System.out.print("Enter Account Password: ");
            String password = scanner.nextLine();

            Account currentAccount = null;
            for (Account account : accounts) {
                if (account.getLogin().equals(login) && account.getPassword().equals(password)) {
                    currentAccount = account;
                    
                }
            }
            if (currentAccount != null) {
                System.out.println("Login successful.");
                System.out.println("ID Account : " + currentAccount.getLogin());

                boolean sessionActive = true;

                while (sessionActive) {
                    System.out.println("---------------------------------");
                    System.out.println("ATM ComputerThanyaburi Bank");
                    System.out.println("ATM Menu:");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Logout");
                    System.out.print("Choose an option: ");

                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            currentAccount.checkBalance();
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = Double.parseDouble(scanner.nextLine());
                            currentAccount.withdraw(withdrawAmount);
                            break;
                        case 3:
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = Double.parseDouble(scanner.nextLine());
                            currentAccount.deposit(depositAmount);
                            break;
                        case 4:
                            System.out.println("---------------------------------");
                            System.out.print("Enter target account login: ");
                            String targetLogin = scanner.nextLine();
                            Account targetAccount = null;
                            for (Account account : accounts) {
                                if (account.getLogin().equals(targetLogin)) {
                                    targetAccount = account;
                                    break;
                                }
                            }
                            if (targetAccount != null) {
                                System.out.print("Enter amount to transfer: ");
                                double transferAmount = Double.parseDouble(scanner.nextLine());
                                currentAccount.transfer(targetAccount, transferAmount);
                            } else {
                                System.out.println("Target account not found.");
                            }
                            break;
                        case 5:
                            sessionActive = false;
                            System.out.println("Logged out.");
                            AccLogin = true;
                            break;
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                }
            } else {
                System.out.println("Invalid login credentials. Try again.");
            }
        }
    }
}
