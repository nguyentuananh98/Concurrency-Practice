package designPattern.creational.abstractFactory;

public class Main {
    public static void main(String[] args) {
        AbstractExample sendSmtpAndSns = new AbstractExample(new SmtpEmailSender(), new KafkaSmsSender());
        AbstractExample sendSesAndKafKaSms = new AbstractExample(new SesEmailSender(), new SnsSmsSender());
        sendSmtpAndSns.notifyUser();
        sendSesAndKafKaSms.notifyUser();
    }
}
