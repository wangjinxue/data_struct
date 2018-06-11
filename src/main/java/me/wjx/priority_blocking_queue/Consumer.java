package me.wjx.priority_blocking_queue;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author wjx
 * @date 2018/5/30 18:32
 */
public class Consumer implements Runnable {
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;
    private volatile boolean isRunning = true;

    private PriorityQueue<String> queue;

    public Consumer(PriorityQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("生产者线程启动" + toString());
        try {
            while (isRunning) {
                System.out.println("正在生产数据");
                Thread.sleep(new Random().nextInt(DEFAULT_RANGE_FOR_SLEEP));
                String data = queue.poll();
                System.out.println("获取到数据" + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    void setStop() {
        isRunning = false;
    }
}
