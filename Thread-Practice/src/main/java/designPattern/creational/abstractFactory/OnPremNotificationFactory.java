package designPattern.creational.abstractFactory;

public class OnPremNotificationFactory implements NotificationFactory{
    @Override
    public EmailSender createEmailSender() {
        return new SmtpEmailSender();
    }

    @Override
    public SmsSender createSmsSender() {
        return new KafkaSmsSender();
    }
}
