package ua.spalah.bank.command;


import ua.spalah.bank.Exceptions.ClientNotFoundException;
import ua.spalah.bank.IO.AbstractCommand;
import ua.spalah.bank.IO.IO;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.ClientService;

import java.util.Scanner;

public class RemoveClientCommand extends AbstractCommand implements Command{

    private final ClientService clientService;

    public RemoveClientCommand(ClientService clientService, IO io) {
        super(io);
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        write("Please enter name of client");
        Scanner in = new Scanner(System.in);
        String name  = in.nextLine();
        try {
            Client client = clientService.findClientByName(name);
            write("Client " + name + " was successfully deleted.");
        } catch (ClientNotFoundException e) {
            write(e.getMessage());
        }
    }

    @Override
    public String getCommandInfo() {
        return "Delete selected client.";
    }
}
