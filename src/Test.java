import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午4:42 18-7-1
 */
public class Test {
    public static Thread thread;
    public static void main(String [] args) throws InterruptedException {
//       Thread park = new Thread(new Park(), "park");
//       Thread unpark = new Thread(new Unpark(), "unpark");
//       park.start();
//       unpark.start();
        int c = 2;
        int init = 5;

    }

    static class Park implements Runnable{

        @Override
        public void run() {
            thread = Thread.currentThread();
            LockSupport.park();
            System.out.println("阻塞结束");
        }
    }
    
    static class Unpark implements Runnable{
        @Override
        public void run() {
            System.out.println("Park阻塞5秒");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(thread);
        }
    }
}
