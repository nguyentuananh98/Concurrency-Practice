package designPattern.creational.factory;

public class MomoPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Mo mo payment");
    }
}
