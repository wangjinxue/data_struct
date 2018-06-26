package me.wjx.thread.threadpool;


import me.wjx.thread.SleepUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    /**
     * 构造时就初始化一定量的Connection便于使用
     * @param initialSize
     */
    public ConnectionPool(int initialSize){
        try {
            if (initialSize > 0) {
                for (int i = 0; i < initialSize; i++) {
                    pool.addLast(DriverManager.getConnection("jdbc:mysql://localhost:3306/school?autoReconnect=true&useUnicode=true&characterEncoding=utf8", "root", "root"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放Connection
     * @param connection
     */
    public void releaseConnection(Connection connection) {
        System.out.println("release : "+connection);
        if (connection != null) {
            synchronized (pool) {
// 连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
        System.out.println("pool connection size:"+pool.size());
    }

    // 在mills内无法获取到连接，将会返回null
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
// 完全超时
            //判断是否立即返回
            if (mills <= 0) {
                //如果是空的就等待，直到不为空返回
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                //判断是否为空并且剩余等待时间大于0
                while (pool.isEmpty() && remaining > 0) {
                    //等待剩余的时间
                    pool.wait(remaining);
                    //计算等待的时间
                    remaining = future - System.currentTimeMillis();
                }
                //超时则直接返回空
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }

    public static void main(String[] args) {
        ConnectionPool connectionPool= null;
            connectionPool = new ConnectionPool(5);

        for(int i=0;i<10;i++){
            new Thread(new ConnectionRunnable(connectionPool),"i").start();
        }

        SleepUtils.second(10);
    }

}