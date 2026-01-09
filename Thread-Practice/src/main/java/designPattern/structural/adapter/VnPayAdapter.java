package designPattern.structural.adapter;

public class VnPayAdapter implements PaymentGateway{
    private final VnPaySdk vnPaySdk;

    public VnPayAdapter(VnPaySdk vnPaySdk) {
        this.vnPaySdk = vnPaySdk;
    }

    @Override
    public void pay(long amount) {
        // convert data
        String money = String.valueOf(amount);
        vnPaySdk.makePayment(money, "VND");
    }
}
