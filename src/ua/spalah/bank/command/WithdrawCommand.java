package ua.spalah.bank.command;
import ua.spalah.bank.Exceptions.NotEnoughMoneyException;
import ua.spalah.bank.IO.AbstractCommand;
import ua.spalah.bank.IO.IO;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.services.AccountService;

import java.util.Scanner;

public class WithdrawCommand extends AbstractCommand implements Command {

    private final AccountService accountService;

    public WithdrawCommand(AccountService accountService, IO io) {
        super(io);
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        Account activeAccount = BankCommander.currentClient.getActiveAccount();
        Scanner scanner = new Scanner(System.in);
        write("Enter, how much money you want to withdraw");
        double sum = scanner.nextDouble();
        try {
            accountService.withdraw(activeAccount, sum);
        } catch (NotEnoughMoneyException e) {
            write(e.getMessage());
        }

    }

    @Override
    public String getCommandInfo() {
        return "Withdraw some money on selective account";
    }
}
