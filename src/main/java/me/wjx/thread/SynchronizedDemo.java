package me.wjx.thread;

import me.wjx.thread.model.BankInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author wjx
 * @date 2018/6/22 16:30
 */
public class SynchronizedDemo {

    public static void main(String[] args) throws InterruptedException {
        BankInfo bankInfo=new BankInfo();
        for(int i=0;i<10;i++){
            Thread myThread=new Thread(new MyThread(bankInfo));
            myThread.start();

        }
        Thread.sleep(2000);
        System.out.println(bankInfo.getMoney());
    }

}
