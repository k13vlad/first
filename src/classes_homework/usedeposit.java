package classes_homework;


import java.util.Scanner;

public class usedeposit {

    public static void main(String[] args) {

        Bank bank = new Bank("AAA");
        deposit deposit1 = new deposit(1000, 10, "Ara");
        deposit deposit2 = new deposit(2000, 10, "Ara2");
        deposit deposit3 = new deposit(3000, 15, "Ara3");

        bank.addDeposit(deposit1);
        bank.addDeposit(deposit2);
        bank.addDeposit(deposit3);

        Scanner in = new Scanner(System.in);
        System.out.println("How many years do you need for deposit?");
        int year = in.nextInt();

        for (int j = 0; j < 3; j++){
            System.out.println(bank.getMoney(year)[j]);
        }
    }

}
