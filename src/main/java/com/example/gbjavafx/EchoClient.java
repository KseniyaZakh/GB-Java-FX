package com.example.gbjavafx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private ChatController controller;

    public EchoClient(ChatController controller) {
        this.controller = controller;
        openConnection();
    }

    public void openConnection() {
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            final String message = in.readUTF();
                            if ("/end".equals(message)) {
                                break;
                            }

                            controller.addMessage(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        closeConnection();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}