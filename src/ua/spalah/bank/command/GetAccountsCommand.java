package ua.spalah.bank.command;

import classes_homework.Bank;
import ua.spalah.bank.models.Account;

import java.util.ArrayList;

public class GetAccountsCommand implements Command{
    @Override
    public void execute() {
        ArrayList<Account> accounts = BankCommander.currentClient.getAccounts();
        Account activeAccount = BankCommander.currentClient.getActiveAccount();
        System.out.println(("Accounts of this client: " + accounts + "\n" + "Active account: " + activeAccount));
    }

    @Override
    public String getCommandInfo() {
        return "Get current user accounts.";
    }
}
