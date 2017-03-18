package ua.spalah.bank.command;

import ua.spalah.bank.IO.AbstractCommand;
import ua.spalah.bank.IO.IO;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.services.ClientService;

import java.util.List;
import java.util.Scanner;


public class SelectActiveAccountCommand extends AbstractCommand implements Command {
    private final ClientService clientService;
    Scanner in = new Scanner(System.in);

    public SelectActiveAccountCommand(IO io, ClientService clientService) {
        super(io);
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        List<Account> accountList = BankCommander.currentClient.getAccounts();
        write("Choose active account and enter number of account\n");
        for (int i = 0; i < accountList.size(); i++) {
            int counter = i + 1;
            write("Account number: " + counter);
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
