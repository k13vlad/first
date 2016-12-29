package bank_application;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class NewBank {


    private ArrayList<Client> clientNames = new ArrayList<>();


    public void newClient(Client client) {
        clientNames.add(client);
    }

    public List<Client> getAllClients() {
        return Collections.unmodifiableList(clientNames);
    }

    public String getClientInfo(String name) {
        for (Client client : clientNames) {
            if (client.getName().equals(name)) {
                return client.toString();
            }
        }
        return "can't found client";
    }
}
