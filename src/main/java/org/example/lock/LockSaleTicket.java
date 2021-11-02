package org.example.lock;

import javax.sound.midi.SoundbankResource;
import java.util.concurrent.locks.ReentrantLock;

class LockTicket{
    private int number =30;
    private final  ReentrantLock reentrantLock = new ReentrantLock(true);
    public void sale(){
        reentrantLock.lock();
        try {
            if(number>0){
                number--;
                System.out.println("线程："+Thread.currentThread().getName()+"卖出一张票，剩余："+number);
            }

        }finally {
            reentrantLock.unlock();
        }
    }
}
public class LockSaleTicket {

    public static void main(String[] args) {
        LockTicket lockTicket = new LockTicket();
        new Thread(() ->{
            for (int i = 0; i <40 ; i++) {
                lockTicket.sale();
            }
        },"AA").start();

        new Thread(() ->{
            for (int i = 0; i <40 ; i++) {
                lockTicket.sale();
            }
        },"BB").start();

        new Thread(() ->{
            for (int i = 0; i <40 ; i++) {
                lockTicket.sale();
            }
        },"CC").start();
    }
}
