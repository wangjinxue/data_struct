package me.wjx.executor;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wjx
 * @date 2018/7/16 18:09
 */
public class App  implements Runnable{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        PausableThreadPoolExecutor executor=new PausableThreadPoolExecutor(5,10,10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
//        FutureTask<String> futureTask=new FutureTask<String>(()->{
//            String name="wangjinxue";
//            return new Random(10).nextInt(100)+name;
//        });
        new PriorityQueue<>();
        ThreadPoolExecutor executor1=new ThreadPoolExecutor(5,10,10,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(100),new ThreadPoolExecutor.DiscardPolicy());
        for(int i=0;i<1000;i++){
            executor1.submit(new App());
        }
    }

    @Override
    public void run() {
        System.out.println("hello");
    }
}
