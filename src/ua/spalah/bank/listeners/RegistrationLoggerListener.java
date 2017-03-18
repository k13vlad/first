package ua.spalah.bank.listeners;


import ua.spalah.bank.models.Client;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistrationLoggerListener implements ClientRegistrationListener{
    @Override
    public void onClientAdded(Client client){
        System.out.println("Client " + client.getName() + " add on " + LocalDate.now() + " " + LocalTime.now());
    }
}
