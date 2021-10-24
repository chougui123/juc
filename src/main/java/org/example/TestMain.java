package org.example;

public class TestMain {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println(Thread.currentThread().getName()+"over");
    }
}
