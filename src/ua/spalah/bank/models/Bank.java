package ua.spalah.bank.models;

import ua.spalah.bank.listeners.ClientRegistrationListener;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Bank {

        private List<Client> clients = new ArrayList<>();


        public List<Client> getClients() {
            return clients;
        }

        public void setClients(List<Client> clients) {
            this.clients = clients;
        }
//    private ArrayList<Client> clientNames = new ArrayList<>();
//
//
//    public ArrayList<Client> getClientNames() {
//        return clientNames;
//    }
//
//
//
//    public void newClient(Client client) {
//        clientNames.add(client);
//    }
//
//    public List<Client> getAllClients() {
//        return Collections.unmodifiableList(clientNames);
//    }
//
//    public Client getClientInfo(String name) {
//        for (Client client : clientNames) {
//            if (client.getName().equals(name)) {
//                return client;
//            }
//        }
//        return null;
//    }
//
//    public void deleteClient(Client client) {
//        if (clientNames.contains(client)) {
//            clientNames.remove(client);
//        }
//    }

}
