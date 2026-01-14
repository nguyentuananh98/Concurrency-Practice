package java21;

import java.util.concurrent.CountDownLatch;

public class VirtualVsPlatformThreadCPU {
    private static final int THREAD_COUNT = 2000;

    public static void main(String[] args) throws InterruptedException{
        System.out.println("\\n--- Virtual Thread Demo ---");
        runWithThreads(true);
        System.out.println("--- Platform Threads Demo ---");
        runWithThreads(false);
    }
    private static void runWithThreads(boolean useVirtualThread) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        CountDownLatch readyLatch = new CountDownLatch(THREAD_COUNT);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(THREAD_COUNT);

        Runnable task = () -> {
            try {
                readyLatch.countDown();
                startLatch.await();
                performCpuIntensiveTask();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                doneLatch.countDown();
            }
        };

        for (int i = 0; i < THREAD_COUNT; i ++) {
            threads[i] = useVirtualThread
                    ? Thread.ofVirtual().unstarted(task)
                    : new Thread(task);
        }
        for (Thread thread: threads) {
            thread.start();
        }

        readyLatch.await();
        long start = System.currentTimeMillis();
        startLatch.countDown();
        doneLatch.await();
        long end = System.currentTimeMillis();

        System.out.println((useVirtualThread ? "Virtual" : "Platform") +
                " threads total time: " + (end - start) + " ms");
    }
    private static void performCpuIntensiveTask () {
        long count =0;
        for (int i = 2; i < 100_000; i ++) {
            if (isPrime(i)) count ++;
        }
    }
    private static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i ++){
            if (n % i == 0)  return false;
        }
        return true;
    }
}
