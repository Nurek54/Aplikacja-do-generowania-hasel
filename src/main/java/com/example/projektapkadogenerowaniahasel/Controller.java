package com.example.projektapkadogenerowaniahasel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Random;

public class Controller {

    @FXML
    private Label passwordLabel;

    public void generatePassword(ActionEvent event) {
        String password = generateRandomPassword();
        passwordLabel.setText(password);
    }

    public void exitApplication(ActionEvent event) {
        Stage stage = (Stage) passwordLabel.getScene().getWindow();
        stage.close();
    }

    private String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
}
