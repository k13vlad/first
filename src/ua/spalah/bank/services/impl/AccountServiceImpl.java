package ua.spalah.bank.services.impl;

import ua.spalah.bank.Accounts.CheckingAccount;
import ua.spalah.bank.Exceptions.NotEnoughMoneyException;
import ua.spalah.bank.Exceptions.OverdraftLimitException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.services.AccountService;


public class AccountServiceImpl implements AccountService {


    public void deposit(Account account, double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("You want to add no money!");
        } else {
            account.setBalance(account.getBalance() + amount);
        }
    }

    public void withdraw(Account account, double amount) throws NotEnoughMoneyException {

        if (amount <= 0) throw new IllegalArgumentException("You want to add no money!");

        switch (account.getAccountType()) {
            case SAVING: {
                double balance = account.getBalance();
                if (balance >= amount) {
                    account.setBalance(account.getBalance() - amount);
                } else {
                    throw new NotEnoughMoneyException(balance);
                }
                break;
            }
            case CHECKING: {
                double available = account.getBalance() + ((CheckingAccount) account).getOverdraft();
                if (available >= amount) {
                    account.setBalance(available - amount);
                } else {
                    throw new OverdraftLimitException(available);
                }
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown account type");
        }
    }

    public void transfer(Account fromAccount, Account toAccount, double amount) throws NotEnoughMoneyException {
        withdraw(fromAccount, amount);
        deposit(toAccount, amount);
    }
}
