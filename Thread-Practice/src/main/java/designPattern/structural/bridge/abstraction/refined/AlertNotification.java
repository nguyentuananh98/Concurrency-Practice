package designPattern.structural.bridge.abstraction.refined;

import designPattern.structural.bridge.MessageSender;
import designPattern.structural.bridge.abstraction.Notification;

public class AlertNotification extends Notification {
    public AlertNotification(MessageSender messageSender) {
        super(messageSender);
    }
    @Override
    public void send() {
        messageSender.sendMessage("ALERT message");
    }
}
