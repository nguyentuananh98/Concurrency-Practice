package designPattern.creational.factory;

public class FactoryExample {
    public static void main(String[] args) {
        PaymentFactory paymentFactory = new VnPaymentFactory();
        paymentFactory.processPayment();
    }
}
