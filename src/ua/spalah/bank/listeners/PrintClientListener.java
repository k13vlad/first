package ua.spalah.bank.listeners;


import ua.spalah.bank.models.Client;

public class PrintClientListener implements ClientRegistrationListener{
    @Override
    public void onClientAdded(Client client){
        System.out.println(client.toString());
    }
}
