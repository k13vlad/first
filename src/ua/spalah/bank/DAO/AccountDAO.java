package ua.spalah.bank.DAO;

import ua.spalah.bank.models.Account;

import java.util.List;

public interface AccountDAO {
    Account save(long clientId, Account Account);

    Account update(long clientId, Account Account);

    Account saveOrUpdate(long clientId, Account Account);

    void delete(long id);

    Account find(long id);

    List<Account> findAll();

    List<Account> findByClientId(long clientId);

    Account findActiveAccountByClientName(String clientName);

    void deleteByClientId(long clientId);
}
