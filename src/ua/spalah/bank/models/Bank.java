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


}
