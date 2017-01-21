package ua.spalah.bank.command;

import java.util.List;
import java.util.Scanner;

import ua.spalah.bank.models.Account;


public class SelectActiveAccountCommand implements Command {
    Scanner in = new Scanner(System.in);

    @Override
    public void execute() {
        List<Account> accountList = BankCommander.currentClient.getAccounts();
        System.out.println("Choose active account and enter number of account");
        int accountNumber = in.nextInt();
        BankCommander.currentClient.setActiveAccount(accountList.get(accountNumber - 1));
    }

    @Override
    public String getCommandInfo() {
        return "Select active account.";
    }
}
