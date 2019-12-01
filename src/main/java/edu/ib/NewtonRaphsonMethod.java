package edu.ib;

public class NewtonRaphsonMethod {
    private double x0;
    private double relativeError;
    private int maxIteration;
    private Function function;

    public NewtonRaphsonMethod(double x0, double relativeError, int maxIteration, Function function) {
        this.x0 = x0;
        this.relativeError = relativeError;
        this.maxIteration = maxIteration;
        this.function = function;
    }

    public double solver() {

        int i = 1;
        double ea;
        double xn = x0 - function.function(x0) / (-Math.exp(-x0) - 1);
        double xn1;
        double[] xns = new double[maxIteration];
        xns[0] = xn;

        do {
            xn1 = xn - function.function(xn) / (-Math.exp(-xn) - 1);
            xns[i] = xn1;
            xn = xn1;

            ea = Math.abs((xns[i] - xns[i - 1]) / xns[i] * 100);
            i++;
        } while (i < maxIteration && ea >= relativeError);

        return xn;
    }//end of solver
}//end of class
