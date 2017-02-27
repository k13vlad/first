package ua.spalah.bank.command;

import ua.spalah.bank.Exceptions.ClientAlreadyExistsException;
import ua.spalah.bank.Gender;
import ua.spalah.bank.IO.AbstractCommand;
import ua.spalah.bank.IO.IO;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.ClientService;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddClientCommand extends AbstractCommand implements Command {
    private final ClientService clientService;

    public AddClientCommand(ClientService clientService, IO io) {
        super(io);
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        write("Enter new client name");
        Scanner in = new Scanner(System.in);
        String name = read();
        write("Choose client's gender. Enter '1' if Male, '2' if Female");
        Gender gender = null;
        String gender1 = read();
        int genderInt = Integer.parseInt(gender1);

        if (genderInt == 1) {
            gender = Gender.Male;
        } else {
            gender = Gender.Female;
        }
        write("Enter user's e-mail");
        String email = read();

        while (!isCorrectEmail(email)) {
            write("E-mail is incorrect.");
            write("Enter correct user's email.");
            email = read();
        }


        write("Enter user's phone number");
        String tel = read();

        while (!isCorrectTel(tel)) {
            write("Client's phone number is incorrect.");
            write("Enter the correct number.");
            tel = read();
        }

        write("Enter user's city");
        String city = read();
        try {
            clientService.saveClient(new Client(name, gender, email, tel, city));
        } catch (ClientAlreadyExistsException e) {
            e.getMessage();
        }
    }

    @Override
    public String getCommandInfo() {
        return "Add new client to active Bank.";
    }

    private static boolean isCorrectEmail(String email) {
        String emailRegex = "^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x07\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x07\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);
        return emailMatcher.matches();
    }

    private static boolean isCorrectTel(String phone) {
        String phoneRegex = "^[+][0-9]{12}$";
        Pattern phonePattern = Pattern.compile(phoneRegex);
        Matcher phoneMatcher = phonePattern.matcher(phone);
        return phoneMatcher.matches();
    }

}
