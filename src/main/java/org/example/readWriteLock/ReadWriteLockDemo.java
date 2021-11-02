package org.example.readWriteLock;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
   private volatile Map<String,Object> map= new HashMap<>();
   private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    public void put(String key,String value){
       try {
           readWriteLock.writeLock().lock();
           System.out.println(Thread.currentThread().getName()+"正在进行写操作");
           TimeUnit.MICROSECONDS.sleep(300);
           map.put(key,value);
           System.out.println(Thread.currentThread().getName()+"写完了");
       } catch (InterruptedException e) {
           e.printStackTrace();
       }finally {
           readWriteLock.writeLock().unlock();
       }
   }

   public Object get(String key){
       Object result=null;
       try {
           readWriteLock.readLock().lock();
           System.out.println(Thread.currentThread().getName()+"正在进行读操作");
           TimeUnit.MICROSECONDS.sleep(300);
           result=map.get(key);
           System.out.println(Thread.currentThread().getName()+"读完了");

       } catch (InterruptedException e) {
           e.printStackTrace();
       }finally {
           readWriteLock.readLock().unlock();
       }

       return result;
   }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 1; i <= 5 ; i++) {
            final int num=i;
            new Thread(()->{
                myCache.put(num+"",num+"");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5 ; i++) {
            final int num=i;
            new Thread(()->{
                myCache.get(num+"");
            },String.valueOf(i)).start();
        }
    }
}
