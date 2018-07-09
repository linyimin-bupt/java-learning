##第八章 Java中的并发工具类

- CountDownLatch

  允许一个或多个线程等待其他线程完成操作。

- CyclicBarrier

  - 可循环使用(Cyclic)的屏障(Barrier)，一组线程到达一个屏障(也可以叫同步点)时被阻塞,直到最后一个线程到达屏障时,屏障才会开门,所有被屏障拦截的线程才会继续运行。构造函数的参数表示有几个屏障，即需要调用多少次await函数。
  - 高级特性：构造函数CyclicBarrier(int parties,Runnable barrier-Action)，表示线程到达屏障时，优先执行barrier-Action

- Semaphore

  控制同时访问特定资源的线程数量,它通过协调各个线程,以保证合理的使用公共资源。(做流量控制)

- Exchanger

  - 用于线程间协作的工具类,进行线程间的数据交换。