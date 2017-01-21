package ua.spalah.bank.Exceptions;

public class ClientNotFoundException extends BankException {
    public ClientNotFoundException(String name) {
        super("Client " + name + " not found");
    }
}
