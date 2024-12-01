package atm;

public class Bank {
        private String accountName; // สร้างตัวแปรเก็บชื่อบัญชี
        private String accountNumber; // สร้างตัวแปรเลขบัญชี
        private String pin ; // สร้างตัวแปรสำหรับรหัสผ่านบัญชี
        private double balance; //สร้างตัวแปรสำหรับยอดเงินในบัญชี

     //สร้าง Constructor สำหรับกำหนดค่าเริ่มต้น  
    public Bank(String accountName,String accountNumber,String pin,double initialBalance){ 
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    //การสร้าง Methods
    // เป็น เมธอด ที่ใช้สำหรับคืนค่า ชื่อบัญชี
    public String getAccountName(){ 
        return accountName;
    }
    // เป็น เมธอด ที่ใช้สำหรับคืนค่า เลขบัญชี
    public String getAccountNumber() { 
        return accountNumber;
    }
    //เป็น เมธอด ใช้ตรวจสอบว่ารหัสผ่านที่ป้อนมาตรงกับรหัสผ่านในบัญชีไหม
    public boolean enterPassword(String password) {
        return this.pin.equals(password); //.equals ใช้เปรียบเทียบเนื้อหาของ Object ว่าตรงกันหรือไม่
    }
    //เป็น เมธอด ใช้คืนค่า ยอดเงินคงเหลือ
    public double getBalance() {
        return balance;
    }
    // เป็น เมธอด ที่ใช้ในการถอนเงินจากบัญชี 
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) { //ใช้ตรวจสอบยอดเงินที่จะถอน
            balance -= amount; //นำเงินในบัญชีมาลบกับเงินที่ต้องการถอน
            return true;
        }
        return false;
    }
}
