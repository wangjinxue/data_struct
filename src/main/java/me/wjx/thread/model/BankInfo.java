package me.wjx.thread.model;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wjx
 * @date 2018/6/22 16:50
 */
public class BankInfo {
    /**
     * 余额
     */
    private  int money;
    ReentrantLock lock=new ReentrantLock();
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public  void increment() {
        lock.lock();
        try {
            money =money+ 1;
        }finally {
            lock.unlock();
        }

    }
}
