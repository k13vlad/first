package ua.spalah.bank.IO;


import ua.spalah.bank.Exceptions.NetException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketIO implements IO{

    private DataInputStream in;
    private DataOutputStream out;
    private StringBuilder buffer;

    @Override
    public String read() {
        try {
            out.writeUTF(buffer.toString());
            out.flush();
            buffer = new StringBuilder();

            return in.readUTF();
        } catch (IOException e) {
            throw new NetException("Can't read from socket", e);
        }
    }

    @Override
    public void write(String s) {
        buffer.append(s);
    }

    public void initSocketIO(Socket socket) {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            buffer = new StringBuilder();
        } catch (IOException e) {
            throw new RuntimeException("Troubles with socket", e);
        }
    }
}
