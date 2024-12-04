package bank;

public class Bank {
    private String accountName;
    private String accountId;
    private String pin;
    private double balance;

    public Bank(String Name, String id, String pin, double balance) {
        this.accountName = Name;
        this.accountId = id;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountId(){
        return accountId;
    }

    public boolean enterPin(String pin){
        return this.pin.equals(pin);
    }
    public double getBalance(){
        return balance;
    }
    
}
