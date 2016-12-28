package bank_application;


public class CheckingAccount extends Account{

    private double overdraft;

    public CheckingAccount(double balance, double overdraft) {
        super(balance);
        if (overdraft < 0) {
            System.out.println("Overdraft < 0");
        } else {
            this.overdraft = overdraft;
        }
    }

    @Override
    public void withdraw(double money) {
        double available = getBalance() + overdraft;
        if (available < money) {
            System.out.println("You're going out of overdraft limit");
        } else {
            setBalance(getBalance() - money);
        }
    }

    @Override
    public String toString() {
        return "Your checkingAccount balance is: " + getBalance() + " , overdraft is " + overdraft;
    }

}
