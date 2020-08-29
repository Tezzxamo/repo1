package thread1test2example;

/**
 * @author Tethamo_zzx
 * 创建Tread实例,实现Runnable实例
 */
public class AccountingSync implements Runnable {
    /**
     * i是共享资源(临界资源)
     */
    private static int i = 0;

    public synchronized void increase() {// synchronized修饰的是实例方法increase()，当前的所对象就是实例对象，java中的线程同步锁可以是任意对象
        i++; // i++不具有原子操作，i++操作时先读取值，之后再原来的值的基础上面加上1，分两步完成
    }
    //不加synchronized结果就不是20000了


    @Override
    public void run() { // 实现runnable接口，runnable接口中run方法就是要实现的方法
        for (int j = 0; j < 10000; j++) {
            increase();
            if (j < 2) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AccountingSync instance = new AccountingSync();
        //thread内部是实现runnable接口的实例
        Thread t1 = new Thread(instance);
        //同一个实例创建了两个线程
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();// java中的join（）方法，将交替执行的线程合并为顺序执行的线程。
        t1.join();//在主线程中调用了join()方法，等于将主线程和t1线程执行的方式改为了串行
        t2.join();//必须当线程全部执行结束之后才会调用线程，join方法还可以调用过期时间，就是说在执行到预定时间后
        // 执行方式将继续以并行的方式执行
        System.out.println(i);
    }
}