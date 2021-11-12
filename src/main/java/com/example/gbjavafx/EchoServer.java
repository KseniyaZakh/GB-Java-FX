package com.example.gbjavafx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Ожидаем подключения клиента...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            final DataInputStream in = new DataInputStream(socket.getInputStream());
            final DataOutputStream out = new DataOutputStream(socket.getOutputStream());


            while (true) {
                final String message = in.readUTF();
                System.out.println("Сообщение от клиента: " + message);
                if (message.startsWith("/end")) {
                    out.writeUTF("/end");
                    break;
                }
                out.writeUTF("Эхо: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите сообщение клиенту");
                String msg = scanner.next();
                System.out.println("Сообщение клиенту: + msg");

            }
        }).start();
    }
}


