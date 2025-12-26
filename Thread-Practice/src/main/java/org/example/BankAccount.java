package org.example;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final ReentrantLock lock = new ReentrantLock();
    private int balance;

    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }
    public void withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
            }
        } finally {
            lock.unlock();
        }
    }
    public void transfer(BankAccount to, int amount) {
        lock.lock();
        try {
            withdraw(amount);
            to.deposit(amount);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.balance = 200;
        bankAccount.transfer(bankAccount, 300);
        System.out.println("balance: " + bankAccount.balance);
    }
}
