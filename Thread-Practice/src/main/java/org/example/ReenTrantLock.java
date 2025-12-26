package org.example;

import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLock {
    private final ReentrantLock reentrantLock = new ReentrantLock();

    public void outer() {
        reentrantLock.lock();
        try {
            System.out.println("In Outer");
            inner();
        } finally {
            reentrantLock.unlock();
        }
    }
    public void inner() {
        reentrantLock.lock();
        try {
            System.out.println("In Inner");
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReenTrantLock reentrantLock = new ReenTrantLock();
        reentrantLock.outer();
    }
}
