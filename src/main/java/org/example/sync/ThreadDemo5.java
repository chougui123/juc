package org.example.sync;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo5 {

    public synchronized void add(){
        add();
    }

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            try {
              lock.lock();
                System.out.println(Thread.currentThread().getName()+"外层");

                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"内层");
                }finally {
                    lock.unlock();
                }
            }finally {
                lock.unlock();
            }
        },"t1").start();

        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName());
            lock.unlock();
        }).start();
        /*ThreadDemo5 threadDemo5 = new ThreadDemo5();
        threadDemo5.add();*/
       /* Object o = new Object();
        new Thread(()->{
            synchronized (o){
                System.out.println(Thread.currentThread().getName()+"外层");
                synchronized (o){
                    System.out.println(Thread.currentThread().getName()+"中层");
                    synchronized (o){
                        System.out.println(Thread.currentThread().getName()+"内层");
                    }
                }
            }
        }).start();*/
    }
}
