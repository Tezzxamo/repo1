package thread1test2example;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author y
 */
public class LockFairTest implements Runnable{
    /**
     * 创建公平锁
     */
    private static ReentrantLock lock=new ReentrantLock(true);

    @Override
    public void run() {
        /**
         * 因为i=12，线程数为3，所以每个线程都会输出12次，一共就会输出36次
         * 而且输出都是按照顺序，即一开始三个线程排好的队就是之后的队伍，此后都按照现在的顺序
         * thread.start()方法不会影响线程的顺序，可以说只有第一次排序是竞争性的。
         */
        int j=12;
        for (int i = 0; i < j; i++) {
            lock.lock();
            try {
                //输出的时候表示为线程交替输出
                //代表着依次获得，按照顺序
                //即先来先得
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        LockFairTest lft=new LockFairTest();
        Thread th1=new Thread(lft);
        Thread th2=new Thread(lft);
        Thread th3=new Thread(lft);

        th1.start();
        th2.start();
        th3.start();
    }
}