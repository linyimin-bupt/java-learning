package com.linyimin.java.concurrency.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午1:49 18-6-26
 */
public class Shutdown {
    /**
     * 使用java中断机制完成线程的中断
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        Thread countThread = new Thread(runner, "countThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

    }

    private static class Runner implements Runnable{

        private int i = 0;
        private volatile boolean on = true;
        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i = " + i);
        }
    }
}
