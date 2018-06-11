package me.wjx.priority_blocking_queue;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author wjx
 * @date 2018/5/30 18:15
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>(10, Comparator.naturalOrder()
        );

    }

    ;
}
