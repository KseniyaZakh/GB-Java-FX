package com.example.gbjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import javax.swing.*;
import java.util.List;


public class ChatController {
    @FXML
    public ListView<String> clientList;
    @FXML
    private TextField messageField;
    @FXML
    private TextArea messageArea;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField loginField;
    @FXML
    private HBox loginBox;
    @FXML
    private HBox messageBox;

    private ChatClient client;

    public ChatController() {

        client = new ChatClient(this);
        client.openConnection();
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

    public void btnAuthClick(ActionEvent actionEvent) {
        client.sendMessage("/auth " + loginField.getText() + " " + passwordField.getText());

    }

    public void setAuth(boolean isClientAuth) {
        loginBox.setVisible(!isClientAuth);
        messageBox.setVisible(isClientAuth);
    }


    public void selectClient(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            final String message = messageField.getText();
            final String nick = clientList.getSelectionModel().getSelectedItem();
            messageField.setText("/w " + nick + " " + message);
            messageField.requestFocus();
            messageField.selectEnd();
        }
    }

    public void updateClientList(List<String> clients) {
        clientList.getItems().clear();
        clientList.getItems().addAll(clients);
    }
}
