package ua.spalah.bank.DAO.DAOImpl;

import ua.spalah.bank.DAO.AccountDAO;
import ua.spalah.bank.models.Account;

import java.util.List;

public class AccountDAOImpl implements AccountDAO{
    @Override
    public Account save(long clientId, Account Account) {
        return null;
    }

    @Override
    public Account update(long clientId, Account Account) {
        return null;
    }

    @Override
    public Account saveOrUpdate(long clientId, Account Account) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Account find(long id) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public List<Account> findByClientId(long clientId) {
        return null;
    }

    @Override
    public Account findActiveAccountByClientName(String clientName) {
        return null;
    }

    @Override
    public void deleteByClientId(long clientId) {
    }
}
