package thread1test2example;

import java.util.concurrent.*;

/**
 * @author Tethamo_zzx
 * @date 2019-10-5  下午 09:37
 * 简介：
 *      以下是建立线程池的实例
 */
public class XianChengChiTest {
    public static void main(String[] arExecutorsgs) {
        /**使用defaultThreadFactory方法来建立threadFactory*/
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(
                1,
                1,
                1,
                /**Milliseconds,毫秒级别*/
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(1024),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();

    }
}
