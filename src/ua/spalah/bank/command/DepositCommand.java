package ua.spalah.bank.command;


import ua.spalah.bank.models.Account;
import ua.spalah.bank.services.AccountService;
import ua.spalah.bank.services.impl.AccountServiceImpl;


import java.util.Scanner;


public class DepositCommand implements Command {

    private final AccountService accountService;

    public DepositCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        Account activeAccount = BankCommander.currentClient.getActiveAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter, how much money you want to deposite");
        double sum = scanner.nextDouble();
        accountService.deposit(activeAccount, sum);
    }

    @Override
    public String getCommandInfo() {
        return "Deposit money on selected account";
    }
}
