package ua.spalah.bank.Exceptions;

public class NotEnoughMoneyException extends BankException{

    protected NotEnoughMoneyException(String message) {
        super(message);
    }

    public NotEnoughMoneyException(double balance) {
        super("Not enough funds, only $" + balance + " on your account.");
    }
}
