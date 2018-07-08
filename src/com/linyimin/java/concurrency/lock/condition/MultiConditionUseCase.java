package com.linyimin.java.concurrency.lock.condition;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiConditionUseCase {
    public static void main(String [] args){
        A a = new A();
        B b = new B();
        new Thread(a, "a").start();
        new Thread(b, "b").start();
    }
}

class A implements Runnable{

    @Override
    public void run() {
        Info.run1();
    }
}

class B implements Runnable{
    @Override
    public void run() {
        Info.run2();
    }
}

class Info{
    private static Lock l = new ReentrantLock();
    private static Condition c1 = l.newCondition();
    private static Condition c2 = l.newCondition();

    public static void run1(){
        l.lock();
        try{
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + "正在运行");
                c2.signal();
                try {
                    c1.await();
                    System.out.println(Thread.currentThread().getName() + "运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            l.unlock();
            System.out.println(Thread.currentThread().getName() + "运行结束释放锁");
        }

    }
    public static void run2(){
        l.lock();
        try{
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + "正在运行");
                c1.signal();
                try {
                    c2.await();
                    System.out.println(Thread.currentThread().getName() + "运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            l.unlock();
            System.out.println(Thread.currentThread().getName() + "运行结束释放锁");
        }

    }
    public static void run3(){
        l.lock();
    }
 }
