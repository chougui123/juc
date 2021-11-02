package org.example.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo1 {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

        writeLock.lock();
        System.out.println("writeLock");

        readLock.lock();
        System.out.println("readLock");

        writeLock.unlock();

        readLock.unlock();
    }
}
