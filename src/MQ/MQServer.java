package MQ;

import java.io.*;
import java.net.*;
import java.util.*;

public class MQServer {
    private static final int PORT = 12345;
    private static final int BUFFER_SIZE = 1024;
    private static List<String> messageQueue = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("MQ server started at port " + PORT);

            //serverSocket.accept() 是在等待客户端的连接，一旦有客户端连接到该服务端的端口号（PORT），
            // 则该方法会返回一个新的 Socket 对象，该对象表示和客户端之间的一个连接。
            // 这里的 clientSocket 变量就是表示这个连接的 Socket 对象。
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress().getHostName());

                    InputStream input = clientSocket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                    OutputStream output = clientSocket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);

                    String message;
                    while ((message = reader.readLine()) != null) {
                        if (message.equals("POLL")) {
                            if (!messageQueue.isEmpty()) {
                                String queuedMessage = messageQueue.remove(0);
                                System.out.println("Sending message: " + queuedMessage);
                                writer.println(queuedMessage);
                            } else {
                                writer.println("EMPTY");
                            }
                        } else {
                            System.out.println("Received message: " + message);
                            messageQueue.add(message);
                            writer.println("ACK");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

