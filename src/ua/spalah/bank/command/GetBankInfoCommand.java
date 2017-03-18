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
                "Number of clients: " + bankReportService.getNumberOfClients() + "\n " +
                "Number of accounts: " + bankReportService.getNumberOfAccounts() + "\n" +
                "Total account sum: " + bankReportService.getTotalAccountSum() + "\n" +
                "Bank credit sum: " + bankReportService.getBankCreditSum() + "\n" +
                "Clients sorted by name: " + bankReportService.getClientsSortedByName() + "\n");
    }

    @Override
    public String getCommandInfo() {
        return "Get full info about selected bank.";
    }
}
