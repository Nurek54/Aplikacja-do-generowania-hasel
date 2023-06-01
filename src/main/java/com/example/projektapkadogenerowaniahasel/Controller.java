package com.example.projektapkadogenerowaniahasel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField lengthTextField;

    private String savedPassword;

    public void generatePassword(ActionEvent event) {
        int length = Integer.parseInt(lengthTextField.getText());
        String password = generateRandomPassword(length);
        passwordLabel.setText(password);
    }

    public void savePassword(ActionEvent event) {
        savedPassword = passwordLabel.getText();
    }

    public void restorePassword(ActionEvent event) {
        if (savedPassword != null) {
            passwordLabel.setText(savedPassword);
        }
    }

    public void exitApplication(ActionEvent event) {
        System.exit(0);
    }

    private String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
}
