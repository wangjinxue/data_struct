package me.wjx.fork_join;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wjx
 * @date 2018/7/4 16:24
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier c=new CyclicBarrier(2,new A());

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
        c.await();
        System.out.println(2);
    }
    static class   A implements Runnable{
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
