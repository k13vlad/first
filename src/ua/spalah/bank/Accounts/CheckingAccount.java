package ua.spalah.bank.Accounts;

//1
import ua.spalah.bank.services.AccountType;

public class CheckingAccount extends SavingAccount {

    private double overdraft;

    public CheckingAccount(double balance, double overdraft) {
        super(balance, AccountType.CHECKING);
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
