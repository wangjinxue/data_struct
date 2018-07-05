package me.wjx.block_queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author wjx
 * @date 2018/7/3 10:13
 */
public class QueueThreadProducer<T> implements Runnable {
    BlockingQueue<String> queue;

    public QueueThreadProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("offer value:hello"+i+queue.offer("hello" + i));
        }
    }
}
