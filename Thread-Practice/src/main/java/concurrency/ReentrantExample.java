package concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantExample {
    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    public synchronized void outerMethod() {
        try {
            System.out.println("Entered outerMethod");
            innerMethod();
            System.out.println("Exiting outerMethod");
        } catch (Exception e) {
            throw new RuntimeException("abc");
        }

    }
    public void innerMethod(){
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println("Entered innerMethod");
            // Do something
            System.out.println("Exiting innerMethod");
        } catch (RuntimeException e) {
            throw new RuntimeException("Abc");
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantExample obj = new ReentrantExample();

        Thread thread = new Thread(obj::outerMethod);

        thread.start();
    }
}
