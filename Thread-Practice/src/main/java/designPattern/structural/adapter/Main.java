package designPattern.structural.adapter;

public class Main {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new VnPayAdapter(new VnPaySdk());

        paymentGateway.pay(1000000);
    }
}
