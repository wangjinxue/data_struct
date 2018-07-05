package me.wjx.block_queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author wjx
 * @date 2018/7/2 18:03
 */
public class App {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayListQueue=new ArrayBlockingQueue<String>(100,true);
    }
}
