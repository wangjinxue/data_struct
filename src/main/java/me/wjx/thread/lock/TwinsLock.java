package me.wjx.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author wjx
 * @date 2018/6/27 16:54
 */
public class TwinsLock implements Lock {

    private final Sync sync = new Sync(2);
    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must largethan zero.");
            }
            //默认状态是2
            setState(count);
        }
        @Override
        public int tryAcquireShared(int reduceCount) {
            //返回-1说明可以获取共享锁
            for (;;) {
                int current = getState();
                int newCount = current - reduceCount;
                System.out.println("newCount:"+newCount+",current:"+current);
                if (newCount < 0 || compareAndSetState(current,
                        newCount)) {
                    return newCount;
                }
            }
        }
        @Override
        public boolean tryReleaseShared(int returnCount) {
            for (;;) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
    }
    @Override
    public void lock() {
        sync.acquireShared(1);
    }
    @Override
    public void unlock() {
        sync.releaseShared(1);
    }
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
