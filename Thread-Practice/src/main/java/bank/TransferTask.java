package bank;

import java.util.concurrent.Callable;

public class TransferTask implements Callable<Boolean> {

    private final BankAccount from;
    private final BankAccount to;
    private final int amount;


    public TransferTask(BankAccount from, BankAccount to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }


    @Override
    public Boolean call() throws Exception {
        return from.transferTo(to, amount);
    }
}
