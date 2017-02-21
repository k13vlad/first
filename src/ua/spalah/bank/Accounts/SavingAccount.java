package ua.spalah.bank.Accounts;

import ua.spalah.bank.models.Account;
import ua.spalah.bank.services.AccountType;

public class SavingAccount implements Account {
    private long id;
    private double balance;
    private final AccountType accountType;

    public SavingAccount(long id, double balance, AccountType accountType) {
        this.id = id;
        this.balance = balance;
        this.accountType = accountType;
    }

    public AccountType getAccountType() {
        return accountType;
    }


    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "SavingAccount{" +
                "balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }

}
