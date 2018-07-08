package com.linyimin.java.concurrency.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午11:57 18-7-2
 */
public class TwinsTest {
    static TwinsLock lock = new TwinsLock();
    public static void main(String [] args) throws InterruptedException {
        for(int i = 0; i < 10; i++){
            Thread work = new Thread(new Work(), String.valueOf(i));
            work.start();
        }

        for(int i = 0; i < 10; i++){
            TimeUnit.SECONDS.sleep(1);
            System.out.println();
        }
    }

    private static class Work implements Runnable{

        @Override
        public void run() {
            while (true){
                // 获取同步状态
                lock.lock();
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
