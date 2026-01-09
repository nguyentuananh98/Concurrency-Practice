package designPattern.creational.factory;

public class MomoPaymentFactory extends PaymentFactory{
    @Override
    protected Payment createPayment() {
        return new MomoPayment();
    }
}
