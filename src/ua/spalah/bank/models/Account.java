package ua.spalah.bank.models;

import ua.spalah.bank.services.AccountType;

public interface Account {

    AccountType getAccountType();

    double getBalance();

    void setBalance(double balance);

    long getId();

    void setId(long id);
}
