## 第九章 Java中的线程池

好处：

- 降低资源消耗
- 提高相应速度
- 提高线程的可管理性

### 线程池的使用

1. 线程池的创建

   ```java
   new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
   milliseconds,runnableTaskQueue, handler);
   ```

2. 向线程池提交任务

   - execute(Runnable task): 提交不需要返回值的任务
   - submit(Runnable task): 提交需要有返回值的任务，返回一个future类型对象，通过get方法以阻塞的方式获取返回值

3. 关闭线程池

   ```java
   shutdown()
   shutdownNow() // 任务不一定要执行完
   ```

4. 合理配置线程池

   配置线程池需要考虑的角度：

   - 性质：CPU密集，IO密集，混合型

     CPU密集型任务应配置尽可能小的线程,如配置N cpu +1个线程的线程池

     IO密集型任务线程并不是一直在执行任务,则应配置尽可能多的线程,如2*N cpu 。

   - 优先级： 高，中，低

     优先级不同的任务可以使用优先级队列PriorityBlockingQueue来处理。它可以让优先级高的任务先执行。

   - 依赖性： 室是否依赖其他系统

     依赖数据库连接池的任务,因为线程提交SQL后需要等待数据库返回结果,等待的时间越长,则CPU空闲时间就越长,那么线程数应该设置得越大,这样才能更好地利用CPU。

   **建议使用有界队列。**有界队列能增加系统的稳定性和预警能力

5. 线程池的监控

   - taskCount:线程池需要执行的任务数量。
   - completedTaskCount:线程池在运行过程中已完成的任务数量,小于或等于taskCount。
   - largestPoolSize:线程池里曾经创建过的最大线程数量。通过这个数据可以知道线程池是否曾经满过。如该数值等于线程池的最大大小,则表示线程池曾经满过。
   - getPoolSize:线程池的线程数量。如果线程池不销毁的话,线程池里的线程不会自动销毁,所以这个大小只增不减。
   - getActiveCount:获取活动的线程数。