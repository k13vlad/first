package ua.spalah.bank.models;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Bank {


    private Map<String, Client> clients = new HashMap<>();

    public Map<String, Client> getClients() {
        return clients;
    }
}
