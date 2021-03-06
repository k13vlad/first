package bank_application;

public abstract class Account {
    private double balance;

    public Account(double balance) {
        if (balance < 0) {
            System.out.println("Balance is less than 0!");
        } else {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double money) {
        balance = money;
    }

    public void deposit(double money) {
        if (money <= 0) {
            System.out.println("You want to add no money!");
        } else {
            balance += money;
        }
    }

    public void withdraw(double money) {
        if (money > balance) {
            System.out.println("You have not enough money.");
        } else {
            balance -= money;
        }
    }

    public abstract String toString();
}
