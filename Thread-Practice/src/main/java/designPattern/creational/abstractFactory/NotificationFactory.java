package designPattern.creational.abstractFactory;

public interface NotificationFactory {
    EmailSender createEmailSender();
    SmsSender createSmsSender();
}
