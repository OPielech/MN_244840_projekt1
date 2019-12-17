package edu.ib;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class AnimationTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(30);
        circle.setFill(Color.LIGHTCORAL);
        circle.setLayoutX(50);
        circle.setLayoutY(50);

        Pane root = new Pane();
        root.getChildren().addAll(circle);
    }
}
