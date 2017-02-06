package ua.spalah.bank.services;

import ua.spalah.bank.Exceptions.ClientAlreadyExistsException;
import ua.spalah.bank.Exceptions.ClientNotFoundException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;

import java.util.Map;

public interface ClientService {
    Client findClientByName(Bank bank, String name) throws ClientNotFoundException;

    Map<String, Client> findAllClients(Bank bank);

    Client saveClient(Bank bank, Client client) throws ClientAlreadyExistsException;

    void deleteClient(Bank bank, Client client) throws ClientNotFoundException;

    void addAccount(Client client, Account account);
}
