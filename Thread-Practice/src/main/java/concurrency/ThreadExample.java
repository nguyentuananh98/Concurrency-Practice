package concurrency;

public class ThreadExample {
    private int counter1 = 0;
    private int counter2 = 0;

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void incrementCounter() {

        // Object-level locking
        synchronized (this) {
            counter1++;
        }
        // execute operations after
    }

    private void incrementCounter2() {
        synchronized (lock2) {
            counter2++;
        }
    }

    public void execute() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementCounter();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementCounter2();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter1);
        System.out.println(counter2);
    }
}
