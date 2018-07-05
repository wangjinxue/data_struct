package me.wjx.block_queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author wjx
 * @date 2018/7/3 10:37
 */
public class Producer implements Runnable {
    private final BlockingQueue queue;

    Producer(BlockingQueue q) {
        queue = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                queue.put(produce());
            }
        } catch (InterruptedException ex) {
        }
    }

    Message produce() {
        Message message=new Message();
        message.setMessage("message"+new Random().nextInt(10000));
        return message;
    }
}
