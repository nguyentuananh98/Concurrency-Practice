package designPattern.creational.abstractFactory;

public class Main {
    public static void main(String[] args) {
        AbstractExample abstractExample = new AbstractExample(new SmtpEmailSender(), new SnsSmsSender());
        abstractExample.notifyUser();
    }
}
