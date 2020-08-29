package thread1test2example;


import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/**
 * 视频会议室里等与会人员到齐了会议才能开始
 */
/**
 * @author Tethamo_zzx
 * @date 2019-10-8  下午 04:17
 */
public class CountDownLatchTest {
    /**
     * 与会人员数量
     */
    private static int num=10;

    public static void main(String[] args) {
        VideoConference conference = new VideoConference(num);
        Thread threadConference = new Thread(conference);
        threadConference.start();//开启await()方法，在内部计数器为0之前线程处于等待状态
        for (int i = 0; i < num; i++) {
            Participant p = new Participant(conference, "Participant " + i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}

/**
 * 视频会议类
 */
class VideoConference implements Runnable {
    private final CountDownLatch controller;

    VideoConference(int number) {
        //计数器内等待其他线程的初始化数目
        controller = new CountDownLatch(number);
    }

    void arrive(String name) {
        System.out.printf("%s 到达。\n", name);
        controller.countDown();//调用countDown()方法，使内部计数器减1
        System.out.printf("视频会议：正在等待%d个参与者。\n", controller.getCount());
    }

    @Override
    public void run() {
        synchronized (VideoConference.class){
            if(controller.getCount()!=0){
                System.out.printf("视频会议：初始化：%d参与者。\n", controller.getCount());
            }
        }
        try {
            controller.await();//等待，直到CoutDownLatch计数器为0

            System.out.print("视频会议：所有与会者都来了\n");
            System.out.print("视频会议：让我们开始…\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 参加会议的人员类
 */
class Participant implements Runnable {

    private VideoConference conference;
    private String name;

    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        /*符合alibaba规约的random取值方法*/
        long duration = (long) (new Random().nextInt(10));
        /*System.out.println(duration);*/
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*每到一个人员，CountDownLatch计数器就减少1*/
        conference.arrive(name);
    }
}