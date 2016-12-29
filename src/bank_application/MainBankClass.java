package bank_application;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

import static bank_application.Gender.Male;

public class MainBankClass {
    public static void main(String[] args) {

        NewBank bank = new NewBank();
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

        ca.withdraw(323);
        System.out.println(ca.getBalance());

//        System.out.println(Gender.Male);
    }
}
