package ua.spalah.bank.services.impl;

import ua.spalah.bank.Accounts.CheckingAccount;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.AccountType;
import ua.spalah.bank.services.BankReportService;

import java.util.Comparator;
import java.util.List;


public class BankReportServiceImpl implements BankReportService {

    @Override
    public int getNumberOfClients(Bank bank) {
        return bank.getClients().size();
    }

    @Override
    public int getNumberOfAccounts(Bank bank) {
        int numberOfAccounts = 0;
        for (Client client : bank.getClients()) {
            numberOfAccounts += client.getAccounts().size();
        }
        return numberOfAccounts;
    }

    @Override
    public double getTotalAccountSum(Bank bank) {
        double totalSum = 0;
        for (Client client : bank.getClients()) {
            totalSum += client.getTotalBalance();
        }
        return totalSum;
    }

    @Override
    public double getBankCreditSum(Bank bank) {
        double creditSum = 0;
        for (Client client : bank.getClients()) {
            for (Account account : client.getAccounts()) {
                if (account.getAccountType().equals(AccountType.Checking)) {
                    CheckingAccount checkingAccount = (CheckingAccount) account;
                    creditSum += checkingAccount.getOverdraft();
                }
            }
        }
        return creditSum;
    }

    @Override
    public List<Client> getClientsSortedByName(Bank bank) {
        List<Client> clients = bank.getClients();
        clients.sort(new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return clients;
    }
}
