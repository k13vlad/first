package ua.spalah.bank.command;

import java.util.List;
import java.util.Scanner;

import ua.spalah.bank.models.Account;
import ua.spalah.bank.services.AccountType;


public class SelectActiveAccountCommand implements Command {
    Scanner in = new Scanner(System.in);

    @Override
    public void execute() {
        List<Account> accountList = BankCommander.currentClient.getAccounts();
        System.out.println("Choose active account and enter number of account\n");
        for (int i = 0; i < accountList.size(); i++) {
            int counter = i + 1;
            System.out.println("Account number: " + counter);
            counter = 0;
        }
        int accountNumber = in.nextInt();
        BankCommander.currentClient.setActiveAccount(accountList.get(accountNumber - 1));
    }

    @Override
    public String getCommandInfo() {
        return "Select active account.";
    }
}
