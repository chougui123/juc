package org.example.sync;


import javax.sound.midi.SoundbankResource;

class Ticket{
    private int number=30;

    public synchronized void sale(){
        if(number>0){
            number--;
            System.out.println(Thread.currentThread().getName()+"卖出了一张票，"+"剩余"+number);
        }
    }
}
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40 ; i++) {
                    ticket.sale();
                }

            }
        },"AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40 ; i++) {
                    ticket.sale();
                }
            }
        },"BB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40 ; i++) {
                    ticket.sale();
                }
            }
        },"CC").start();
    }

}
