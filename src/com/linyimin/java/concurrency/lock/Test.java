package com.linyimin.java.concurrency.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午4:22 18-6-28
 */
public class Test {
    static Mutex lock = new Mutex();
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String [] args) throws InterruptedException {

        Thread thread1 = new Thread(new LockThread(), "thread1");
        Thread thread2 = new Thread(new LockThread(), "thread2");
        Thread thread3 = new Thread(new LockThread(), "thread3");
        Thread thread4 = new Thread(new LockThread(), "thread4");
        Thread thread5 = new Thread(new LockThread(), "thread5");
        Thread thread6 = new Thread(new LockThread(), "thread6");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        countDownLatch.countDown();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(lock.getQueueLength());


    }

    static class LockThread implements Runnable{
        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                lock.lock();
                System.out.println(Thread.currentThread().getName() + " 获取lock");
        }
    }
}
