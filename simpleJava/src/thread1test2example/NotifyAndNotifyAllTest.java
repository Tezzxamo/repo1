package thread1test2example;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tethamo_zzx
 * @date 2019-10-12  上午 11:03
 */
public class NotifyAndNotifyAllTest {

    public static void main(String[] args) {
        Object obj = new Object();
        AtomicInteger i= new AtomicInteger();
        ExecutorService executorService = new ThreadPoolExecutor(
                5,
                10,
                1,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(1024),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        executorService.execute(() -> {
            synchronized (obj) {
                for(;i.get()<100;) {
                    i.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(() -> {
            synchronized (obj) {
                for(;i.get()<100;) {
                    i.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    obj.notifyAll();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(()->{
            synchronized (obj) {
                for(;i.get()<100;) {
                    i.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    obj.notifyAll();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(()->{
            synchronized (obj) {
                for(;i.get()<100;) {
                    i.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    obj.notifyAll();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

   /* private static class Aa implements Runnable{

        @Override
        public void run() {
            i++;
            System.out.println(Thread.currentThread().getName()+" : "+i);
            object.notify();
        }
    }*/


}
