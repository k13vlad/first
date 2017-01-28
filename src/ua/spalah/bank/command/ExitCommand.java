package ua.spalah.bank.command;


public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getCommandInfo() {
        return "Exit of program.";
    }
}
