package bank;


public class BankAccount {
    private final String id;
    private int balance;

    public BankAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public synchronized boolean transferTo(BankAccount target, int amount) {
        if (this.balance < amount) return false;
        this.balance -= amount;
        target.deposit(amount);
        return true;
    }

    public synchronized void deposit(int amount) {
        this.balance += amount;
    }

    public synchronized int getBalance() {
        return balance;
    }
    public String getId() {
        return id;
    }

}
