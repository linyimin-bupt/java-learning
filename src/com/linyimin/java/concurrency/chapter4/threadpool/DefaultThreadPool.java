package com.linyimin.java.concurrency.chapter4.threadpool;

import sun.plugin.navig.motif.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job>{

    // 线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;

    // 线程池的默认的数量
    private static final int DEFAULT_WORKER_NUMBER = 5;
    // 线程池最小的数量
    private static final int MIN_WORKER_NUMBER = 1;

    // 工作列表
    private final LinkedList<Job> jobs = new LinkedList<>();

    // 工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());

    // 工作者线程数
    private int workerNum = DEFAULT_WORKER_NUMBER;

    private AtomicInteger threadNum = new AtomicInteger();

    public DefaultThreadPool(){
        initializeWorkers(workerNum);
    }

    public DefaultThreadPool(int num){
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBER ? MIN_WORKER_NUMBER : num;
        initializeWorker(workerNum);
    }
    @Override
    public void execute(Job job) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void addWorkers(int num) {

    }

    @Override
    public void removeWorker(int num) {

    }

    @Override
    public int getJobSize() {
        return 0;
    }


    class Worker implements Runnable{
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running){
                Job job = null;
                synchronized (jobs){
                    if(jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }
}
