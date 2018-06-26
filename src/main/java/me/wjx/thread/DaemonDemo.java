package me.wjx.thread;

/**
 * @author wjx
 * @date 2018/6/22 15:24
 */
public class DaemonDemo {
    public  static boolean  stop=true;
    public static void main(String[] args) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (stop) {
                    try {
                        System.out.println("i am alive");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("finnally");
                    }
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
        try {
            Thread.sleep(800);
            stop=false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
