package concurrency;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        System.out.println("Producer method ...");
        condition.await();
        System.out.println("Again the producer method ...");
        lock.unlock();
    }
    public void consume() throws InterruptedException {
        // we want to make sure that we start with the producer
        Thread.sleep(2000);
        lock.lock();
        System.out.println("Consumer method ...");
        Thread.sleep(3000);
        // notify
        condition.signal();
        lock.unlock();
        Map<String, String> map = new HashMap<>();
        Map<String, String> table = new Hashtable<>();
    }
}

public class ProducerAndConsumerWithLock {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {}
            }
        });
    }
}
