package me.wjx.thread.lock;

import me.wjx.thread.SleepUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有界的队列
 *
 * @author wjx
 * @date 2018/6/28 16:46
 */
public class BoundedQueue<T> {
    private Object[] items;
    // 添加的下标，删除的下标和数组当前数量
    private int addIndex, removeIndex, count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();


    public BoundedQueue(int size) {
        items = new Object[size];
    }

    // 添加一个元素，如果数组满，则添加线程进入等待状态，直到有"空位"
    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[addIndex] = t;
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 由头部删除一个元素，如果数组空，则删除线程进入等待状态，直到有新添加元素
    @SuppressWarnings("unchecked")
    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[removeIndex];
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }
            --count;
            notFull.signal();
            return (T) x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BoundedQueue<String> queues = new BoundedQueue<>(3);
        new MyThread(queues).start();
        new MyThread1(queues).start();
    }

    @Override
    public String toString() {
        return "BoundedQueue{" +
                "items=" + Arrays.toString(items) +
                '}';
    }

    static class   MyThread extends Thread {
        BoundedQueue<String> queues;

        private MyThread(BoundedQueue<String> queue) {
            this.queues = queue;
        }

        @Override
        public void run() {
            try {
                queues.add("hello");
                queues.add("hello1");
                queues.add("hello2");
                SleepUtils.second(15);
                queues.add("hello3");
               
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class MyThread1 extends Thread {
        BoundedQueue queues;
        private MyThread1(BoundedQueue queue) {
            this.queues = queue;
        }

        @Override
        public void run() {
            try {
                queues.remove();
                queues.remove();
                queues.remove();
                SleepUtils.second(10);
                queues.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
