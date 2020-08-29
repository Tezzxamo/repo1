package thread1test2example;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author Tethamo_zzx
 * @date 2019-10-13  下午 02:59
 */
public class ProducerConsumerWithLockDemo {
    public static void main(String[] args) {
        ProductFactoryWithLock productFactory = new ProductFactoryWithLock(10);
        new Thread(new ProducerWithLock(productFactory), "1号生产者").start();
        new Thread(new ConsumerWithLock(productFactory), "1号消费者").start();
        new Thread(new ConsumerWithLock(productFactory), "2号消费者").start();
    }
}

class ProductFactoryWithLock {
    private List<String> products;
    private int capacity = 0;
    private Lock lock = new ReentrantLock(false);
    private Condition canProduce = lock.newCondition();
    private Condition canConsume = lock.newCondition();
    public ProductFactoryWithLock(int capacity) {
        this.capacity = capacity;
        products = new LinkedList<>();
    }

    // 生产产品
    public void produce(String product) {
        lock.lock();
        try {
            while (capacity == products.size()) {
                //打日志的目的是更好的观察消费者和生产者状态
                System.out.println("警告：线程(" + Thread.currentThread().getName() + ")准备生产产品，但产品池已满");
                try {
                    canProduce.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            products.add(product);
            System.out.println("线程(" + Thread.currentThread().getName() + ")生产了一件产品:" + product + ";当前剩余商品" + products.size() + "个");
            canConsume.signalAll();
        } finally {
            lock.unlock();
        }

    }

    // 消费产品
    public synchronized String consume() {
        lock.lock();
        try{
            while (products.size() == 0) {
                try {
                    //打日志的目的是更好的观察消费者和生产者状态
                    System.out.println("警告：线程(" + Thread.currentThread().getName() + ")准备消费产品，但当前没有产品");
                    canConsume.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String product = products.remove(0);
            System.out.println("线程(" + Thread.currentThread().getName() + ")消费了一件产品:" + product + ";当前剩余商品" + products.size() + "个");
            canProduce.signal();
            return product;
        }finally {
            lock.unlock();
        }
    }
}

// 生产者
class ProducerWithLock implements Runnable {
    private ProductFactoryWithLock productFactory;
    public ProducerWithLock(ProductFactoryWithLock productFactory) {
        this.productFactory = productFactory;
    }
    @Override
    public void run() {
        int i = 0;
        while (true) {
            productFactory.produce(String.valueOf(i));
            i++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 消费者
class ConsumerWithLock implements Runnable {
    private ProductFactoryWithLock productFactory;
    public ConsumerWithLock(ProductFactoryWithLock productFactory) {
        this.productFactory = productFactory;
    }

    @Override
    public void run() {
        while (true) {
            productFactory.consume();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
