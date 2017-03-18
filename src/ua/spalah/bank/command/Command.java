package ua.spalah.bank.command;

public interface Command {

    void execute();

    String getCommandInfo();
}
