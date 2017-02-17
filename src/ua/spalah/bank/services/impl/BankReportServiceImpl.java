package ua.spalah.bank.services.impl;

import ua.spalah.bank.Accounts.CheckingAccount;
import ua.spalah.bank.command.BankCommander;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.AccountType;
import ua.spalah.bank.services.BankReportService;

import java.util.*;


public class BankReportServiceImpl implements BankReportService {

    @Override
    public int getNumberOfClients() {
        return bank.getClients().size();
    }

    @Override
    public int getNumberOfAccounts() {
        int numberOfAccounts = 0;
        for (Client client : bank.getClients().values()) {
            numberOfAccounts += client.getAccounts().size();
        }
        return numberOfAccounts;
    }

    @Override
    public double getTotalAccountSum() {
        double totalSum = 0;
        for (Client client : bank.getClients().values()) {
            ClientServiceImpl clientService = new ClientServiceImpl();
            totalSum += clientService.getTotalBalance(client);
        }
        return totalSum;
    }


    public double getBankCreditSum() {
        double creditSum = 0;

        for (Client client : bank.getClients().values()) {
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
        List<Client> clients = new ArrayList<>(bank.getClients().values());
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
        for (Client client : BankCommander.currentBank.getClients().values()) {
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
