package designPattern.structural.adapter;

public class VnPaySdk {
    public void makePayment(String money, String currency) {
        System.out.println("Pay VNPAY " + money + " " + currency);
    }
}
