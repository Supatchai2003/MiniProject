package bank;

import java.util.*;

public class ATM {
    private List<Bank> accountperson;

    public ATM(){
        accountperson = new ArrayList<>();
    }

    public void addAccount(Bank account){
        if (accountperson.size()<5) {
            accountperson.add(account);
            System.out.println("Account add success");
        }else{
            System.out.println("Cannot add more 5 account");
        }
    }
    public Bank login(String id, String pin){
        for (Bank account : accountperson) {
            if (account.getAccountId().equals(id)&& account.enterPin(pin)){
                return account;
            }
        }
        return null;
    }
    public void  ATMMenu(Bank account){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("ATM Computerthanyaburi Bank");
            System.out.println("Menu");
            System.out.println("Account ID : "+account.getAccountId());
            System.out.println("1. Account Balance");
            System.out.println("2. withdraw Money");
            System.out.println("3. Exit");
            System.out.println("Choose");
            int choice = scanner.nextInt();
        }
    }
}
