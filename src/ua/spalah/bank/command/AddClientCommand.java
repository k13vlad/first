package ua.spalah.bank.command;

import ua.spalah.bank.Gender;
import ua.spalah.bank.services.ClientService;

import java.util.Scanner;

public class AddClientCommand implements Command {
    private final ClientService clientService;

    public AddClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        System.out.println("Enter new clien name");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Choose client's gender. Enter '1' if Male, '2' if Female");
        Gender gender = null;
        int genderInt = in.nextInt();
        if (genderInt == 1) {
            gender = Gender.Male;
        } else {
            gender = Gender.Female;
        }
    }

    @Override
    public String getCommandInfo() {
        return "Add new client to active Bank.";
    }
}
