package com.linyimin.java.concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 9:44 2018/6/25
 */
public class SyncThread implements Runnable{
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.startsWith("A")) {
            async();
        } else if (threadName.startsWith("B")) {
            sync1();
        } else if (threadName.startsWith("C")) {
            sync2();
        }

    }

    /**
     * 异步方法
     */
    private void async() {
        try {
            System.out.println(Thread.currentThread().getName() + "_Async_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "_Async_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法中有 synchronized(this|object) {} 同步代码块
     */
    private void sync1() {
        System.out.println(Thread.currentThread().getName() + "_Sync1: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + "_Sync1_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "_Sync1_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * synchronized 修饰非静态方法
     */
    private synchronized void sync2() {
        System.out.println(Thread.currentThread().getName() + "_Sync2: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName() + "_Sync2_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "_Sync2_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String [] args){
        SyncThread syncThread = new SyncThread();
        /**
         * A 类线程访问方法中没有同步代码块，A 类线程是异步的，
         * 所以有线程访问对象的同步代码块时，另外的线程可以访问该对象的非同步代码块
         */

        /**
         * A_thread1_Async_Start: 14:44:20
         * A_thread2_Async_Start: 14:44:20
         * A_thread1_Async_End: 14:44:22
         * A_thread2_Async_End: 14:44:22
         */
//        Thread A_thread1 = new Thread(syncThread, "A_thread1");
//        Thread A_thread2 = new Thread(syncThread, "A_thread_2");
//        A_thread1.start();
//        A_thread2.start();

        /**
         * B 类线程访问的方法中有同步代码块，
         * B 类线程是同步的，一个线程在访问对象的同步代码块，
         * 另一个访问对象的同步代码块的线程会被阻塞：
         * synchronized(this|object) {} 代码块 {} 之外的代码依然是异步的：
         */

        /**
         * B_thread1_Sync1: 10:02:29
         * B_thread2_Sync1: 10:02:29
         * B_thread1_Sync1_Start: 10:02:29
         * B_thread1_Sync1_End: 10:02:31
         * B_thread2_Sync1_Start: 10:02:31
         * B_thread2_Sync1_End: 10:02:33
         */
        Thread B_thread1 = new Thread(syncThread, "B_thread1");
        Thread B_thread2 = new Thread(syncThread, "B_thread2");
        B_thread1.start();
        B_thread2.start();

        /**
         * C 类线程访问的是 synchronized 修饰非静态方法，
         * C 类线程是同步的，一个线程在访问对象的同步代方法，
         * 另一个访问对象同步方法的线程会被阻塞：
         */
        /**
         * C_thread1_Sync2: 10:06:26
         * C_thread1_Sync2_Start: 10:06:26
         * C_thread1_Sync2_End: 10:06:28
         * C_thread2_Sync2: 10:06:28
         * C_thread2_Sync2_Start: 10:06:28
         * C_thread2_Sync2_End: 10:06:30
         */
        Thread C_thread1 = new Thread(syncThread, "C_thread1");
        Thread C_thread2 = new Thread(syncThread, "C_thread2");
        C_thread1.start();
        C_thread2.start();

        /**
         * 由结果可知 B 类和 C 类线程顺序执行，
         * 类中 synchronized(this|object) {} 代码块和
         * synchronized 修饰非静态方法获取的锁是同一个锁，
         * 即该类的对象的对象锁。
         */
        /**
         * C_thread1_Sync2: 10:11:14
         * B_thread1_Sync1: 10:11:14
         * B_thread2_Sync1: 10:11:14
         * C_thread1_Sync2_Start: 10:11:14
         * C_thread1_Sync2_End: 10:11:16
         * B_thread2_Sync1_Start: 10:11:16
         * B_thread2_Sync1_End: 10:11:18
         * B_thread1_Sync1_Start: 10:11:18
         * B_thread1_Sync1_End: 10:11:20
         * C_thread2_Sync2: 10:11:20
         * C_thread2_Sync2_Start: 10:11:20
         * C_thread2_Sync2_End: 10:11:22
         */


        /**
         * 两个线程访问不同对象的 synchronized(类.class) {} 代码块或
         * synchronized 修饰静态方法还是同步的，
         * 类中 synchronized(类.class) {} 代码块和
         * synchronized 修饰静态方法获取的锁是类锁。
         * 对于同一个类的不同对象的类锁是同一个。
         */

        /**
         * 对象锁和类锁是独立的，互不干扰
         */

    }
}
