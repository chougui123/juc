package org.example.sync;

import java.util.concurrent.TimeUnit;

public class DeadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        new Thread(()->{
            synchronized (o1){
                System.out.println("当前线程："+Thread.currentThread().getName()+"锁住了o1,试图获取锁o2");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+"获取锁o2");
                }
            }
        },"AA").start();
        new Thread(()->{
            synchronized (o2){
                System.out.println("当前线程："+Thread.currentThread().getName()+"锁住了o2,试图获取锁o1");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+"获取锁o1");
                }
            }
        },"BB").start();
    }
}
