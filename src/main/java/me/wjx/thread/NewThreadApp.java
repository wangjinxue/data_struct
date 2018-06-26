package me.wjx.thread;

import java.util.concurrent.*;

/**
 * @author wjx
 * @date 2018/6/22 14:41
 */
public class NewThreadApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(){
            @Override
            public void run() {
                System.out.println("create thread by create Thread");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("create thread by implement Runnable");
            }
        }).start();
        ExecutorService service = Executors.newSingleThreadExecutor();
        FutureTask<String> stringFutureTask = new FutureTask<String>(() -> System.currentTimeMillis()+"hello");
        service.submit(stringFutureTask);
        String s = stringFutureTask.get();
        System.out.println(s);
    }
}
