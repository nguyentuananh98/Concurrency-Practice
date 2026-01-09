package designPattern.creational.factory;

public abstract class PaymentFactory {

    // Factory Method
    protected abstract Payment createPayment();

    // Business Logic use Product
    public void processPayment() {
        Payment payment = createPayment();
        payment.pay();
    }
}
