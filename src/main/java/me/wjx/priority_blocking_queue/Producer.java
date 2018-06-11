package me.wjx.priority_blocking_queue;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author wjx
 * @date 2018/5/30 18:22
 */
public class Producer implements Runnable {
    private static final int DEFAULT_RANGE_FOR_SLEEP=1000;
    private volatile boolean isRunning = true;

    private PriorityQueue<String> queue;

    public Producer(PriorityQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("生产者线程启动" + toString());
        try {
            while (isRunning) {
                System.out.println("正在生产数据");
                Thread.sleep(new Random().nextInt(DEFAULT_RANGE_FOR_SLEEP));
                String data=getRandomString(5);
                if(!queue.offer(data)){
                    System.out.println("数据放入失败"+data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static String getRandomString(int length) {
//定义一个字符串（A-Z，a-z，0-9）即62位；
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
//由Random生成随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
//长度为几就循环几次
        for (int i = 0; i < length; ++i) {
//产生0-61的数字
            int number = random.nextInt(62);
//将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
//将承载的字符转换成字符串
        return sb.toString();
    }

    void setStop(){
        isRunning=false;
    }
}
