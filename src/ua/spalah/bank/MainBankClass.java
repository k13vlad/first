package ua.spalah.bank;

import ua.spalah.bank.Accounts.CheckingAccount;
import ua.spalah.bank.Accounts.SavingAccount;
import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;

import java.util.Scanner;

public class MainBankClass {
    public static void main(String[] args) {

        Bank bank = new Bank();
        Client gena = new Client("Gena", Gender.Male);
        Client tanya = new Client("Tanya", Gender.Female);
        Client azik = new Client("Azik", Gender.Male);

        SavingAccount sa = new SavingAccount(1000);
        CheckingAccount ca = new CheckingAccount(500, 200);
        gena.newAccount(sa);
        gena.newAccount(ca);
        gena.setActiveAccount(ca);
        bank.newClient(gena);


        Scanner in = new Scanner(System.in);
        System.out.println("Write client's name... ");
        String name = in.nextLine();
        System.out.println(bank.getClientInfo(name));

        System.out.println(gena.equals(tanya));
        System.out.println(gena.hashCode());
        System.out.println(tanya.hashCode());

        ca.withdraw(323); //как вытащить метод?
        System.out.println(ca.getBalance());

        System.out.println(Gender.Male);


    }
}
