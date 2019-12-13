package edu.ib;

import java.util.ArrayList;
import java.util.List;

public class SaveAllStepHandler implements StepHandler {

    List<Double> yValues = new ArrayList<>();
    List<Double> xValues = new ArrayList<>();

    @Override
    public void handleStep(double y, double x) {
        yValues.add(y);
        xValues.add(x);
    }//end of handleStep
}//end of class
