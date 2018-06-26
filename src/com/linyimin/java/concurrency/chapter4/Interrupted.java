package com.linyimin.java.concurrency.chapter4;

import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 * @Author: linyimin
 * @Description: 使用interrupt()方法只改变中断位的标志，并不能直接中断线程
 * @Date: Created in 上午11:50 18-6-26
 */

public class Interrupted {
    public static void main(String [] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(), "sleep");
        Thread busy = new Thread(new BusyRunner(), "busy");
        sleepThread.start();
        busy.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busy.interrupt();
        System.out.println("sleep interrupted is: " + sleepThread.isInterrupted());
        System.out.println("busy interrupted is: " + busy.isInterrupted());
    }

    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                //System.out.println("busy");
            }
        }
    }
}
