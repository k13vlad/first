package ua.spalah.bank.services;

import ua.spalah.bank.Exceptions.ClientAlreadyExistsException;
import ua.spalah.bank.Exceptions.ClientNotFoundException;
import ua.spalah.bank.models.Account;

import ua.spalah.bank.models.Client;

import java.util.List;

public interface ClientService {
    Client findClientByName(String name) throws ClientNotFoundException;

    List<Client> findAllClients();

    Client saveClient(Client client) throws ClientAlreadyExistsException;

    void deleteClient(Client client) throws ClientNotFoundException;

    void addAccount(Client client, Account account);
    double getTotalBalance(Client client);

}
