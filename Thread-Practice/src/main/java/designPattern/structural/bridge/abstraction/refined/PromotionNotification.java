package designPattern.structural.bridge.abstraction.refined;

import designPattern.structural.bridge.MessageSender;
import designPattern.structural.bridge.abstraction.Notification;

public class PromotionNotification extends Notification {
    public PromotionNotification(MessageSender messageSender) {
        super(messageSender);
    }
    @Override
    public void send() {
        messageSender.sendMessage("PROMOTION message");
    }
}
