package me.wjx.block_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
  @author wjx
  @date 2018/7/3 10:40
 */
public class Setup {
    public static void main(String[] args) {
      BlockingQueue q = new ArrayBlockingQueue(100,false);
      Producer p = new Producer(q);
      Consumer c1 = new Consumer(q);
      Consumer c2 = new Consumer(q);
      new Thread(p).start();
      new Thread(c1).start();
      new Thread(c2).start();
    }
}
