package edu.ib;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;


public class KeplerEquationSolver{
    private double distance;
    private double eccentricity;
    StepHandler stepHandler;


    public KeplerEquationSolver(double distance, double eccentricity) {
        this.distance = distance;
        this.eccentricity = eccentricity;
    }

    public void addStepHandler(StepHandler stepHandler){
        this.stepHandler=stepHandler;
    }

    public XYChart.Series solverBisection() {
        XYChart.Series series = new XYChart.Series();
        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {

            double m = i;
            double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            stepHandler.handleStep(x,y);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for
        return series;
    }//end of solverBisection

    public XYChart.Series solverFixedPointsIteration() {
        XYChart.Series series = new XYChart.Series();
        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {

            double m = i;
            double E = new FixedPointsIteration(10, 0.001, 1000, x -> m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            stepHandler.handleStep(x,y);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for
        return series;
    }//end solverFixedPointsIteration

    public XYChart.Series solverNewtonRaphsonMethod(){
        XYChart.Series series = new XYChart.Series();

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new NewtonRaphsonMethod(10, 0.001, 1000, x -> m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            stepHandler.handleStep(x,y);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        return series;
    }//end of solverNewtonRaphsonMethod

    public XYChart.Series solverSecandMethod(){
        XYChart.Series series = new XYChart.Series();

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new SecandMethod(10, 0.001, 1000, x -> m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            stepHandler.handleStep(x,y);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        return series;
    }//end of solverSecandMethod

}//end of KeplerEquation
