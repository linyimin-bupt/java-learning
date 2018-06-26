package com.linyimin.java.concurrency.chapter4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午2:47 18-6-26
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread wait = new Thread(new Wait(), "wait");
        wait.start();
        TimeUnit.SECONDS.sleep(1);

        Thread notify = new Thread(new Notify(), "notify");
        notify.start();
    }

    static class Wait implements Runnable{

        @Override
        public void run() {
            synchronized(lock){
                while (flag){
                    System.out.println(Thread.currentThread() + " flag is true, wait @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {
            // 加锁,拥有lock的Monitor
            synchronized (lock) {
                // 获取lock的锁,然后进行通知,通知时不会释放lock的锁,
                // 直到当前线程释放了lock后,WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
