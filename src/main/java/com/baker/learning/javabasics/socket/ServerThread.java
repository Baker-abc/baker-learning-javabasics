package com.baker.learning.javabasics.socket;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 该类为多线程类，用于服务端
 */
@Log4j2
public class ServerThread implements Runnable {

    private Socket client = null;

    public ServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        PrintStream out = null;
        try {
            log.info("==============Server实例 init  {} ==================", Thread.currentThread().getName());
            //获取Socket的输出流，用来向客户端发送数据
            out = new PrintStream(client.getOutputStream());
            //获取Socket的输入流，用来接收从客户端发送过来的数据
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true) {
                //接收从客户端发送过来的数据
                log.info("等待客户端的数据");
                String str = buf.readLine();
                log.info("接收到客户端的数据：{}", str);
                //将接收到的字符串前面加上echo，发送到对应的客户端
                String res = "echo:" + str;
                log.info("返回给客户端的数据：{}", res);
                out.println(res);
            }
        } catch (Exception e) {
            log.error("当前Server连接实例异常：", e);
        } finally {
            if (out != null) {
                out.close();
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    log.error("关闭当前Server连接实例异常：", e);
                }
            }
            log.info("==============Server实例 destroy {} ==================", Thread.currentThread().getName());
        }
    }

}
