package ua.spalah.bank.command;


import ua.spalah.bank.DAO.AccountDAO;
import ua.spalah.bank.DAO.ClientDAO;
import ua.spalah.bank.DAO.DAOImpl.AccountDAOImpl;
import ua.spalah.bank.DAO.DAOImpl.ClientDAOImpl;
import ua.spalah.bank.Exceptions.ClientAlreadyExistsException;
import ua.spalah.bank.IO.IO;
import ua.spalah.bank.IO.SocketIO;
import ua.spalah.bank.IO.ConsoleIO;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.AccountService;
import ua.spalah.bank.services.BankReportService;
import ua.spalah.bank.services.ClientService;
import ua.spalah.bank.services.impl.AccountServiceImpl;
import ua.spalah.bank.services.impl.BankReportServiceImpl;
import ua.spalah.bank.services.impl.ClientServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class BankCommander {
    // хранит в себе банк с кототорым мы работаем
//    public static Bank currentBank;

    // хранит в себе клиента с которым мы работаем в данный момент
    public static Client currentClient;
    public static Connection connection;
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

            AccountDAO accountDao = new AccountDAOImpl();
            ClientDAO clientDao = new ClientDAOImpl(accountDao);
            ClientService clientService = new ClientServiceImpl();
            AccountService accountService = new AccountServiceImpl();
            BankReportService bankReportService = new BankReportServiceImpl();
            IO ConsoleIO = new ConsoleIO();
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/E:\\database\\bankdata", "sa", "");
//            Bank bank = new Bank();
//
//            Client victor = new Client("Victor", Gender.Male, "victor22@gmail.com", "+380786541235", "Bern");
//            Client amelia = new Client("Amelia", Gender.Female, "amelia11@gmail.com", "+380916547821", "Vienna");
//            Client olivia = new Client("Olivia", Gender.Female, "olivia92@gmail.com", "+385213548465", "London");
//            Client anthony = new Client("Anthony", Gender.Male, "anthony44@gmail.com", "+381256489524", "LA");
//
//
//            SavingAccount vs = new SavingAccount(10000);
//            CheckingAccount vc = new CheckingAccount(5000, 1000);
//
//            SavingAccount ams = new SavingAccount(7000);
//            CheckingAccount amc = new CheckingAccount(5000, 2000);
//
//            SavingAccount os = new SavingAccount(4000);
//            CheckingAccount oc = new CheckingAccount(3000, 700);
//
//            SavingAccount ans = new SavingAccount(15000);
//            CheckingAccount anc = new CheckingAccount(10000, 10000);
//
//            clientService.saveClient(victor);
//            clientService.saveClient(amelia);
//            clientService.saveClient(olivia);
//            clientService.saveClient(anthony);
//
//            clientService.addAccount(victor, vs);
//            clientService.addAccount(victor, vc);
//
//            clientService.addAccount(amelia, ams);
//            clientService.addAccount(amelia, amc);
//
//            clientService.addAccount(olivia, os);
//            clientService.addAccount(olivia, oc);
//
//            clientService.addAccount(anthony, ans);
//            clientService.addAccount(anthony, anc);
//
//            currentBank = bank;

            this.commands = new Command[]{
                    new FindClientCommand(clientService, ConsoleIO),
                    new GetAccountsCommand(clientService, ConsoleIO),
                    new SelectActiveAccountCommand(ClientService, ConsoleIO),
                    new DepositCommand(accountService, ConsoleIO),
                    new WithdrawCommand(accountService, ConsoleIO),
                    new TransferCommand(accountService, clientService, ConsoleIO),
                    new AddClientCommand(clientService, ConsoleIO),
                    new AddAccountCommand(clientService, AccountService,  ConsoleIO),
                    new RemoveClientCommand(clientService, ConsoleIO),
                    new GetBankInfoCommand(bankReportService, ConsoleIO),
                    new ExitCommand()
            };

        } catch (Exception e) {
            RuntimeException ex = new RuntimeException("Initialization error");
            ex.initCause(e);
            throw ex;
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

            System.out.print("\n");
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


}
