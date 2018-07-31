package me.wjx.executor.custom_monitor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author wjx
 * @date 2018/7/16 18:24
 */
public class MonitorableThreadPoolExecutor extends ThreadPoolExecutor {
    private Map<String,MonitorHandler> handlerMap=new HashMap<>(10);
    private final Object monitor=new Object();

    public MonitorableThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MonitorableThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MonitorableThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MonitorableThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        for(MonitorHandler handler:handlerMap.values()){
            if(handler.usable()){
                handler.before(t,r);
            }
        }
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        for(MonitorHandler handler:handlerMap.values()){
            if(handler.usable()){
                handler.after(r,t);
            }
        }
    }

    @Override
    protected void terminated() {
        super.terminated();
        for(MonitorHandler handler:handlerMap.values()){
            if(handler.usable()){
                handler.terminated(getLargestPoolSize(),getCompletedTaskCount());
            }
        }
    }
    public MonitorHandler addMonitorTask(String key,MonitorHandler task,boolean overrideIfExist){
        if(overrideIfExist){
            synchronized (monitor){
                return handlerMap.put(key,task);
            }
        }else{
            synchronized (monitor){
                return handlerMap.putIfAbsent(key,task);
            }
        }
    }
}
