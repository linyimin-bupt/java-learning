## 第六章 Java并发容器和框架

### ConcurrentHashMap的实现原理和使用

原因:

- HashMap属于非线程安全,在多线程环境下,使用HashMap进行put操作会引起死循环
- HashTable属于线程安全,但是效率低下.HashTable使用synchronized来保证线程安全,当一个线程访问HashTable的同步方法,其他访问HashTable的线程会被阻塞.
- ConcurrentHashMap使用锁分段技术提高并发访问效率



锁分段技术:

将数据分成一段段的存储,然后给每一段数据配一把锁,当一个线程占用一把锁访问其中的一个数据段的时候,其他段的数据也能被其他线程访问.



ConcurrentHashMap包含一个segment数组，每个segment包含一个HashEntry数组，HashEntry数组的元素是一个链表结构。



ConcurrentLinkedQueue：使用非阻塞方法(循环CAS的方式)实现的线程安全队列

阻塞队列： 	

- 支持阻塞的插入方法：当队列为满时，队列会阻塞插入元素的线程，知道队列不满
- 支持阻塞的移除方法：当队列为空时，获取元素的线程会等待队列变为非空

Java中的阻塞队列：

- ArrayBlockingQueue：一个由数组结构组成的有界阻塞队列。
- LinkedBlockingQueue:一个由链表结构组成的有界阻塞队列。
- LinkedTransferQueue:一个由链表结构组成的无界阻塞队列。
- LinkedBlockingDeque:一个由链表结构组成的双向阻塞队列。
- PriorityBlockingQueue:一个支持优先级排序的无界阻塞队列。
- DelayQueue:一个使用优先级队列实现的无界阻塞队列。
- SynchronousQueue:一个不存储元素的阻塞队列。
  - 每一个put操作必须等待一个take操作,否则不能继续添加元素。