package MQ;

import java.io.*;
import java.net.*;

/**
 * MQ是指消息队列（Message Queue），是一种应用程序对应用程序的通信方法。它应用于程序解耦、异步处理、流量削锋等场景。
 * MQ系统通常由消息生产者、消息消费者、消息中间件和消息监控组成，消息生产者向消息中间件发送消息，消息中间件将消息存储并转发给消息消费者。
 */
public class MQClient {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", PORT)) { //在客户端中创建了一个 Socket 对象，并指定了连接到的服务器地址和端口号
            System.out.println("Connected to MQ server");
            OutputStream output = socket.getOutputStream(); //获取到输出流对象,一般通过 output.write(data) 向服务器发送数据。
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            writer.println("Message 1");//字符串 "Message 1" 发送到 output 流中，发送给指定服务器。
            String response = reader.readLine();
            System.out.println("Received response1: " + response);

            writer.println("Message 2");
            response = reader.readLine();
            System.out.println("Received response2: " + response);

            writer.println("POLL");
            response = reader.readLine();
            System.out.println("Received message3: " + response);

            writer.println("POLL");
            response = reader.readLine();
            System.out.println("Received message4: " + response);

            writer.println("POLL");
            response = reader.readLine();
            System.out.println("Received message5: " + response);

            writer.println("Message 3");
            response = reader.readLine();
            System.out.println("Received response6: " + response);

        } catch (UnknownHostException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
