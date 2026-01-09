package designPattern.creational.factory;

public class VNPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Pay with VN Payment");
    }
}
