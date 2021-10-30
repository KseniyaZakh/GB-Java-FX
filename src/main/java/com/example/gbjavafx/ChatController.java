package com.example.gbjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import javax.swing.filechooser.FileView;
import java.io.*;

import static javax.swing.text.StyleConstants.Background;


public class ChatController {
    @FXML
    private TextField messageField;
    @FXML
    private TextArea messageArea;

    public void clickButtonSend(ActionEvent actionEvent) {
        final String message = messageField.getText();
        if (message.isEmpty()) {
            return;
        }
        messageArea.appendText(message + "\n");
        messageField.setText(" ");
        messageField.requestFocus();
    }

    public void menuExitSelect(ActionEvent actionEvent) {
        System.exit(0);
    }


    public void cleanField(ActionEvent actionEvent) {
        messageField.setText("");

    }


}