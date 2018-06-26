package com.linyimin.java.concurrency.chapter4.connection;

import com.sun.jndi.ldap.Connection;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午10:40 18-6-26
 */
public class ConnectionPoolTest {
    public static ConnectionPool pool = new ConnectionPool(10);
    // 保证所有的ConnectionRunner能够同时开始
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;
    public static void main(String [] args) throws InterruptedException {
        int threadCount = 50;
        // 全部线程执行结束之后在接着执行main线程剩下的内容
        end = new CountDownLatch(threadCount);
        // 每个线程尝试获取的连接数
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for(int i = 0; i < threadCount; i++){
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread_" + i);
            thread.start();
        }
        // 开始同时执行所有的线程
        start.countDown();
        // 等待所有线程执行结束
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got );
        System.out.println("notGot connection: " + notGot);
    }

    private static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(count > 0){
                try {
                    String connection = pool.fetchConnection(1000);
                    if(connection != null){
                        try{
                            TimeUnit.MILLISECONDS.sleep(1000);
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else{
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            end.countDown();

        }
    }
}
