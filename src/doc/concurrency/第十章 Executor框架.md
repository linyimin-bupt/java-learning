##第十章 Executor框架

Java的线程既是工作单元也是执行机制。从JDK1.5开始，便将工作单元与执行机制分离。工作单元包括Runnable和Callable，而执行机制有Executor框架提供。

### Executor框架的良机调度模型

在上层，javan多线程程序将应用分解成若干个任务，然后使用用户级的调度器(	Executor框架)将这些任务映射为数量固定的线程，在底层，操作系统内核将这些线程映射到硬件处理器上。



### Executor框架包含主要类和接口

- Executor接口

  Executor框架的基础,将任务的提交与任务的执行分离开

- ThreadPoolExecutor：线程池的核心实现类,执行被提交的任务

  通常使用工厂类Executors来创建，Executors可以创建3种类型的ThreadPoolExecutor：

  - SingleThreadExecutor

    适用于需要保证顺序地执行各个任务;并且在任意时间点,不会有多个线程是活动的应用场景。

  - FixedThreadPool

    适用于为了满足资源管理的需求,而需要限制当前线程数量的应用场景,它适用于负载比较重的服务器。

  - CachedThreadPool

    是大小无界的线程池,适用于执行很多的短期异步任务的小程序,或者是负载较轻的服务器。

- ScheduledThreadPoolExecutor: 线程池的实现类

  在给定的延迟后运行命令,或者定期执行命令

- Future接口：异步计算结果

- FutureTask： Future接口的实现类

- Runnable和Callable接口： 被执行任务需要实现的接口

  其实现类可以被ThreadPoolExecutor或ScheduledThreadPoolExecutor执行

