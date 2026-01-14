package designPattern.structural.bridge.abstraction;

import designPattern.structural.bridge.MessageSender;

public abstract class Notification {
    protected MessageSender messageSender;

    protected Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract void send();
}
