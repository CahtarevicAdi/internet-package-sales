package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/internet_package_form.fxml"));
            Parent root = loader.load();


            Scene scene = new Scene(root);


            scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());


            primaryStage.setTitle("Internet Package Sales App");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

