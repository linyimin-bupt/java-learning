package com.linyimin.java.concurrency.chapter4.connection;

import java.util.LinkedList;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午10:26 18-6-26
 */
public class ConnectionPool {
    private LinkedList<String> pool = new LinkedList<>();

    public ConnectionPool(int initialSize){
        if(initialSize > 0){
            for(int i = 0; i < initialSize; i++){
                pool.addLast(String.valueOf(i));
            }
        }
    }

    public void releaseConnection(String connection){
        if(connection != null){
            synchronized (pool){
                // 释放连接之后，需要通知其他消费者，连接池中有可用连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public String fetchConnection(long millis) throws InterruptedException {
        synchronized (pool){
            /**
             * 使用超时模式，在指定时间内如果没有获取到连接，则直接返回null
             */
            long future = System.currentTimeMillis() + millis;
            long remainMills = millis;
            while (pool.isEmpty() && remainMills > 0){
                pool.wait(millis);
                remainMills = future - System.currentTimeMillis();
            }
            if(!pool.isEmpty()){
                return pool.removeFirst();
            }
            return null;
        }
    }
}
