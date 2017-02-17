package ua.spalah.bank.Accounts;

import ua.spalah.bank.models.Account;
import ua.spalah.bank.services.AccountType;

public class SavingAccount implements Account {
    private double balance;
    private final AccountType accountType;
    private long id;

    public SavingAccount(double balance, AccountType accountType) {
        this.balance = balance;
        this.accountType = accountType;
    }

    public SavingAccount(double balance) {
        this(balance, AccountType.SAVING);
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
