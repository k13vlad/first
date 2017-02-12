package ua.spalah.bank.command;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import ua.spalah.bank.Accounts.CheckingAccount;
import ua.spalah.bank.Accounts.SavingAccount;
import ua.spalah.bank.Exceptions.ClientAlreadyExistsException;
import ua.spalah.bank.Gender;
import ua.spalah.bank.IO.IO;
import ua.spalah.bank.IO.SocketIO;
import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.AccountService;
import ua.spalah.bank.services.BankReportService;
import ua.spalah.bank.services.ClientService;
import ua.spalah.bank.services.impl.AccountServiceImpl;
import ua.spalah.bank.services.impl.BankReportServiceImpl;
import ua.spalah.bank.services.impl.ClientServiceImpl;

import java.util.Scanner;

public class BankCommander {
    // хранит в себе банк с кототорым мы работаем
    public static Bank currentBank;

    // хранит в себе клиента с которым мы работаем в данный момент
    public static Client currentClient;
    protected IO io;

    // Список команд которые мы можем выполнять
    protected Command[] commands;

    public BankCommander(IO io) {
        this.io = io;
        init();
    }

    public BankCommander(SocketIO socketIO) {

        init();
    }


    private void init() {
        // здесь проводим инициализацию банка начальными данными
        // а также создаем все необходимые объекты команд

        try {

            ClientService clientService = new ClientServiceImpl();
            AccountService accountService = new AccountServiceImpl();
            BankReportService bankReportService = new BankReportServiceImpl();
            Bank bank = new Bank();

            Client victor = new Client("Victor", Gender.Male, "victor22@gmail.com", "+380786541235", "Bern");
            Client amelia = new Client("Amelia", Gender.Female, "amelia11@gmail.com", "+380916547821", "Vienna");
            Client olivia = new Client("Olivia", Gender.Female, "olivia92@gmail.com", "+385213548465", "London");
            Client anthony = new Client("Anthony", Gender.Male, "anthony44@gmail.com", "+381256489524", "LA");


            SavingAccount vs = new SavingAccount(10000);
            CheckingAccount vc = new CheckingAccount(5000, 1000);

            SavingAccount ams = new SavingAccount(7000);
            CheckingAccount amc = new CheckingAccount(5000, 2000);

            SavingAccount os = new SavingAccount(4000);
            CheckingAccount oc = new CheckingAccount(3000, 700);

            SavingAccount ans = new SavingAccount(15000);
            CheckingAccount anc = new CheckingAccount(10000, 10000);

            clientService.saveClient(bank, victor);
            clientService.saveClient(bank, amelia);
            clientService.saveClient(bank, olivia);
            clientService.saveClient(bank, anthony);

            clientService.addAccount(victor, vs);
            clientService.addAccount(victor, vc);

            clientService.addAccount(amelia, ams);
            clientService.addAccount(amelia, amc);

            clientService.addAccount(olivia, os);
            clientService.addAccount(olivia, oc);

            clientService.addAccount(anthony, ans);
            clientService.addAccount(anthony, anc);

            currentBank = bank;

            this.commands = new Command[]{
                    new FindClientCommand(clientService),
                    new GetAccountsCommand(),
                    new SelectActiveAccountCommand(),
                    new DepositCommand(accountService),
                    new WithdrawCommand(accountService),
                    new TransferCommand(accountService, clientService),
                    new AddClientCommand(clientService),
                    new AddAccountCommand(clientService),
                    new RemoveClientCommand(clientService),
                    new GetBankInfoCommand(bankReportService),
                    new ExitCommand()
            };

        } catch (ClientAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        // запускаем наше приложение
        // выводим в цикле доступные команды
        // ждем от пользователя выбора
        // после выбора команды передаем управление ей
        // вызываем ее метод execute
        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.println("Display the menu? \n Insert number: 1 - yes, 2 - no, and exit.");
            if (in.nextInt() == 1) {

                for (int i = 0; i < commands.length; i++) {
                    System.out.println(i + 1 + ". " + commands[i].getCommandInfo());

                }
                System.out.println("\n");


                try {
                    System.out.println("Select command by entering number.");
                    int command = in.nextInt();
                    commands[command - 1].execute();

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                commands[10].execute();
            }
        }
    }

    // запуск нашего приложения
//    public static void main(String[] args) throws Exception {
//        BankCommander bankCommander = new BankCommander();
//        bankCommander.run();
//    }
}
