package org.example.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"voidCompletableFuture1");
        });
        voidCompletableFuture1.get();

        CompletableFuture<Integer> voidCompletableFuture2=CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"voidCompletableFuture2");
            int i=1/0;
            return 1024;
        });
        voidCompletableFuture2.whenComplete((t,u)->{
            System.out.println("--t="+t);
            System.out.println("--u="+u);
        }).get();
    }
}
