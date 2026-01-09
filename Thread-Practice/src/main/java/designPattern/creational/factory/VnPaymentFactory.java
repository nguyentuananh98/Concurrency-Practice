package designPattern.creational.factory;

public class VnPaymentFactory extends PaymentFactory{
    @Override
    protected Payment createPayment() {
        return new VNPayment();
    }
}
