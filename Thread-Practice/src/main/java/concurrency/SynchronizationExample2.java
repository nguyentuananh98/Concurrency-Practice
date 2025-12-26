package concurrency;

public class SynchronizationExample2 {
    private static int counter1 = 0;
    private static int counter2 = 0;

    private static synchronized void incrementCounter() {
        counter1++;
    }
    public static synchronized void incrementCounter2() {
        counter2++;
    }

    public static void main(String[] args) {
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
