package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ModalController {
    private String method;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBisection;

    @FXML
    private Button buttonFixedPointsIteration;

    @FXML
    private Button buttonNewtonRaphsonMethod;

    @FXML
    private Button buttonSecandMethod;

    @FXML
    void buttonBisectionPressed(ActionEvent event) {

        method="Bisection method";
        Stage stage = (Stage) buttonBisection.getScene().getWindow();
        stage.close();

    }

    @FXML
    void buttonFixedPointsIterationPressed(ActionEvent event) {
        method="Fixed points iteration";
        Stage stage = (Stage) buttonBisection.getScene().getWindow();
        stage.close();
    }

    @FXML
    void buttonNewtonRaphsonMethodPressed(ActionEvent event) {
        method="Newton Raphson";
        Stage stage = (Stage) buttonBisection.getScene().getWindow();
        stage.close();
    }

    @FXML
    void buttonSecandMethodPressed(ActionEvent event) {
        method="Secand method";
        Stage stage = (Stage) buttonBisection.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert buttonBisection != null : "fx:id=\"buttonBisection\" was not injected: check your FXML file 'ChooseMethodWindow.fxml'.";
        assert buttonFixedPointsIteration != null : "fx:id=\"buttonFixedPointsIteration\" was not injected: check your FXML file 'ChooseMethodWindow.fxml'.";
        assert buttonNewtonRaphsonMethod != null : "fx:id=\"buttonNewtonRaphsonMethod\" was not injected: check your FXML file 'ChooseMethodWindow.fxml'.";
        assert buttonSecandMethod != null : "fx:id=\"buttonSecandMethod\" was not injected: check your FXML file 'ChooseMethodWindow.fxml'.";

    }


    public String getMethod(){
        return method;
    }
}//end of class
