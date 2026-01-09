package designPattern.creational.abstractFactory;

public class AwsNotificationFactory implements NotificationFactory{
    @Override
    public EmailSender createEmailSender() {
        return new SesEmailSender();
    }

    @Override
    public SmsSender createSmsSender() {
        return new SnsSmsSender();
    }
}
