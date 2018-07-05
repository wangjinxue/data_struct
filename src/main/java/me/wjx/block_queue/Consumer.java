package me.wjx.block_queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author wjx
 * @date 2018/7/3 10:38
 */
public class Consumer implements Runnable {
    private final BlockingQueue queue;

    Consumer(BlockingQueue q) {
        queue = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    void consume(Object x) {
        System.out.println(x);
    }
}
