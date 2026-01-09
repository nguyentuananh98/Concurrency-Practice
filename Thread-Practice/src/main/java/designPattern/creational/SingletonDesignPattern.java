package designPattern.creational;

public class SingletonDesignPattern {
    private SingletonDesignPattern() {

    }

    private static class Holder {
        private static final SingletonDesignPattern INSTANCE = new SingletonDesignPattern();
    }

    public static  SingletonDesignPattern getInstance() {
        return Holder.INSTANCE;
    }
}
