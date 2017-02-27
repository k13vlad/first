package ua.spalah.bank.services.impl;

import ua.spalah.bank.DAO.AccountDAO;
import ua.spalah.bank.DAO.ClientDAO;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.BankReportService;
import ua.spalah.bank.services.ClientService;

import java.util.*;


public class BankReportServiceImpl implements BankReportService {

    private ClientDAO clientDAO;
    private AccountDAO accountDAO;
    private ClientService clientService;

    public BankReportServiceImpl(ClientService clientService, ClientDAO clientDAO, AccountDAO accountDAO) {
    this.clientDAO = clientDAO;
    this.accountDAO = accountDAO;
    this.clientService = clientService;
    }

    @Override
    public int getNumberOfClients() {
        return clientDAO.findAll().size();
    }

    @Override
    public int getNumberOfAccounts() {
        return accountDAO.findAll().size();
    }

    @Override
    public double getTotalAccountSum() {
        double totalSum = 0;
        for (Client client : clientDAO.findAll()) {
            totalSum += clientService.getTotalBalance(client);
        }
        return totalSum;
    }


    public double getBankCreditSum() {
        double creditSum = 0;

        for (Client client : clientDAO.findAll()) {
            for (Account account : client.getAccounts()) {
                if (account.getBalance() < 0) {
                    creditSum += Math.abs(account.getBalance());
                }
            }
        }
        return creditSum;
    }

    @Override
    public List<Client> getClientsSortedByName() {
        List<Client> clients = new ArrayList<>(clientDAO.findAll());
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return clients;
    }

    @Override
    public Map<String, List<Client>> getClientsByCity() {
        Map<String, List<Client>> clients = new HashMap<>();
        for (Client client : clientDAO.findAll()) {
            if (!clients.containsKey(client.getCity())) {
                List<Client> clientList = new ArrayList<>();
                clientList.add(client);
                clients.put(client.getCity(), clientList);
            } else {
                List<Client> clientList = clients.get(client.getCity());
                clientList.add(client);
            }
        }
        System.out.println(clients.size());
        return clients;
    }
}
