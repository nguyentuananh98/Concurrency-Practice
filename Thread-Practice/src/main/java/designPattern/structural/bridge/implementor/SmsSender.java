package designPattern.structural.bridge.implementor;

import designPattern.structural.bridge.MessageSender;

public class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Send SMS: " + message);
    }
}
