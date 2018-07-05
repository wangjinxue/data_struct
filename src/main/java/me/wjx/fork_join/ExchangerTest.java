package me.wjx.fork_join;

import java.util.ArrayDeque;
import java.util.concurrent.*;

/**
 * @author wjx
 * @date 2018/7/4 17:04
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr=new Exchanger<>();
    private static ExecutorService threadPool= Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(()->{
            String A="银行流水A";//A 员工录入银行流水数据
            try {
                String B = exgr.exchange(A);
                System.out.println(B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(()->{
            String B="银行流水B";
            try {
                String A = exgr.exchange(B);
                System.out.println(A);
                System.out.println(B.equals(A));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.shutdown();
    }
    BlockingDeque<Runnable> blockingDeque=new LinkedBlockingDeque<>();
    ThreadPoolExecutor executor=new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, blockingDeque,new ThreadPoolExecutor.CallerRunsPolicy());
}
