package org.example.comp1011finalexamsummer2024;

//Krish Gurung
//200560503
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the correct FXML file (table-view.fxml)
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("table-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Table View Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
