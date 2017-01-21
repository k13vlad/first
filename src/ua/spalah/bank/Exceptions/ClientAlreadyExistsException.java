package ua.spalah.bank.Exceptions;


public class ClientAlreadyExistsException extends BankException {
    public ClientAlreadyExistsException(String name) {
        super("Client " + name + " already exists");
    }
}
