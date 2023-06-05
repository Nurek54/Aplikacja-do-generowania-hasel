package com.example.projektapkadogenerowaniahasel;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.Map;

public class PasswordsController {

    @FXML
    private TextArea passwordsTextArea;

    public void setPasswords(Map<String, String> passwords) {
        StringBuilder sb = new StringBuilder();
        for (String password : passwords.values()) {
            sb.append(password).append("\n");
        }
        passwordsTextArea.setText(sb.toString());
    }
}
