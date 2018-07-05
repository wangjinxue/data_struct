package me.wjx.fork_join;

import me.wjx.thread.SleepUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author wjx 信号量
 * @date 2018/7/4 16:50
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT=30;
    private static ExecutorService threadPool= Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s=new Semaphore(10);

    public static void main(String[] args) {
        for(int i=0;i<THREAD_COUNT;i++){
            threadPool.execute(()->{
                try {
                    //获取信号
                    s.acquire();
                    SleepUtils.second(1);
                    System.out.println("save data"+s.availablePermits());

                    //释放信号
                    s.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }
}
