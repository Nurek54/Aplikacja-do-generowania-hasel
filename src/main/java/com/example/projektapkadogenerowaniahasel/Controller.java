package com.example.projektapkadogenerowaniahasel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
        String lengthText = lengthTextField.getText();
        if (lengthText.matches("\\d+")) {
            int length = Integer.parseInt(lengthText);
            String password = generateRandomPassword(length);
            passwordLabel.setText(password);
        } else {
            showAlert("Błąd", "Niepoprawna długość hasła. Wprowadź liczbę całkowitą.");
        }
    }

    public void savePassword(ActionEvent event) {
        savedPassword = passwordLabel.getText();
        showAlert("Informacja", "Hasło zostało zapisane.");
    }

    public void restorePassword(ActionEvent event) {
        if (savedPassword != null) {
            passwordLabel.setText(savedPassword);
        } else {
            showAlert("Informacja", "Brak zapisanego hasła.");
        }
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

    public void exitApplication(ActionEvent event) {
        System.exit(0);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
