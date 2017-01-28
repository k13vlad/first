package ua.spalah.bank.command;


import ua.spalah.bank.Exceptions.ClientNotFoundException;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.ClientService;

import java.util.Scanner;

public class RemoveClientCommand implements Command{

    private final ClientService clientService;

    public RemoveClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        System.out.println("Please enter name of client");
        Scanner in = new Scanner(System.in);
        String name  = in.nextLine();
        try {
            Client client = clientService.findClientByName(BankCommander.currentBank, name);
            System.out.println("Client " + name + " was successfully deleted.");
        } catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getCommandInfo() {
        return "Delete selected client.";
    }
}
