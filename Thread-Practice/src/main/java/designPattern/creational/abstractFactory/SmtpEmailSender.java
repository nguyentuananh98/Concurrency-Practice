package designPattern.creational.abstractFactory;

public class SmtpEmailSender implements EmailSender{
    @Override
    public void send(String to, String content) {
        System.out.println("Send EMAIL via SMTP");
    }
}
