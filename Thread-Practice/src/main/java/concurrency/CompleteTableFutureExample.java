package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteTableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. create 1 list CompletableFuture run a task asynchronous
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello from a background task!";
        });
        // 2. Sequence of actions to process result
        future.thenAccept(result -> {
            System.out.println("results obtained: " + result);
        });
        // 3. The main of task is not blocked
        System.out.println("The main of task is continuing...");
        // 4. (Optional) Wait the result if you need, use get() will be blocked
        // String finalResult = future.get();
        // System.out.println("The final result (after waiting): " + finalResult);

        // 5. Handle error (if the process have error)
        future.exceptionally(ex -> {
            System.out.println("Have error: " + ex.getMessage());
            return "Default value";
        });

        // Keep the program running long enough to see the asynchronous results.
        Thread.sleep(3000);
    }
}
