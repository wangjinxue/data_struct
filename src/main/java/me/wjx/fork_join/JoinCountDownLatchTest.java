package me.wjx.fork_join;

import me.wjx.thread.SleepUtils;

/**
 * @author wjx
 * @date 2018/7/4 16:03
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SleepUtils.second(3);
                System.out.println("parse1 finish");
            }
        });
        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SleepUtils.second(6);
                System.out.println("parser2 finish");
            }
        });
        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();
        System.out.println("all parser finish");
    }
}
