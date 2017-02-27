package ua.spalah.bank.command;

import classes_homework.Bank;
import ua.spalah.bank.IO.AbstractCommand;
import ua.spalah.bank.IO.IO;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.services.ClientService;

import java.util.ArrayList;

public class GetAccountsCommand extends AbstractCommand implements Command{

    public final ClientService clientService;

    public GetAccountsCommand(IO io, ClientService clientService) {
        super(io);
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        ArrayList<Account> accounts = BankCommander.currentClient.getAccounts();
        Account activeAccount = BankCommander.currentClient.getActiveAccount();
        write("Accounts of this client: " + accounts + "\n" + "Active account: " + activeAccount);
    }

    @Override
    public String getCommandInfo() {
        return "Get current user accounts.";
    }
}
