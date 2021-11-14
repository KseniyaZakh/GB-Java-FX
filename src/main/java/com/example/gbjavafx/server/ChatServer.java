package com.example.gbjavafx.server;

import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private final AuthService authService;
    private final List<ClientHandler> clients;

    public ChatServer() {
        this.authService = authService;
        this.clients = new ArrayList<>();
    }
}


