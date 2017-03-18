package ua.spalah.bank.listeners;


import ua.spalah.bank.models.Client;

public class EmailNotificationListener implements ClientRegistrationListener{
    @Override
    public void onClientAdded(Client client){
        System.out.println("Email notification for client " + client.getName() + " has been sent.");
    }
}
