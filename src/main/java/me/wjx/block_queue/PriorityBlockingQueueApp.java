package me.wjx.block_queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author wjx
 * @date 2018/7/3 10:11
 */
public class PriorityBlockingQueueApp {
    public static void main(String[] args) {
        PriorityBlockingQueue<String> blockingQueue=new PriorityBlockingQueue<>(9);
        new Thread(new QueueThreadConsumer(blockingQueue)).start();
        new Thread(new QueueThreadProducer(blockingQueue)).start();
    }


}
