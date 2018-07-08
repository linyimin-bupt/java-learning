package com.linyimin.java.concurrency.lock.read.write.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock w = rwl.writeLock();
    static Lock r = rwl.readLock();
    public static void main(String[] args){
        w.lock();
        System.out.println("获取写锁");
        r.lock();
        System.out.println("获取读锁");
        w.unlock();
        r.unlock();
        System.out.println("释放相关锁");
    }
}
