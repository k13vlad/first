package ua.spalah.bank.services;

import ua.spalah.bank.models.Client;
import java.util.List;
import java.util.Map;

public interface BankReportService {
    int getNumberOfClients(); // общее количество клиентов

    int getNumberOfAccounts(); // общее количество счетов

    double getTotalAccountSum(); // общая сумма по всем счетам

    double getBankCreditSum(); // возвращает сумму отрицательных балансов по всем счетам

    List<Client> getClientsSortedByName(); // Возвращает список клиентов отсортированных по имени

    Map<String, List<Client>> getClientsByCity();//Возвращает клиентов сгруппированных потгороду
}
