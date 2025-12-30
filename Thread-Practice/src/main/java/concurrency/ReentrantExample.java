package concurrency;

public class ReentrantExample {
    public synchronized void outerMethod() {
        System.out.println("Entered outerMethod");
        innerMethod();
        System.out.println("Exiting outerMethod");
    }
    public synchronized void innerMethod() {
        System.out.println("Entered innerMethod");
        // Do something
        System.out.println("Exiting innerMethod");
    }

    public static void main(String[] args) {
        ReentrantExample obj = new ReentrantExample();

        Thread thread = new Thread(obj::outerMethod);

        thread.start();
    }
}
