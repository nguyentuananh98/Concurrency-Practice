package concurrency;

class ObjectLocking {
    public synchronized void instanceMethod() {
        System.out.println(Thread.currentThread().getName() + " entered instanceMethod");

        try  {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " finished instanceMethod");
    }
}

class ClassLocking {
    public static synchronized void instanceMethod() {
        System.out.println(Thread.currentThread().getName() + " entered instanceMethod");

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " finished instanceMethod");
    }
}

public class App {

    public static void main(String[] args) {
        // ObjectLocking
        ObjectLocking obj1 = new ObjectLocking();
        ObjectLocking obj2 = new ObjectLocking();

        Runnable task1 = obj1::instanceMethod;
        Runnable task2 = obj2::instanceMethod;

        new Thread(task1, "First Thread").start();
        new Thread(task2, "Second Thread").start();
    }
}
