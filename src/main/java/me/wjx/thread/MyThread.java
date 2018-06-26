package me.wjx.thread;

import me.wjx.thread.model.BankInfo;

class MyThread implements Runnable {
    private BankInfo bankInfo;

    public MyThread(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }

    @Override
    public void run() {
        System.out.println("---------" + Thread.currentThread().getName() + "starting");
        for (int i = 0; i < 1000; i++) {
            bankInfo.increment();
        }
    }
}