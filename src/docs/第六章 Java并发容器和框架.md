## 第六章 Java并发容器和框架

### ConcurrentHashMap的实现原理和使用

原因:

- HashMap属于非线程安全,在多线程环境下,使用HashMap进行put操作会引起死循环
- HashTable属于线程安全,但是效率低下.HashTable使用synchronized来保证线程安全,当一个线程访问HashTable的同步方法,其他访问HashTable的线程会被阻塞.
- ConcurrentHashMap使用锁分段技术提高并发访问效率



锁分段技术:

将数据分成一段段的存储,然后给每一段数据配一把锁,当一个线程占用一把锁访问其中的一个数据段的时候,其他段的数据也能被其他线程访问.



