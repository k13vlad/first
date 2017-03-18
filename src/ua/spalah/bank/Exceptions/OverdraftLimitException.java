package ua.spalah.bank.Exceptions;


public class OverdraftLimitException extends NotEnoughMoneyException {

    public OverdraftLimitException(double available) {
        super("You exceeded your overdraft only $" + available);
    }
}
