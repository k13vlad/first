package ua.spalah.bank.services.impl;

import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {


    @Override
    public Client findClientByName(Bank bank, String name) {
        for (Client client : bank.getClients()) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Client> findAllClients(Bank bank) {
        List<Client> allClients = bank.getClients();
        return allClients;
    }

    @Override
    public Client saveClient(Bank bank, Client client) {
        if (!bank.getClients().contains(client)) {
            bank.getClients().add(client);
            return client;
        } else {
            throw new ClientAlreadyExistsException(client.getName());
        }
        return null;
    }

    @Override
    public void deleteClient(Bank bank, Client client) {
        bank.getClients().remove(client);
    }


    public double getTotalBalance(Client client) {
        double totalBalance = 0;
        for (Account account : client.getAccounts()) {
            totalBalance += client.getTotalBalance();
        }
        return totalBalance;
    }
    public void addAccount (Client client, Account account){
        if (client.getAccounts().size() == 0) {
            client.setActiveAccount(account);
        }
        client.getAccounts().add(account);
    }
}
