package ua.spalah.bank.Accounts;

import ua.spalah.bank.services.AccountType;

public class CheckingAccount extends SavingAccount {

    private double overdraft;

    public CheckingAccount(long id, double balance, AccountType accountType, double overdraft) {
        super(id, balance, accountType);
        this.overdraft = overdraft;
    }

    public CheckingAccount(double balance, double overdraft) {
        super(balance);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public String toString() {
        return "\nCheckingAccount{" +
                "balance=" + this.getBalance() +
                ", overdraft=" + this.getOverdraft() +
                ", accountType=" + this.getAccountType() +
                "}";
    }

}
