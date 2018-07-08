package com.linyimin.java.concurrency.lock.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ConditionUseCase {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args){
        Thread thread1 = new Thread(new Test(), "A");
        Thread thread2 = new Thread(new Test(), "B");
        thread1.start();
        thread2.start();
    }

    static class Test implements Runnable{
        Lock lock1 = lock;
        static Condition condition = lock.newCondition();
        public static void conditionAwait() {
            lock.lock();
            try {
                System.out.println("被阻塞了");
                condition.await();
                // 睡眠两秒
                TimeUnit.SECONDS.sleep(2);
                System.out.println("被释放了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("释放锁");
            }
        }

        public static void conditionSignal(){
            lock.lock();
            try{
                condition.signal();
            }finally {
                lock.unlock();
            }
        }
        @Override
        public void run() { 
            if(Thread.currentThread().getName().equals("A")){
                conditionAwait();
            }else{
                conditionSignal();
            }

        }
    }
}