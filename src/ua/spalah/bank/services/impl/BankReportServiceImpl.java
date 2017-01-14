package ua.spalah.bank.services.impl;

import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.BankReportService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class BankReportServiceImpl implements BankReportService {

    @Override
    public int getNumberOfClients(Bank bank) {
        int counter = 0;
        for (int i = 0; i < bank.getAllClients().size(); i++) {
            counter++;
        }
        return counter;
    }

    @Override
    public int getNumberOfAccounts(Bank bank) {
        int numberOfAccounts = 0;
        for (Client client : bank.getAllClients()) {
            numberOfAccounts += client.getAccounts().size();
        }
        return numberOfAccounts;
    }

    @Override
    public double getTotalAccountSum(Bank bank) {
        double totalSum = 0;
        for (Client client : bank.getAllClients()) {
            totalSum += client.getTotalBalance();
        }
        return totalSum;
    }

    @Override
    public double getBankCreditSum(Bank bank) {
        double creditSum = 0;
        for (Client client : bank.getAllClients()) {

        }

        return 0;
    }

    @Override
    public List<Client> getClientsSortedByName(Bank bank) {
        List<Client> clients = new ArrayList<>(bank.getAllClients());
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return clients;
    }
}
