package ua.spalah.bank.IO;


public class AbstractCommand{

    private final IO io;

    public AbstractCommand(IO io) {
        this.io = io;
    }

    protected String read() {
        return io.read();
    }

    protected void write(String s) {
        io.write(s);
    }
}
