package ua.spalah.bank.command;
import ua.spalah.bank.Exceptions.NotEnoughMoneyException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.services.AccountService;

import java.util.Scanner;

public class WithdrawCommand implements Command {

    private final AccountService accountService;

    public WithdrawCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        Account activeAccount = BankCommander.currentClient.getActiveAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter, how much money you want to withdraw");
        double sum = scanner.nextDouble();
        try {
            accountService.withdraw(activeAccount, sum);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String getCommandInfo() {
        return "Withdraw some money on selective account";
    }
}
