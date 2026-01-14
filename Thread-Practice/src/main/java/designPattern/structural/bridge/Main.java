package designPattern.structural.bridge;

import designPattern.structural.bridge.abstraction.Notification;
import designPattern.structural.bridge.abstraction.refined.PromotionNotification;
import designPattern.structural.bridge.implementor.EmailSender;

public class Main {
    public static void main(String[] args) {
        MessageSender messageSender = new EmailSender();
        Notification notification = new PromotionNotification(messageSender);

        notification.send();
    }
}
