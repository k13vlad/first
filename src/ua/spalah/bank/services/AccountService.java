package ua.spalah.bank.services;

import ua.spalah.bank.Exceptions.NotEnoughMoneyException;
import ua.spalah.bank.models.Account;

public interface AccountService {
    void deposit(Account account, double amount);

    void withdraw(Account account, double amount) throws NotEnoughMoneyException;

    void transfer(Account fromAccount, Account toAccount, double amount) throws NotEnoughMoneyException;
}
