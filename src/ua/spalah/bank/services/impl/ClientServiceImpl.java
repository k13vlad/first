package ua.spalah.bank.services.impl;

import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {


    @Override
    public Client findClientByName(Bank bank, String name) {
        return bank.getClientInfo(name);
    }

    @Override
    public List<Client> findAllClients(Bank bank) {
        List<Client> allClients = bank.getAllClients();
        return allClients;
    }

    @Override
    public Client saveClient(Bank bank, Client client) {
        bank.newClient(client);
        return client;
    }

    @Override
    public void deleteClient(Bank bank, Client client) {
        bank.deleteClient(client);
    }
}
