package com.example.lastlaba;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class PhoneBookApplication extends Application{

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(PhoneBookApplication.class.getResource("PhoneBook.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 580);

        stage.setTitle("ТЕЛЕФОННЫЙ СПРАВОЧНИК");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}