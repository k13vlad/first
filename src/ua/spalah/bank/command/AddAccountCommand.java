package ua.spalah.bank.command;


import ua.spalah.bank.Accounts.CheckingAccount;
import ua.spalah.bank.Accounts.SavingAccount;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.services.ClientService;

import java.util.Scanner;

public class AddAccountCommand implements Command {
    private final ClientService clientService;

    public AddAccountCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        if (BankCommander.currentClient == null) {
            System.out.println("You did not choose client");
        } else {

            System.out.println("Choose account type. \n Saving account, press: 1 \n Checking account, press: 2");
            Scanner in = new Scanner(System.in);

            int accountTypeInt = in.nextInt();
            System.out.println("Enter start balance ");
            double balance = in.nextDouble();

            Account account = null;
            boolean correctType = false;

            switch (accountTypeInt) {
                case 1: {
                    correctType = true;
                    account = new SavingAccount(balance);
                    break;
                }
                case 2: {
                    correctType = true;
                    System.out.println("Enter the overdraft for your account");
                    double overdraft = in.nextDouble();
                    account = new CheckingAccount(balance, overdraft);
                    break;
                }
                default:
                    System.out.println("Unknown account type.");
            }
            if (correctType) {
                clientService.addAccount(BankCommander.currentClient, account);
                if (BankCommander.currentClient.getAccounts().size() == 1) {
                    BankCommander.currentClient.setActiveAccount(account);
                } else {
                    System.out.println("Do you want to do this account active? \n If yes, enter: 1 \n No, enter: 2");
                    if ((in.nextInt() == 1)) {
                        BankCommander.currentClient.setActiveAccount(account);
                    }
                }
                System.out.println("Operation complete. Thank you.");
            }
        }
    }

    @Override
    public String getCommandInfo() {
        return "Add new account to active client.";
    }
}
