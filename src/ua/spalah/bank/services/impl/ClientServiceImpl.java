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
    public Client findClientByName(String name) throws ClientNotFoundException {
        Client client = getClients().get(name);
        if (client.getName().equalsIgnoreCase(name)) {
            return client;
        }
        return null;
    }

    @Override
    public Map<String, Client> findAllClients() {
        return getClients();
    }

    @Override
    public Client saveClient(Client client) throws ClientAlreadyExistsException {
        if (!getClients().containsKey(client.getName())) {
            getClients().put(client.getName(), client);
            return client;
        } else {
            throw new ClientAlreadyExistsException(client.getName());
        }
    }

    @Override
    public void deleteClient(Client client) throws ClientNotFoundException {
        if (getClients().containsKey(client.getName())) {
            getClients().remove(client.getName());
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
