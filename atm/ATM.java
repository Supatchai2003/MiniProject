package atm;

import java.util.*; 

class ATM {
    // ประกาศตัวแปร  
    private List<Bank> accounts; // ให้ accounts เป็น list ที่จัดเก็บข้อมูลเป็นบัญชี

    public ATM() {
        accounts = new ArrayList<>(); // เป็นการสร้างตัวแปร accounts ให้เริ่มต้น ในอาเรย์ลิสเป็นค่าว่าง 
    }
    // เป็น เมธอด ใช้ในการเพิ่มบัญชี 
    public void addAccount(Bank account) {
        if (accounts.size() < 5) { // ตรวจสอบว่า เพิ่มรายการมา น้อยกว่า 5 หรือไม่
            accounts.add(account); // เก็บค่าตัวแปรที่ใส่เข้ามา และเก็บไปยัง ArrayList
            System.out.println("Account added successfully."); //การเพิ่มบัญชีสำเร็จ
        } else {
            System.out.println("Cannot add more than 5 accounts."); // ข้อความแจ้งว่า ไม่สามารถเพิ่มเกิน 5 บัญชี
        }
    }
    // เป็น เมธอด ใช้ตรวจสอบการเข้าสู่ระบบ 
    public Bank loginAccounts(String accountNumber, String pin) { 
        for (Bank account : accounts) { //รับค่า เลขบัญชีและรหัสผ่าน มาตรวจสอบว่ารหัสตรงกับบัญชีที่มีอยู่หรือไม่
            if (account.getAccountNumber().equals(accountNumber) && account.enterPassword(pin)) {
                return account; // คืนค่า เป็น บัญชีของผู้ใช้
            }
        }
        return null;// คืนค่าเป็นบัญชีว่างหรือไม่มีบัญชีอยู่
    }
    // เป็น เมธอด ที่ใช้แสดงเมนูของตู้ ATM
    public void displayMenu(Bank account) {
        Scanner scanner = new Scanner(System.in); // เป็นสิ่งที่จะรับinput จาก Keyboard
        while (true) { 
            System.out.println("-------------------------------------------------------");
            System.out.println("ATM ComputerThanyaburi Bank");
            System.out.println("ATM Menu:");
            System.out.println("Account ID : "+account.getAccountNumber());// ต้องการให้แสดงผลของเลขบัญชี
            System.out.println("1. Account Balance"); // ยอดเงินในบัญชี
            System.out.println("2. Withdraw Money"); // ถอนเงิน
            System.out.println("3. Exit"); // ออกจากระบบ หรือยกเลิกทำรายการทั้งหมด
            System.out.print("Choose : "); 
            int choice = scanner.nextInt();

            // ใช้ เป็น switch case ในการเปลี่ยนเป็นฟังชั่นต่างๆ ที่ได้เลือก
            switch (choice) {
                case 1: // จะแสดงผลของยอดเงิน
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 2: // การถอนเงิน 
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble(); // ใส่จำนวนเงินที่ต้องการถอน
                    if (account.withdraw(amount)) { 
                        System.out.println("Withdrawal successful. New Balance: " + account.getBalance());
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                    break;
                case 3:
                    System.out.println("Log out successfully. Thank you for using our service.");
                    return ;
                default: // ถ้าใส่ฟังชั่นไม่ถูกต้อง ระบบจะให้ใส่ใหม่
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    //ที่ใช้ในการรันคำสั่ง 
    public static void main(String[] args) {
        ATM atm = new ATM(); //สร้างObject ของ class ATM 
        Scanner scanner = new Scanner(System.in); //ใช้ Scanner เป็นตัวรับ input จาก Keyboard

        int numberOfAccounts; // สร้างตัวแปร ในการรับจำนวนบัญชี
        while (true) {
            // จะใส่ได้มากที่สุดคือ 5 บัญชี
            System.out.print("Step 1. Enter amount of all accounts (max 5): ");
            numberOfAccounts = scanner.nextInt();
            scanner.nextLine();
            if (numberOfAccounts <= 5) {
                break;
            }
            System.out.println("You can only add up to 5 accounts.");
        }
        // ในขั้นตอนที่ 2 คือ การใส่รายละเอียดของบัญชี
        System.out.println("---------------------------------------");
        System.out.println("Step 2. Enter details of each account.");
        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.println("-----------------------------------");
            System.out.println("No. " + (i + 1)); // บัญชีที่  
            System.out.print("Account ID: "); // เลขที่บัญชี
            String accountNumber = scanner.nextLine();
            System.out.print("Account Name: "); // ชื่อบัญชี
            String accountName = scanner.nextLine();
            System.out.print("Password: "); // รหัสผ่านของบัญชี
            String pin = scanner.nextLine();

            double balance; //สร้างตัวแปร สำหรับ ยอดเงินคงเหลือ 
            while (true) {
                System.out.print("Balance: ");
                balance = scanner.nextDouble();
                scanner.nextLine();
                // ห้ามให้จำนวนเงิน เกิน 1 ล้านบาท
                if (balance <= 1000000) {
                    break;
                }
                System.out.println("Initial balance cannot exceed 1,000,000. Please enter a valid amount.");
            }
            // สร้าง Object ATM และเพิ่มบัญชี ไปที่ Bank
            atm.addAccount(new Bank(accountName, accountNumber, pin, balance));
        }
        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("ATM ComputerThanyaburi Bank");
            // กรุณาใส่เลขบัญชีและรหัสผ่าน
            System.out.print("Enter account number to login: ");
            String number = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            // ทำการเช็คว่า มีบัญชีหรือไม่ 
            Bank checkAccount = atm.loginAccounts(number, pin);

            if (checkAccount  != null) {
                System.out.println("Welcome, " + checkAccount .getAccountName() + "!");
                atm.displayMenu(checkAccount );
                break;
            } else {
                System.out.println("Authentication failed. Please check your account number and PIN.");
                System.out.print("Do you want to try again? (yes/no): ");
                String retry = scanner.nextLine();
                if (!retry.equalsIgnoreCase("yes")) {
                    System.out.println("Exiting program. Goodbye!");
                    break;
                }
            }
        }

        scanner.close();
    }
}