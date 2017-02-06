package ua.spalah.bank.services.impl;

import ua.spalah.bank.Exceptions.ClientAlreadyExistsException;
import ua.spalah.bank.Exceptions.ClientNotFoundException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.ClientService;

import java.util.Map;

public class ClientServiceImpl implements ClientService {


    @Override
    public Client findClientByName(Bank bank, String name) throws ClientNotFoundException {
        Client client = bank.getClients().get(name);
        if (client.getName().equalsIgnoreCase(name)) {
            return client;
        }
        return null;
    }

    @Override
    public Map<String, Client> findAllClients(Bank bank) {
        return bank.getClients();
    }

    @Override
    public Client saveClient(Bank bank, Client client) throws ClientAlreadyExistsException {
        if (!bank.getClients().containsKey(client.getName())) {
            bank.getClients().put(client.getName(), client);
            return client;
        } else {
            throw new ClientAlreadyExistsException(client.getName());
        }
    }

    @Override
    public void deleteClient(Bank bank, Client client) throws ClientNotFoundException {
        if (bank.getClients().containsKey(client.getName())) {
            bank.getClients().remove(client.getName());
        } else {
            throw new ClientNotFoundException(client.getName());
        }
    }


    public double getTotalBalance(Client client) {
        double totalBalance = 0;
        for (Account account : client.getAccounts()) {
            totalBalance += client.getTotalBalance();
        }
        return totalBalance;
    }

    public void addAccount(Client client, Account account) {
        client.getAccounts().add(account);
        if (client.getAccounts().size() == 0) {
            client.setActiveAccount(account);
        }
        client.getAccounts().add(account);
    }
}
