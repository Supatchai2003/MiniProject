package lab2;
 
interface ATMAction {
    void checkBalance();
    void withdraw(double amount);
    void deposit(double amount);
    void transfer(Account targetAccount, double amount);
}