package edu.ib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

    private String path;
    private String method;
    private KeplerEquationSolver keplerEquationSolver;
    private SaveAllStepHandler saveAllStepHandler;
    private Double distance;
    private Double eccentricity;
    private boolean isDistanceNotNull = false;
    private boolean isEccentricityNotNull = false;
    private boolean isOpen = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScatterChart<Number, Number> scatterChart;

    @FXML
    private Button buttonBisection;

    @FXML
    private Button buttonFixedPointsIteration;

    @FXML
    private Button buttonNewtonRaphsonMethod;

    @FXML
    private Button buttonSecandMethod;

    @FXML
    private TextField labelDistance;

    @FXML
    private TextField labelEccentricity;

    @FXML
    private Button buttonSave;

    @FXML
    private Button buttonClear;

    @FXML
    private Button buttonMercury;

    @FXML
    private Button buttonVenus;

    @FXML
    private Button buttonEarth;

    @FXML
    private Button buttonMars;

    @FXML
    private Button buttonJupiter;

    @FXML
    private Button buttonSaturn;

    @FXML
    private Button buttonUranus;

    @FXML
    private Button buttonNeptune;

    @FXML
    private Button buttonPluto;

    @FXML
    private Button buttonCalculateTrajectory;

    @FXML
    private Button buttonAnimation;

    @FXML
    void buttonAnimationPressed(ActionEvent event) {
        if (isOpen==false) {
            openAnimationWindow();
        }
    }

    @FXML
    void buttonCalculateTrajectoryPressed(ActionEvent event) {

        try {
            isDistanceNotNull = false;
            distance = null;
            distance = Double.valueOf(labelDistance.getText());
            if (distance.equals(null))
                throw new IllegalArgumentException();
            else
                isDistanceNotNull = true;
        } catch (IllegalArgumentException e) {
            labelDistance.setText("Please insert a distance");
        }

        try {
            isEccentricityNotNull = false;
            eccentricity = null;
            eccentricity = Double.valueOf(labelEccentricity.getText());
            if (eccentricity.equals(null) || eccentricity >= 1 || eccentricity <= 0)
                throw new IllegalArgumentException();
            else
                isEccentricityNotNull = true;
        } catch (IllegalArgumentException e) {
            labelEccentricity.setText("Eccentricity is not correct");
        }

        keplerEquationSolver = new KeplerEquationSolver(distance, eccentricity);
        saveAllStepHandler = new SaveAllStepHandler();

        if (isDistanceNotNull == true && isEccentricityNotNull == true && isOpen == false) {
            openChooseMethodWindow();

            if (method.equals("Bisection method")) {
                keplerEquationSolver.addStepHandler(saveAllStepHandler);
                scatterChart.getData().add(keplerEquationSolver.solverBisection());
            } else if (method.equals("Fixed points iteration")) {
                keplerEquationSolver.addStepHandler(saveAllStepHandler);
                scatterChart.getData().add(keplerEquationSolver.solverFixedPointsIteration());
            } else if (method.equals("Newton Raphson")) {
                keplerEquationSolver.addStepHandler(saveAllStepHandler);
                scatterChart.getData().add(keplerEquationSolver.solverNewtonRaphsonMethod());
            } else if (method.equals("Secand method")) {
                keplerEquationSolver.addStepHandler(saveAllStepHandler);
                scatterChart.getData().add(keplerEquationSolver.solverSecandMethod());
            }
        }

    }//end of buttonCalculateTrajectoryPressed


    @FXML
    void buttonClearPressed(ActionEvent event) {
        scatterChart.getData().clear();

        labelEccentricity.clear();
        labelDistance.clear();
    }//end of buttonClearPressed

    @FXML
    void buttonEarthPressed(ActionEvent event) {

        keplerEquationSolver = new KeplerEquationSolver(1, 0.0167);
        saveAllStepHandler = new SaveAllStepHandler();
        keplerEquationSolver.addStepHandler(saveAllStepHandler);
        labelDistance.setText("1");
        labelEccentricity.setText("0.0167");
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }//end of buttonEarthPressed


    @FXML
    void buttonJupiterPressed(ActionEvent event) throws InterruptedException {
        keplerEquationSolver = new KeplerEquationSolver(5.203, 0.0484);
        saveAllStepHandler = new SaveAllStepHandler();
        keplerEquationSolver.addStepHandler(saveAllStepHandler);
        labelDistance.setText("5.203");
        labelEccentricity.setText("0.0484");
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonMarsPressed(ActionEvent event) {
        keplerEquationSolver = new KeplerEquationSolver(1.524, 0.0934);
        saveAllStepHandler = new SaveAllStepHandler();
        keplerEquationSolver.addStepHandler(saveAllStepHandler);
        labelDistance.setText("1.524");
        labelEccentricity.setText("0.0934");
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonMercuryPressed(ActionEvent event) {
        keplerEquationSolver = new KeplerEquationSolver(0.387, 0.2056);
        saveAllStepHandler = new SaveAllStepHandler();
        keplerEquationSolver.addStepHandler(saveAllStepHandler);
        labelDistance.setText("0.387");
        labelEccentricity.setText("0.2056");
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonNeptunePressed(ActionEvent event) {
        keplerEquationSolver = new KeplerEquationSolver(30.069, 0.0086);
        saveAllStepHandler = new SaveAllStepHandler();
        keplerEquationSolver.addStepHandler(saveAllStepHandler);
        labelDistance.setText("30.069");
        labelEccentricity.setText("0.0086");
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonPlutoPressed(ActionEvent event) {
        keplerEquationSolver = new KeplerEquationSolver(39.482, 0.2488);
        saveAllStepHandler = new SaveAllStepHandler();
        keplerEquationSolver.addStepHandler(saveAllStepHandler);
        labelDistance.setText("39.482");
        labelEccentricity.setText("0.2488");
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonSaturnPressed(ActionEvent event) {
        keplerEquationSolver = new KeplerEquationSolver(9.537, 0.0542);
        saveAllStepHandler = new SaveAllStepHandler();
        keplerEquationSolver.addStepHandler(saveAllStepHandler);
        labelDistance.setText("9.537");
        labelEccentricity.setText("0.0542");
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }


    @FXML
    void buttonSavePressed(ActionEvent event) throws FileNotFoundException {

        if (isOpen==false) {
            openChoosePathWindow();
        }

        try {
            File file = new File(path);
            PrintWriter printWriter = new PrintWriter(file);

            printWriter.println("x values:");
            for (int i = 0; i < saveAllStepHandler.xValues.size(); i++) {
                printWriter.println(saveAllStepHandler.xValues.get(i));
            }

            printWriter.println("\ny values:");
            for (int i = 0; i < saveAllStepHandler.yValues.size(); i++) {
                printWriter.println(saveAllStepHandler.yValues.get(i));
            }
            printWriter.close();

        } catch (FileNotFoundException e) {
            if(isOpen==false)
            openIncorrectPathWindow();
        } catch (NullPointerException e) {
            if(isOpen==false)
            openIncorrectPathWindow();
        }


    }//end of buttonSavePressed

    @FXML
    void buttonUranusPressed(ActionEvent event) {
        keplerEquationSolver = new KeplerEquationSolver(19.191, 0.0472);
        saveAllStepHandler = new SaveAllStepHandler();
        keplerEquationSolver.addStepHandler(saveAllStepHandler);
        labelDistance.setText("19.191");
        labelEccentricity.setText("0.0472");
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonVenusPressed(ActionEvent event) {
        keplerEquationSolver = new KeplerEquationSolver(0.723, 0.0068);
        saveAllStepHandler = new SaveAllStepHandler();
        keplerEquationSolver.addStepHandler(saveAllStepHandler);
        labelDistance.setText("0.723");
        labelEccentricity.setText("0.0068");
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void initialize() {
        assert scatterChart != null : "fx:id=\"scatterChart\" was not injected: check your FXML file 'graph.fxml'.";
        assert labelDistance != null : "fx:id=\"labelDistance\" was not injected: check your FXML file 'graph.fxml'.";
        assert labelEccentricity != null : "fx:id=\"labelEccentricity\" was not injected: check your FXML file 'graph.fxml'.";
        assert buttonSave != null : "fx:id=\"buttonSave\" was not injected: check your FXML file 'graph.fxml'.";
        assert buttonClear != null : "fx:id=\"buttonClear\" was not injected: check your FXML file 'graph.fxml'.";
        assert buttonCalculateTrajectory != null : "fx:id=\"buttonCalculateTrajectory\" was not injected: check your FXML file 'graph.fxml'.";
        assert buttonAnimation != null : "fx:id=\"buttonAnimation\" was not injected: check your FXML file 'graph.fxml'.";
    }

    private void openChooseMethodWindow() {
        try {
            isOpen = true;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ChooseMethodWindow.fxml"));
            Parent root = fxmlLoader.load();

            ChooseMethodController chooseMethodController = fxmlLoader.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/fxml/StylesheetModalWindow.css");
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Choose method to calculate trajectory");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();

            isOpen = false;
            method = chooseMethodController.getMethod();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of openChooseMethodWindow

    private void openChoosePathWindow() {
        try {
            isOpen = true;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ChoosePathWindow.fxml"));
            Parent root = fxmlLoader.load();

            ChoosePathController choosePathController = fxmlLoader.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/fxml/StylesheetChoosePathWindow.css");
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Choose path to save trajectory");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();

            isOpen = false;
            path = choosePathController.getPath();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of openChoosePathWindow

    private void openIncorrectPathWindow() {
        try {
            isOpen = true;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/IncorrectPathWindow.fxml"));
            Parent root = fxmlLoader.load();

            IncorrectPathController incorrectPathController = fxmlLoader.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/fxml/StylesheetIncorrectPathWindow.css");
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Incorrect path");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
            isOpen = false;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of openIncorrectPathWindow

    private void openAnimationWindow(){
        try {
            isOpen = true;

            Ellipse ellipse = new Ellipse();
            ellipse.setCenterX(400);
            ellipse.setCenterY(300);
            ellipse.setRadiusX(250);
            ellipse.setRadiusY(100);
            ellipse.setFill(Color.TRANSPARENT);
            ellipse.setStroke(Color.WHITE);
            ellipse.setStrokeWidth(1);

            Glow glow =new Glow();
            glow.setLevel(10);

            Lighting lighting = new Lighting();

            Circle circle = new Circle(20);
            circle.setFill(Color.valueOf("#321415"));
            circle.setEffect(glow);
            circle.setEffect(lighting);

            PathTransition pathTransition = new PathTransition();
            pathTransition.setNode(circle);
            pathTransition.setPath(ellipse);
            pathTransition.setDuration(Duration.seconds(5));
            pathTransition.setAutoReverse(false);
            pathTransition.setCycleCount(Animation.INDEFINITE);
            pathTransition.play();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AnimationWindow.fxml"));
            Pane root = fxmlLoader.load();
            root.getChildren().addAll(ellipse,circle);

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/fxml/StylesheetAnimationWindow.css");

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Animation");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
            isOpen = false;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}//end of class
