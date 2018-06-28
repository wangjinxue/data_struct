package me.wjx.thread.threadpool;

import com.mysql.jdbc.StringUtils;
import me.wjx.thread.threadpool.interfaces.ThreadPool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @author wjx
 * @date 2018/6/27 10:11
 */
public class SimpleHttpServer {
    static ThreadPool<HttpRequestHandler> threadPool=new DefaultThreadPool<>();
    static String bashPath;
    static ServerSocket serverSocket;
    static int port=8080;
    public static void setPort(int port){
        if(port>0){
            SimpleHttpServer.port=port;
        }
    }
    public static void setBashPath(String basePath){
        if(StringUtils.isNullOrEmpty(basePath)) {
            return;
        }
        File file=new File(basePath);
        if(file==null||!file.exists()) {
            System.out.println("文件不存在");
            return;
        }
        if(file.isDirectory()){
            SimpleHttpServer.bashPath=basePath;
        }
    }
    public static void start() throws IOException {
        serverSocket=new ServerSocket(port);
        Socket socket=null;
        while((socket=serverSocket.accept())!=null){
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }

    static class HttpRequestHandler implements Runnable {
        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
// 由相对路径计算出绝对路径
                String filePath = bashPath + header.split(" ")[1];
                OutputStream outputStream = socket.getOutputStream();
                out = new PrintWriter(outputStream);
// 如果请求资源的后缀为jpg或者ico，则读取资源并输出
                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    byte[] buff=new byte[128];
                    while ((i = in.read()) != -1) {
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length: " + array.length);
                    out.println("");
                    socket.getOutputStream().write(array, 0, array.length);
                } else {
                    br = new BufferedReader(new InputStreamReader(new
                            FileInputStream(filePath)));
                    out = new PrintWriter(outputStream);
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.flush();
            } catch (Exception ex) {
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            } finally {
                close(br, in, reader, out, socket);
            }
        }
    }

    // 关闭流或者Socket
    private static void close(Closeable... closeables) {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                try {
                    closeable.close();
                } catch (Exception ex) {
                }
            }
        }
    }

}
