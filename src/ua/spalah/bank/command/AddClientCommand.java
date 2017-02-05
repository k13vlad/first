package ua.spalah.bank.command;

import ua.spalah.bank.Exceptions.ClientAlreadyExistsException;
import ua.spalah.bank.Gender;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.ClientService;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        while (!isCorrectEmail(email)){
            System.out.println("E-mail is incorrect.");
            System.out.println("Enter correct user's email.");
            email = in.nextLine();
        }


        System.out.println("Enter user's phone number");
        String tel = in.nextLine();

        while (!isCorrectTel(tel)){
            System.out.println("Client's phone number is incorrect.");
            System.out.println("Enter the correct number.");
            tel = in.nextLine();
        }

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
