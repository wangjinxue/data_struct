package me.wjx.fork_join;

import me.wjx.thread.SleepUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wjx
 * @date 2018/7/4 16:11
 */
public class CyclicBarrierTest {
    static CyclicBarrier c=new CyclicBarrier(3);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(()->{
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();
        new Thread(()->{
            SleepUtils.second(3);
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(2);
        }).start();
        c.await();

        System.out.println(3);
    }
}
