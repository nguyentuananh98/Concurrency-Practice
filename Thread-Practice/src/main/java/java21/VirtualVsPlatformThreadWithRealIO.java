package java21;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

public class VirtualVsPlatformThreadWithRealIO {
    public static final int THREAD_COUNT = 100_000;

    public static void main(String[] args) throws InterruptedException{
        System.out.println("\\n-- Virtual Threads Demo ---");
        runWithThreads(true);

    }
    private static void runWithThreads(boolean useVirtualThread) throws InterruptedException {
        Thread[] threads = new  Thread[THREAD_COUNT];

        CountDownLatch readyLatch = new CountDownLatch(THREAD_COUNT);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(THREAD_COUNT);

        Runnable task = () -> {
            try {
                readyLatch.countDown();
                startLatch.await(); // Đợi tín hiệu bắt đầu đồng loạt
                performHttpRequest();
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
        readyLatch.await(); // Chờ tín hiệu khi tất cả các thread đều sẵn sàng
        long start = System.currentTimeMillis();
        startLatch.countDown(); // Bắt đầu đồng loạt
        doneLatch.await(); // Chờ đến khi tất cả các task hoàn thành
        long end = System.currentTimeMillis();
        System.out.println((useVirtualThread ? "Virtual" : "Platform") +
                " threads total time: " + (end - start) + " ms");
    }
    private static void performHttpRequest() {
        try {
            System.out.println("Inside thread: " + Thread.currentThread());
            Thread.sleep(Duration.ofSeconds(5));
        }catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
