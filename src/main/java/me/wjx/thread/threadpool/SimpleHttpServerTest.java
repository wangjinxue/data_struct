package me.wjx.thread.threadpool;

import java.io.IOException;

/**
 * @author wjx
 * @date 2018/6/27 10:20
 */
public class SimpleHttpServerTest {
    public static void main(String[] args) {
        SimpleHttpServer.setPort(8080);
        SimpleHttpServer.setBashPath("C:\\Users\\wangli\\Pictures\\girl");
        try {
            SimpleHttpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
