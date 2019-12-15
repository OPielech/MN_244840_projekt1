package edu.ib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXGraph extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/graph.fxml"));
        Scene scene = new Scene(root, 800, 600);
        //scene.getStylesheets().add("fxml/Stylesheet.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Solar system planets trajectory");
        primaryStage.show();
    }
}
