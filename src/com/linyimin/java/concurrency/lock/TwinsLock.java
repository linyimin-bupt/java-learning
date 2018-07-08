package com.linyimin.java.concurrency.lock;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午11:24 18-7-2
 */
public class TwinsLock implements Lock {

    // 指定同时只有两个线程工作
    public Sync sync = new Sync(2);

    private final class Sync extends AbstractQueuedSynchronizer {
        public Sync(int threadNum){
            if(threadNum <= 0){
                throw new IllegalArgumentException("threadNum must large than 0");
            }
                setState(threadNum);
        }
        @Override
        protected int tryAcquireShared(int arg) {
            while (true){
                int current = getState();
                int remains = current - arg;
                if(remains < 0 || compareAndSetState(current, remains)){
                    return remains;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            while (true){
                int current = getState();
                int remains = current + arg;
                if(compareAndSetState(current, remains)){
                    return true;
                }
            }
        }
    }
    @Override
    public void lock() {
        sync.acquireShared(1);

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        throw new NotImplementedException();
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
