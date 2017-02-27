package ua.spalah.bank.command;


import ua.spalah.bank.IO.AbstractCommand;
import ua.spalah.bank.IO.IO;
import ua.spalah.bank.services.BankReportService;

public class GetBankInfoCommand extends AbstractCommand implements Command{
private final BankReportService bankReportService;

    public GetBankInfoCommand(BankReportService bankReportService, IO io) {
        super(io);
        this.bankReportService = bankReportService;
    }

    @Override
    public void execute() {
        write("Full info about this bank. \n " +
                "Number of clients: " + bankReportService.getNumberOfClients(BankCommander.currentBank) + "\n " +
                "Number of accounts: " + bankReportService.getNumberOfAccounts(BankCommander.currentBank) + "\n" +
                "Total account sum: " + bankReportService.getTotalAccountSum(BankCommander.currentBank) + "\n" +
                "Bank credit sum: " + bankReportService.getBankCreditSum(BankCommander.currentBank) + "\n" +
                "Clients sorted by name: " + bankReportService.getClientsSortedByName(BankCommander.currentBank) + "\n");
    }

    @Override
    public String getCommandInfo() {
        return "Get full info about selected bank.";
    }
}
