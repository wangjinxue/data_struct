package me.wjx.executor.custom_monitor;

/**
 * @author wjx
 * @date 2018/7/16 18:23
 */
public interface MonitorHandler {
    boolean usable();
    void before(Thread thread,Runnable runnable);
    void after(Runnable runnable,Throwable throwable);
    void terminated(int largestPoolSize,long completedTaskCount);
}
