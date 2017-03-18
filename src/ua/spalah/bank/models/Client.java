package ua.spalah.bank.models;

import ua.spalah.bank.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    private String name;
    private Gender gender;
    private Account activeAccount;
    private List<Account> accounts = new ArrayList<>();
    private String email;
    private String tel;
    private String city;
    private long id;

//    public Client(String name, Gender gender, Account activeAccount, ArrayList<Account> accounts, String email, String tel, String city, long id) {
//        this.name = name;
//        this.gender = gender;
//        this.activeAccount = activeAccount;
//        this.accounts = accounts;
//        this.email = email;
//        this.tel = tel;
//        this.city = city;
//        this.id = id;
//    }


    public Client(String name, Gender gender, String email, String tel, String city) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.tel = tel;
        this.city = city;
    }

    public Client(long id, String name, Gender gender, String email, String tel, String city) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Account getActiveAccount() {
        return activeAccount;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    public void newAccount(Account account) {

        if (accounts.size() == 0) {
            activeAccount = account;
        }
        accounts.add(account);
    }


    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }


    public double getTotalBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    @Override
    public String toString() {
        return "Client[" +
                "name: " + name +
                ", gender: " + gender + "\n" +
                "activeAccount: " + activeAccount + "\n" +
                "email: " + email +
                ", tel: " + tel +
                ", city:" + city +
                ']';
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Client other = (Client) otherObject;
        return Objects.equals(name, other.name) && Objects.equals(gender, other.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}

