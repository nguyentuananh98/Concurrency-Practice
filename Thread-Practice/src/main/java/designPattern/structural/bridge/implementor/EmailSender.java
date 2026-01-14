package designPattern.structural.bridge.implementor;

import designPattern.structural.bridge.MessageSender;

public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Send EMAIL: " + message);
    }
}
