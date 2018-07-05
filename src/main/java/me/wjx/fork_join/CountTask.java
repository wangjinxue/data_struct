package me.wjx.fork_join;

import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.concurrent.RecursiveTask;

/**
 * @author wjx 计算的子任务
 * @date 2018/7/3 13:52
 */
public class CountTask  extends RecursiveTask<Integer>{
    //阈值
    private static final int THRESHOLD=2;
    private int start;
    private int end;
    public CountTask(int start,int end){
        this.start=start;
        this.end=end;
    }
    @Override
    protected Integer compute() {
        int sum=0;
        //如果任务足够小就计算
        boolean canCompute=(end-start)<=THRESHOLD;
        if(canCompute){
            for(int i=start;i<=end;i++){
                sum+=i;
            }
        }else{
            //分割子任务
            int middle=(start+end)/2;
            System.out.println("middle:"+middle);
            //1 -8   middle 4  left:1 right 4 middle 2 left 5 right 8  middle 6
            CountTask leftTask=new CountTask(start,middle);
            CountTask rightTask=new CountTask(middle+1,end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完,并得到其结果
            int leftResult=leftTask.join();
            int rightResult = rightTask.join();
            sum=leftResult+rightResult;
        }
        return sum;
    }
}
