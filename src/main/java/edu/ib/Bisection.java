package edu.ib;

public class Bisection {
    private double xl;
    private double xu;
    private double relativeError;
    private int maxIteration;
    private Function function;

    public Bisection(double xl, double xu, double relativeError, int maxIteration, Function function) {
        this.xl = xl;
        this.xu = xu;
        this.relativeError = relativeError;
        this.maxIteration = maxIteration;
        this.function = function;
    }

    public double solver() {
        int i = 0;
        double ea;
        double xr = 0;
        double[] xrs = new double[maxIteration];

        do {
            xr = (xl+xu)/2;
            xrs[i] = xr;


            if (function.function(xl) * function.function(xr) < 0)
                xu = xr;

            else if (function.function(xr) * function.function(xu) < 0)
                xl = xr;
            else
                i = maxIteration-1;

            if(i!=0) {
                ea = Math.abs((xrs[i] - xrs[i - 1]) / xrs[i] * 100);
            }
            else {
                ea = Math.abs((xrs[i] - 0) / xrs[i] * 100);
            }
            i++;

        } while (i < maxIteration && ea >= relativeError);

        return xr;
    }//end of solver

}//end of RegulaFalsi

