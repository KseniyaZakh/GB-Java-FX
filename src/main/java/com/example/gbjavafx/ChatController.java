package com.example.gbjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ChatController {
    @FXML
    private TextField messageField;
    @FXML
    private TextArea messageArea;

    private ChatClient client;

    public ChatController() {
        client = new ChatClient(this);
    }

    public void clickButtonSend(ActionEvent actionEvent) {
        final String message = messageField.getText().trim();
        if (message.isEmpty()) {
            return;
        }
        client.sendMessage(message);
        messageField.clear();
        messageField.requestFocus();
    }

    public void menuExitSelect(ActionEvent actionEvent) {
        System.exit(0);
    }


    public void cleanField(ActionEvent actionEvent) {
        messageField.setText("");

    }


    public void addMessage(String message) {
        messageArea.appendText(message + "\n");
    }
}