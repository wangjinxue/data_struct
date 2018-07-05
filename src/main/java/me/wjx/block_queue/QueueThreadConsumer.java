package me.wjx.block_queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author wjx
 * @date 2018/7/3 10:13
 */
public class QueueThreadConsumer implements Runnable {
    BlockingQueue<String> queue;
    public QueueThreadConsumer(BlockingQueue<String> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
