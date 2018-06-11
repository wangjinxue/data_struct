package me.wjx.linkedblocking;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author wjx
 * @date 2018/5/30 17:53
 */
public class Consumer implements Runnable {
    private BlockingQueue<String> queue;
    private static final int DEFAULT_RANGE_FOR_SLEEP=1000;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("启动消费者线程!");
        Random r=new Random();
        boolean isRunning=true;
        try{
            while(isRunning){
                System.out.println("正在从队列获取数据");
                String data=queue.poll(2, TimeUnit.SECONDS);
                if(null!=data){
                    System.out.println("正在消费数据："+data);
                    Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));

                }else{
                    isRunning=false;
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("退出消费者线程");
        }
    }
}
