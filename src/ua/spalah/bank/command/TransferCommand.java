package ua.spalah.bank.command;


import ua.spalah.bank.Exceptions.ClientNotFoundException;
import ua.spalah.bank.Exceptions.NotEnoughMoneyException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.AccountService;
import ua.spalah.bank.services.ClientService;

import java.util.Scanner;

public class TransferCommand implements Command {

    private final AccountService accountService;
    private final ClientService clientService;

    public TransferCommand(AccountService accountService, ClientService clientService) {
        this.accountService = accountService;
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        Account activeAccount = BankCommander.currentClient.getActiveAccount();
        Scanner in = new Scanner(System.in);
        System.out.println("Which client will have this money? Enter the name");
        String name = in.nextLine();

        try {
            Client toClient = clientService.findClientByName(BankCommander.currentBank, name);
            System.out.println("Enter transfer sum");
            double sum = in.nextDouble();
            accountService.transfer(activeAccount, toClient.getActiveAccount(), sum);
        } catch (ClientNotFoundException | NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getCommandInfo() {
        return "Transfer money between accounts";
    }
}
