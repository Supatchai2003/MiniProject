package lab2;
class Account extends Person implements ATMAction  { // ใช้เมธอดของ ATMAction
    private String login;
    private String password;
    private double balance;

    public Account(String id, String name, String gender, String login, String password, double balance) {
        super(id, name, gender);
        this.login = login;
        this.password = password;
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Balance: " + balance); // เช็คตังในบัญชี
    }
    @Override
    public void withdraw(double amount) { // เมธอด การถอนเงิน
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Monney successful. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    @Override
    public void deposit(double amount) { //การฝากเงิน
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New Balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    @Override
    public void transfer(Account targetAccount, double amount) { // การโอนเงิน
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            targetAccount.balance += amount;
            System.out.println("Transfer To Account "+targetAccount.login+"successful. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
}
