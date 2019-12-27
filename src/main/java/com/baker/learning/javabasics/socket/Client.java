package com.baker.learning.javabasics.socket;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @date 2019/8/8 10:00
 */
@Log4j2
public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = null;
        BufferedReader input = null;
        try {
            client = new Socket(Server.ip, Server.port);
            client.setSoTimeout(1000 * 10);
            //获取键盘输入
            input = new BufferedReader(new InputStreamReader(System.in));
            //获取Socket的输出流，用来发送数据到服务端
            PrintStream out = new PrintStream(client.getOutputStream());
            //获取Socket的输入流，用来接收从服务端发送过来的数据
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while (true) {
                log.info("输入信息：");
                String str = input.readLine();
                log.info("发送信息：{}", str);
                //发送数据到服务端
                out.println(str);
                try {
                    //从服务器端接收数据有个时间限制（系统自设，也可以自己设置），超过了这个时间，便会抛出该异常
                    String echo = buf.readLine();
                    log.info("接收消息：{}", echo);
                } catch (SocketTimeoutException e) {
                    log.error("Time out, No response", e);
                }
            }

        } catch (Exception e) {
            log.error("异常：", e);
        } finally {
            if (input != null) {
                input.close();
            }
            if (client != null) {
                //如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，自然不用关闭
                client.close(); //只关闭socket，其关联的输入输出流也会被关闭
            }
        }
    }
}
