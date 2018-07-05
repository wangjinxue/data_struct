package me.wjx.fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author wjx
 * @date 2018/7/3 14:01
 */
public class App {
    public static void main(String[] args) {
        //把大任务切割成小人物最后再合并
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        CountTask task=new CountTask(1,8);
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(task.getException());

    }
}
