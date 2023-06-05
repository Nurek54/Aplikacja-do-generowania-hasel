package com.example.projektapkadogenerowaniahasel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Controller {

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField lengthTextField;

    private Map<String, String> savedPasswords;

    public void initialize() {
        savedPasswords = new HashMap<>();
    }

    @FXML
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

    @FXML
    public void savePassword(ActionEvent event) {
        String password = passwordLabel.getText();
        if (!password.isEmpty()) {
            savedPasswords.put(password, password);
            showAlert("Informacja", "Hasło zostało zapisane.");
        } else {
            showAlert("Błąd", "Brak wygenerowanego hasła.");
        }
    }

    @FXML
    public void restorePassword(ActionEvent event) {
        String password = savedPasswords.get(passwordLabel.getText());
        if (password != null) {
            passwordLabel.setText(password);
        } else {
            showAlert("Informacja", "Brak zapisanego hasła.");
        }
    }

    @FXML
    public void clearPasswords(ActionEvent event) {
        savedPasswords.clear();
        showAlert("Informacja", "Hasła zostały wyczyszczone.");
    }

    @FXML
    public void exitApplication(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void displayPasswords(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("passwords.fxml"));
            Parent root = fxmlLoader.load();
            PasswordsController passwordsController = fxmlLoader.getController();
            passwordsController.setPasswords(savedPasswords);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Zapisane hasła");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
