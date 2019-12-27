package com.baker.learning.javabasics.socket;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @date 2019/8/8 11:42
 */
@Log4j2
public class Server {

    public static final String ip = "127.0.0.1";
    public static final int port = 8092;

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket client = null;
        try {
            log.info("==============Server init ==================");
            //服务端在20006端口监听客户端请求的TCP连接
            server = new ServerSocket(port);
            while (true) {
                log.info("==============Server wait ==================");
                //等待客户端的连接，如果没有获取连接
                client = server.accept();
                log.info("与客户端连接成功！");
                //为每个客户端连接开启一个线程
                new Thread(new ServerThread(client)).start();
            }
        } catch (Exception e) {
            log.error("异常：", e);
        } finally {
            if (server != null) {
                server.close();
            }
            if (client != null) {
                client.close();
            }
            log.info("==============Server实例 destroy ==================");
        }
    }
}
