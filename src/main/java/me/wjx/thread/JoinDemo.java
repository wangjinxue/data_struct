package me.wjx.thread;

/**
 * @author wjx
 * @date 2018/6/22 15:16
 */
public class JoinDemo {
    public static void main(String[] args) {
        Thread priviousThread=Thread.currentThread();
        for(int i=0;i<10;i++){
            Thread curThread=new JoinThread(priviousThread);
            curThread.start();
            priviousThread=curThread;
        }
    }
    static class JoinThread extends Thread{
        private Thread thread;
        public JoinThread(Thread thread){
            this.thread=thread;
        }

        @Override
        public void run() {
            super.run();
            try {
                thread.join();
                System.out.println(thread.getName()+" terminated.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
