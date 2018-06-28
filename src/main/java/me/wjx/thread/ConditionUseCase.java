package me.wjx.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wjx
 * @date 2018/6/28 16:36
 */
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionUseCase conditionUseCase = new ConditionUseCase();

        try {
            conditionUseCase.conditionWait();
//            SleepUtils.second(2000);
            conditionUseCase.conditionSignal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
