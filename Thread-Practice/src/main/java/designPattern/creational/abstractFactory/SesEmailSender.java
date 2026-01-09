package designPattern.creational.abstractFactory;

public class SesEmailSender implements EmailSender{
    @Override
    public void send(String to, String content) {
        System.out.println("Send EMAIL via AWS SES");
    }
}
