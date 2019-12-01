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
    XYChart.Series series = new XYChart.Series();
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
        id = buttonBisection.getId();

        String text = labelDistance.getText();
        Double distance = Double.valueOf(text);
        distance *= 1.495978707 * Math.pow(10, 11);

        String text1 = labelEccentricity.getText();
        Double eccentricity = Double.valueOf(text1);

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
    }//end of buttonBisectionPressed

    @FXML
    void buttonClearPressed(ActionEvent event) {
        series.getData().clear();
        scatterChart.getData().clear();
    }//end of buttonClearPressed

    @FXML
    void buttonEarthPressed(ActionEvent event) {
        id = buttonEarth.getId();
        Double distance = 1.0;
        distance *= 1.495978707 * Math.pow(10, 11);

        Double eccentricity = 0.0167;

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
    }//end of buttonEarthPressed

    @FXML
    void buttonFixedPointsIterationPressed(ActionEvent event) {
        id = buttonFixedPointsIteration.getId();

        String text = labelDistance.getText();
        Double distance = Double.valueOf(text);
        distance *= 1.495978707 * Math.pow(10, 11);

        String text1 = labelEccentricity.getText();
        Double eccentricity = Double.valueOf(text1);

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new FixedPointsIteration(10, 0.001, 1000, x -> m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
    }//end of buttonFixedPointsIterationPressed

    @FXML
    void buttonJupiterPressed(ActionEvent event) {
        id = buttonJupiter.getId();
        Double distance = 5.203;
        distance *= 1.495978707 * Math.pow(10, 11);

        Double eccentricity = 0.0484;

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
    }

    @FXML
    void buttonMarsPressed(ActionEvent event) {
        id = buttonMars.getId();
        Double distance = 1.524;
        distance *= 1.495978707 * Math.pow(10, 11);

        Double eccentricity = 0.0934;

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
    }

    @FXML
    void buttonMercuryPressed(ActionEvent event) {
        id = buttonMercury.getId();
        Double distance = 0.387;
        distance *= 1.495978707 * Math.pow(10, 11);

        Double eccentricity = 0.2056;

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
    }

    @FXML
    void buttonNeptunePressed(ActionEvent event) {
        id = buttonNeptune.getId();
        Double distance = 30.069;
        distance *= 1.495978707 * Math.pow(10, 11);

        Double eccentricity = 0.0086;

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
    }

    @FXML
    void buttonNewtonRaphsonMethodPressed(ActionEvent event) throws InterruptedException {
        id = buttonNewtonRaphsonMethod.getId();

        String text = labelDistance.getText();
        Double distance = Double.valueOf(text);
        distance *= 1.495978707 * Math.pow(10, 11);

        String text1 = labelEccentricity.getText();
        Double eccentricity = Double.valueOf(text1);

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new NewtonRaphsonMethod(10, 0.001, 1000, x -> m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));

        }//end of for

        scatterChart.getData().add(series);
    }//end of buttonNewtonRaphsonMethodPressed

    @FXML
    void buttonPlutoPressed(ActionEvent event) {
        id = buttonPluto.getId();
        Double distance = 39.482;
        distance *= 1.495978707 * Math.pow(10, 11);

        Double eccentricity = 0.2488;

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
    }

    @FXML
    void buttonSaturnPressed(ActionEvent event) {
        id = buttonSaturn.getId();
        Double distance = 9.537;
        distance *= 1.495978707 * Math.pow(10, 11);

        Double eccentricity = 0.0542;

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
    }

    @FXML
    void buttonSavePressed(ActionEvent event) throws FileNotFoundException {
        File file = new File("Trajectory.txt");
        PrintWriter printWriter = new PrintWriter(file);

        if (id.equals(buttonMercury.getId())) {
            Double distance = 0.387;
            distance *= 1.495978707 * Math.pow(10, 11);

            Double eccentricity = 0.2056;

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
            printWriter.close();
        } else if (id.equals(buttonVenus.getId())) {
            Double distance = 0.0723;
            distance *= 1.495978707 * Math.pow(10, 11);

            Double eccentricity = 0.0068;

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
            printWriter.close();
        } else if (id.equals(buttonEarth.getId())) {
            Double distance = 1.0;
            distance *= 1.495978707 * Math.pow(10, 11);

            Double eccentricity = 0.0167;

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
            printWriter.close();
        } else if (id.equals(buttonMars.getId())) {
            Double distance = 1.524;
            distance *= 1.495978707 * Math.pow(10, 11);

            Double eccentricity = 0.0934;

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
            printWriter.close();
        } else if (id.equals(buttonJupiter.getId())) {
            Double distance = 5.203;
            distance *= 1.495978707 * Math.pow(10, 11);

            Double eccentricity = 0.0484;

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
            printWriter.close();
        } else if (id.equals(buttonSaturn.getId())) {
            Double distance = 9.537;
            distance *= 1.495978707 * Math.pow(10, 11);

            Double eccentricity = 0.0542;

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
            printWriter.close();
        } else if (id.equals(buttonUranus.getId())) {
            Double distance = 19.191;
            distance *= 1.495978707 * Math.pow(10, 11);

            Double eccentricity = 0.0472;

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
            printWriter.close();
        } else if (id.equals(buttonNeptune.getId())) {
            Double distance = 30.069;
            distance *= 1.495978707 * Math.pow(10, 11);

            Double eccentricity = 0.0086;

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
            printWriter.close();
        } else if (id.equals(buttonPluto.getId())) {
            Double distance = 39.482;
            distance *= 1.495978707 * Math.pow(10, 11);

            Double eccentricity = 0.2488;

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
            printWriter.close();
        } else if (id.equals(buttonBisection.getId())) {
            String text = labelDistance.getText();
            Double distance = Double.valueOf(text);

            String text1 = labelEccentricity.getText();
            Double eccentricity = Double.valueOf(text1);

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
            printWriter.close();
        } else if (id.equals(buttonFixedPointsIteration.getId())) {
            String text = labelDistance.getText();
            Double distance = Double.valueOf(text);

            String text1 = labelEccentricity.getText();
            Double eccentricity = Double.valueOf(text1);

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new FixedPointsIteration(10, 0.001, 1000, x -> m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
        } else if (id.equals(buttonNewtonRaphsonMethod.getId())) {
            String text = labelDistance.getText();
            Double distance = Double.valueOf(text);

            String text1 = labelEccentricity.getText();
            Double eccentricity = Double.valueOf(text1);

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new NewtonRaphsonMethod(10, 0.001, 1000, x -> m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
        } else if (id.equals(buttonSecandMethod.getId())) {
            String text = labelDistance.getText();
            Double distance = Double.valueOf(text);

            String text1 = labelEccentricity.getText();
            Double eccentricity = Double.valueOf(text1);

            for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
                double m = i;
                double E = new SecandMethod(10, 0.001, 1000, x -> m + eccentricity * x - x).solver();
                double x = distance * Math.cos(E - eccentricity);
                double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
                printWriter.println("x: " + x + " y: " + y);
            }//end of for
        }
    }//end of buttonSavePressed

    @FXML
    void buttonSecandMethodPressed(ActionEvent event) {
        id = buttonSecandMethod.getId();

        String text = labelDistance.getText();
        Double distance = Double.valueOf(text);
        distance *= 1.495978707 * Math.pow(10, 11);

        String text1 = labelEccentricity.getText();
        Double eccentricity = Double.valueOf(text1);

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new SecandMethod(10, 0.001, 1000, x -> m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
    }//end of buttonSecandMethodPressed

    @FXML
    void buttonUranusPressed(ActionEvent event) {
        id = buttonUranus.getId();
        Double distance = 19.191;
        distance *= 1.495978707 * Math.pow(10, 11);

        Double eccentricity = 0.0472;

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
    }

    @FXML
    void buttonVenusPressed(ActionEvent event) {
        id = buttonVenus.getId();
        Double distance = 0.723;
        distance *= 1.495978707 * Math.pow(10, 11);

        Double eccentricity = 0.0068;

        for (double i = 0.01; i <= 2 * Math.PI; i += 0.01) {
            double m = i;
            double E = new Bisection(-50, 100, 0.001, 1000, x -> x = m + eccentricity * x - x).solver();
            double x = distance * Math.cos(E - eccentricity);
            double y = distance * Math.sqrt(1 - Math.pow(eccentricity, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x, y));
        }//end of for

        scatterChart.getData().add(series);
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
