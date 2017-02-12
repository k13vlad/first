package ua.spalah.bank.command;


import ua.spalah.bank.IO.SocketIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BankServer extends BankCommander {
    private int port = 1313;
    public BankServer() {
        super(new SocketIO());
    }


    public void run() {
        Scanner in = new Scanner(System.in);
        SocketIO socketIO = (SocketIO) io;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            socketIO.initSocketIO(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            io.write("Display the menu ? \n Insert number:1 - yes, 2 - no, and exit.");
            if (in.nextInt() == 1) {
                for (int i = 0; i < commands.length; i++) {
                    io.write(i + 1 + ". " + commands[i].getCommandInfo());

                }
                io.write("\n");

                try {
                    io.write("Select command by entering number.");
                    int command = in.nextInt();
                    commands[command - 1].execute();

                } catch (IllegalArgumentException e) {
                    io.write(e.getMessage());
                }
            } else {
                commands[10].execute();
            }
        }
    }

    public static void main(String[] args) {
      BankServer bankServer = new BankServer();
      bankServer.run();
    }

}
