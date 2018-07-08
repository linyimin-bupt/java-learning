package com.linyimin.java.concurrency.lock.read.write.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    public static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    static Lock w = rwl.writeLock();
    static Lock r = rwl.readLock();

    public static Object get(String key){
        // 获取读锁
        r.lock();
        try{
            return map.get(key);
        }finally {
            r.unlock();
        }

    }

    public static Object put(String key, Object value){
        //获取写锁
        w.lock();
        try{
            return map.put(key, value);
        }finally {
            w.unlock();
        }
    }

    // 清空
    public static void clear(){
        // 获取写锁
        w.lock();
        try{
            map.clear();
        }finally {
            w.unlock();
        }
    }
}
