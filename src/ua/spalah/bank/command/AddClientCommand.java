package ua.spalah.bank.command;

import ua.spalah.bank.Exceptions.ClientAlreadyExistsException;
import ua.spalah.bank.Gender;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.ClientService;

import java.util.Scanner;

public class AddClientCommand implements Command {
    private final ClientService clientService;

    public AddClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        System.out.println("Enter new client name");
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
        System.out.println("Enter user's e-mail");
        String email = in.nextLine();
        System.out.println("Enter user's phone number");
        String tel = in.nextLine();
        System.out.println("Enter user's city");
        String city = in.nextLine();
        try {
            clientService.saveClient(BankCommander.currentBank, new Client(name, gender, email, tel, city));
        } catch (ClientAlreadyExistsException e) {
            e.getMessage();
        }
    }

    @Override
    public String getCommandInfo() {
        return "Add new client to active Bank.";
    }
}
