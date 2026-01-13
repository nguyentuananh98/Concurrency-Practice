package designPattern.creational.abstractFactory;

public class AbstractExample {
    private final EmailSender emailSender;
    private final SmsSender smsSender;

    public AbstractExample(EmailSender emailSender, SmsSender smsSender) {
        this.emailSender = emailSender;
        this.smsSender = smsSender;
    }

    public void notifyUser() {
        emailSender.send("nguyentuananh98software@gmail.com", "hello");
        smsSender.send("anhnt@aggregatoricapaci.com", "hi");
    }
}
