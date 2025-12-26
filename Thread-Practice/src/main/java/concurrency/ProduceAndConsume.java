package concurrency;

import java.util.LinkedList;
import java.util.List;

class SharedBuffer {
    private List<Integer> buffer = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce () throws InterruptedException {
        if (buffer.size() == capacity) {
            System.out.println("Buffer full, producer waiting...");
            wait();
        }

        System.out.println("Adding items with the producer...");
        for (int i = 0; i < capacity; i++) {
            buffer.add(i);
            System.out.println("Added value: " + i);
        }
        // wake up consumer
        notify();
    }
    public synchronized void consume () throws InterruptedException {
        if (buffer.size() < capacity) {
            System.out.println("Buffer not full yet, consumer waiting...");
            wait();
        }

        while (!buffer.isEmpty()) {
            int item =  buffer.remove(0);
            System.out.println("Consumer removes: " + item);
            Thread.sleep(300);
        }

        notify();
    }

    /*
     1. Thread: keep inserting items into buffer
        - 1,2,3,4,5
     2. Thread: remove the items
        - Empty LinkedList
     */

}
class Consumer implements Runnable {
    private SharedBuffer sharedBuffer;

    public Consumer(SharedBuffer buffer) {
        this.sharedBuffer = buffer;
    }
    @Override
    public void run() {
            try {
                while (true) {
                    this.sharedBuffer.consume();
                    Thread.sleep(500);
                }
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
    }
}
class Producer implements Runnable {
    private SharedBuffer sharedBuffer;

    public Producer(SharedBuffer buffer) {
        this.sharedBuffer = buffer;
    }
    @Override
    public void run() {
        try {
            while (true) {
                this.sharedBuffer.produce();
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
public class ProduceAndConsume {
    public static void main(String[] args) {
        var sharedBuffer = new SharedBuffer();

        Thread t2 = new Thread(new Producer(sharedBuffer));
        Thread t1 = new Thread(new Consumer(sharedBuffer));



        t1.start();
        t2.start();
    }
}
