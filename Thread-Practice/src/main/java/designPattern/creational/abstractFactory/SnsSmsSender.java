package designPattern.creational.abstractFactory;

public class SnsSmsSender implements SmsSender{
    @Override
    public void send(String to, String content) {
        System.out.println("Send SMS via AWS SNS");
    }
}
