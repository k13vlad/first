package bank_application;

public class SavingAccount extends Account {


    public SavingAccount(double balance) {
        super(balance);
    }

    @Override
    public String toString() {
        return "Your SavingAccount balance is: " + getBalance();
    }


}
