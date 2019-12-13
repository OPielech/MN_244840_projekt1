package edu.ib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    KeplerEquationSolver keplerEquationSolver;
    SaveAllStepHandler saveAllStepHandler;
    Double distance;
    Double eccentricity;
    String id;

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
    void buttonBisectionPressed(ActionEvent event) {

        distance = Double.valueOf(labelDistance.getText());
        eccentricity = Double.valueOf(labelEccentricity.getText());

        keplerEquationSolver=new KeplerEquationSolver(distance,eccentricity);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverBisection());

    }//end of buttonBisectionPressed

    @FXML
    void buttonClearPressed(ActionEvent event) {
//        series.getData().clear();
        scatterChart.getData().clear();
    }//end of buttonClearPressed

    @FXML
    void buttonEarthPressed(ActionEvent event) {

        keplerEquationSolver=new KeplerEquationSolver(1,0.0167);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }//end of buttonEarthPressed

    @FXML
    void buttonFixedPointsIterationPressed(ActionEvent event) {

        distance = Double.valueOf(labelDistance.getText());
        eccentricity = Double.valueOf(labelEccentricity.getText());

        keplerEquationSolver=new KeplerEquationSolver(distance,eccentricity);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverFixedPointsIteration());
    }//end of buttonFixedPointsIterationPressed

    @FXML
    void buttonJupiterPressed(ActionEvent event) {
        keplerEquationSolver=new KeplerEquationSolver(5.203,0.0484);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonMarsPressed(ActionEvent event) {
        keplerEquationSolver=new KeplerEquationSolver(1.524,0.0934);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonMercuryPressed(ActionEvent event) {
        keplerEquationSolver=new KeplerEquationSolver(0.387,0.2056);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonNeptunePressed(ActionEvent event) {
        keplerEquationSolver=new KeplerEquationSolver(30.069,0.0086);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonNewtonRaphsonMethodPressed(ActionEvent event) throws InterruptedException {
        distance = Double.valueOf(labelDistance.getText());
        eccentricity = Double.valueOf(labelEccentricity.getText());

        keplerEquationSolver=new KeplerEquationSolver(distance,eccentricity);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverNewtonRaphsonMethod());

    }//end of buttonNewtonRaphsonMethodPressed

    @FXML
    void buttonPlutoPressed(ActionEvent event) {
        keplerEquationSolver=new KeplerEquationSolver(39.482,0.2488);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonSaturnPressed(ActionEvent event) {
        keplerEquationSolver=new KeplerEquationSolver(9.537,0.0542);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonSavePressed(ActionEvent event) throws FileNotFoundException {
        File file = new File("Trajectory.txt");
        PrintWriter printWriter = new PrintWriter(file);

        printWriter.println("x values:");
        for (int i=0; i<saveAllStepHandler.xValues.size();i++){
            printWriter.println(saveAllStepHandler.xValues.get(i));
        }

        printWriter.println("\ny values:");
        for (int i=0; i<saveAllStepHandler.yValues.size();i++){
            printWriter.println(saveAllStepHandler.yValues.get(i));
        }
        printWriter.close();

    }//end of buttonSavePressed

    @FXML
    void buttonSecandMethodPressed(ActionEvent event) {
        distance = Double.valueOf(labelDistance.getText());
        eccentricity = Double.valueOf(labelEccentricity.getText());

        keplerEquationSolver = new KeplerEquationSolver(distance,eccentricity);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverSecandMethod());

    }//end of buttonSecandMethodPressed

    @FXML
    void buttonUranusPressed(ActionEvent event) {
        keplerEquationSolver=new KeplerEquationSolver(19.191,0.0472);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void buttonVenusPressed(ActionEvent event) {
        keplerEquationSolver=new KeplerEquationSolver(0.723,0.0068);
        saveAllStepHandler=new SaveAllStepHandler();
        keplerEquationSolver.addSteoHandler(saveAllStepHandler);
        scatterChart.getData().add(keplerEquationSolver.solverBisection());
    }

    @FXML
    void initialize() {
        assert scatterChart != null : "fx:id=\"scatterChart\" was not injected: check your FXML file 'graph.fxml'.";
        assert buttonBisection != null : "fx:id=\"buttonBisection\" was not injected: check your FXML file 'graph.fxml'.";
        assert buttonFixedPointsIteration != null : "fx:id=\"buttonFixedPointsIteration\" was not injected: check your FXML file 'graph.fxml'.";
        assert buttonNewtonRaphsonMethod != null : "fx:id=\"buttonNewtonRaphsonMethod\" was not injected: check your FXML file 'graph.fxml'.";
        assert buttonSecandMethod != null : "fx:id=\"buttonSecandMethod\" was not injected: check your FXML file 'graph.fxml'.";
        assert labelDistance != null : "fx:id=\"labelDistance\" was not injected: check your FXML file 'graph.fxml'.";
        assert labelEccentricity != null : "fx:id=\"labelEccentricity\" was not injected: check your FXML file 'graph.fxml'.";
        assert buttonSave != null : "fx:id=\"buttonSave\" was not injected: check your FXML file 'graph.fxml'.";
        assert buttonClear != null : "fx:id=\"buttonClear\" was not injected: check your FXML file 'graph.fxml'.";

    }
}
