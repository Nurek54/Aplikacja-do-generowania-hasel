package com.example.projektapkadogenerowaniahasel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("generator_view.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Generator Haseł");
        primaryStage.setScene(new Scene(root, 400, 400));

        Scene scene = primaryStage.getScene();
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
