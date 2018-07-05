package me.wjx.fork_join;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author wjx
 * @date 2018/7/4 16:30
 */
public class BankWaterService implements Runnable {
    /**
     * 创建4个屏障,处理完之后执行当前的run方法
     */
    private CyclicBarrier c=new CyclicBarrier(4,this);

    /**
     * 假设只执行4个线程
     */
    private Executor executor= Executors.newFixedThreadPool(4);

    /**
     * 保存计算结果
     */
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount=new ConcurrentHashMap<>();
    private void count(){
        for(int i=0;i<4;i++){
            executor.execute(()->{
                sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                //计算完成插入屏障
                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    @Override
    public void run() {
        /**
         * 汇总计算结果
         */
        int result=0;
        for(Map.Entry<String,Integer> sheet:sheetBankWaterCount.entrySet()){
            result+=sheet.getValue();
        }
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService=new BankWaterService();
        bankWaterService.count();
    }
}
