package ua.spalah.bank.command;


import ua.spalah.bank.services.BankReportService;

public class GetBankInfoCommand implements Command{
private final BankReportService bankReportService;

    public GetBankInfoCommand(BankReportService bankReportService) {
        this.bankReportService = bankReportService;
    }

    @Override
    public void execute() {
        System.out.println("Full info about this bank. \n " +
                "Number of clients: " + bankReportService.getNumberOfClients(BankCommander.currentBank) + "\n " +
                "Number of accounts: " + bankReportService.getNumberOfAccounts(BankCommander.currentBank) + "\n" +
                "Total account sum: " + bankReportService.getTotalAccountSum(BankCommander.currentBank) + "\n" +
                "Bank credit sum: " + bankReportService.getBankCreditSum(BankCommander.currentBank) + "\n" +
                "Clients sorted by name: " + bankReportService.getClientsSortedByName(BankCommander.currentBank));
    }

    @Override
    public String getCommandInfo() {
        return "Get full info about selected bank.";
    }
}
