package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BankMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<BankAccount>  bankAccounts = IntStream.range(0,10)
                .mapToObj(i -> new BankAccount("acc" + i , 1000))
                .collect(Collectors.toList());


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Boolean>> results = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            BankAccount from =  bankAccounts.get(random.nextInt(bankAccounts.size()));
            BankAccount to =  bankAccounts.get(random.nextInt(bankAccounts.size()));
            int amount = random.nextInt(200);
            if (!from.equals(to)) {
                results.add(executorService.submit(new TransferTask(from, to, amount)));
            }
        }
        for (Future<Boolean> result : results) {
            result.get();
        }

        int total = bankAccounts.stream().mapToInt(BankAccount::getBalance).sum();
        System.out.println("Total money remaining in the system: " + total);
        executorService.shutdown();
    }
}
