package ua.spalah.bank.services.impl;

import ua.spalah.bank.DAO.AccountDAO;
import ua.spalah.bank.DAO.ClientDAO;
import ua.spalah.bank.Exceptions.ClientAlreadyExistsException;
import ua.spalah.bank.Exceptions.ClientNotFoundException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.ClientService;

import java.util.List;
import java.util.Map;

public class ClientServiceImpl implements ClientService {


    private ClientDAO clientDAO;

    @Override
    public Client findClientByName(String name) throws ClientNotFoundException {
        Client client = clientDAO.findByName(name);
        if (client.getName().equalsIgnoreCase(name)) {
            return client;
        }
        return null;
    }

    @Override
    public List<Client> findAllClients() {
        return clientDAO.findAll();
    }

    @Override
    public Client saveClient(Client client) throws ClientAlreadyExistsException {
        if (!clientDAO.findAll().contains(client.getName())) {
            return clientDAO.saveOrUpdate(client);
        } else {
            throw new ClientAlreadyExistsException(client.getName());
        }
    }

    @Override
    public void deleteClient(Client client) throws ClientNotFoundException {
        if (clientDAO.findAll().contains(client)) {
            clientDAO.delete(client.getId());
        } else{
            throw new ClientNotFoundException(client.getName());
        }
    }

    public void addAccount(Client client, Account account) {
        client.getAccounts().add(account);
        if (client.getAccounts().size() == 0) {
            client.setActiveAccount(account);
        }
        client.getAccounts().add(account);
    }

    @Override
    public double getTotalBalance(Client client) {
        double totalBalance = 0;
        for (Account account : client.getAccounts()) {
            totalBalance += client.getTotalBalance();
        }
        return totalBalance;
    }


}
