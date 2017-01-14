package ua.spalah.bank.services.impl;

import ua.spalah.bank.models.Account;
import ua.spalah.bank.services.AccountService;


public class AccountServiceImpl implements AccountService {




    public void deposit(Account account, double amount) {

        double balance = account.getBalance();

        if (amount <= 0) {
            System.out.println("You want to add no money!");
        } else {
            balance += amount;
        }
        account.setBalance(balance);
    }


    public void withdraw(Account account, double amount) {
        double balance = account.getBalance();

        if (amount <= 0) {
            System.out.println("You want to add no money!");
        } else {
            balance -= amount;
        }
        account.setBalance(balance);

    }


    public void transfer(Account fromAccount, Account toAccount, double amount) {
        withdraw(fromAccount, amount);
        deposit(toAccount, amount);
    }
}
