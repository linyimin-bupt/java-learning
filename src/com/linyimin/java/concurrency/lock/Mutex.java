package com.linyimin.java.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午3:45 18-6-28
 */
public class Mutex implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer {

        // 当状态为0的时候获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 释放锁，并将状态设为0
        @Override
        protected boolean tryRelease(int arg) {
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 是否处于被独有占用状态
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // 返回一个Condition。每个condition都包含一个condition状态
        Condition newCondition(){
            return new ConditionObject();
        }
    }

    // 将操作代理到Sync上
    private final Sync sync = new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);

    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }

    public int getQueueLength(){
        return sync.getQueueLength();
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
