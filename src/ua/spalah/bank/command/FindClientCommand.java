package ua.spalah.bank.command;


import ua.spalah.bank.Exceptions.ClientNotFoundException;
import ua.spalah.bank.IO.AbstractCommand;
import ua.spalah.bank.IO.IO;
import ua.spalah.bank.services.ClientService;
import java.util.Scanner;

public class FindClientCommand extends AbstractCommand implements Command{

    private final ClientService clientService;

    public FindClientCommand(ClientService clientService, IO io) {
        super(io);
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        write("Please enter client name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        try {
            BankCommander.currentClient = clientService.findClientByName(BankCommander.currentBank, name);
        } catch (ClientNotFoundException e) {
            write(e.getMessage());
        }
    }

    @Override
    public String getCommandInfo() {
        return "Find client by name.";
    }
}
