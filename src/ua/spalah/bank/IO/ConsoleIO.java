package ua.spalah.bank.IO;

import java.util.Scanner;

public class ConsoleIO implements IO {

    private Scanner in = new Scanner(System.in);

    @Override
    public String read() {
        return in.nextLine();
    }

    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
