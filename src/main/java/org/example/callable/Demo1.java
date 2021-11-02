package org.example.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread01 implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread02 implements Callable{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" come in callable");
        return 200;
    }
}
public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new MyThread01(),"AA").start();

        FutureTask<Integer> futureTask01 = new FutureTask<Integer>(new MyThread02());

        FutureTask<Integer> futureTask02 = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName()+" come in callable");
            return 1024;
        });
        new Thread(futureTask02,"BB").start();
        new Thread(futureTask01,"CC").start();
     /*   while (!futureTask02.isDone()){
            System.out.println("wait.....");
        }*/
        System.out.println(futureTask02.get());
        System.out.println(futureTask01.get());

    }
}
