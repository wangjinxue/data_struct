package me.wjx.thread.threadpool;


import me.wjx.thread.threadpool.ConnectionPool;

import java.sql.Connection;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class ConnectionRunnable implements Runnable {
    private ConnectionPool connectionPool;

    public ConnectionRunnable(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        try {
            Connection connection = connectionPool.fetchConnection(2000);
            System.out.println("connection :" + connection);
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1200));
            connectionPool.releaseConnection(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}