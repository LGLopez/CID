package gd;

public class GradientDescentFormulas {
    // create functions to calculate gradient descent formulas
    private double b0;
    private double b1;
    private double n;
    private double learningRate;
    private DataStorage dataStorage;
    private double error;
    private boolean greaterThanToleranceB0 = false;
    private boolean greaterThanToleranceB1 = false;

    public GradientDescentFormulas() {
        dataStorage = new DataStorage();
        this.b0 = 0; // intercept
        this.b1 = 0; // slope
        this.learningRate = 0.0005;
        this.n = dataStorage.getX().length;
    }

    public double getB0() {
        return b0;
    }

    public void setB0(double b0) {
        this.b0 = b0;
    }

    public double getB1() {
        return b1;
    }

    public void setB1(double b1) {
        this.b1 = b1;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }   // end of getters and setters

    // sum of squared residuales
    public double[] sumOfSquaredResiduals() {
        double b0Gradient = 0;
        double b1Gradient = 0;
        for (int i = 0; i < this.n; i++) {
            b0Gradient -= (2/this.n) * (dataStorage.getY()[i] - (this.b0 + this.b1 * dataStorage.getX()[i]));
            b1Gradient -= (2/this.n) * dataStorage.getX()[i] * (dataStorage.getY()[i] - (this.b0 + this.b1 * dataStorage.getX()[i]));
        }
        // step size calculation
        double stepSizeB0 = this.learningRate * b0Gradient;
        double stepSizeB1 = this.learningRate * b1Gradient;
        double[] stepSize = {stepSizeB0, stepSizeB1};
        return stepSize;
    }

    // calculate new intercept
    public void calculateNewB0AndB1() {
        double stepSizeB0 = this.sumOfSquaredResiduals()[0];
        double stepSizeB1 = this.sumOfSquaredResiduals()[1];
        this.greaterThanToleranceB0 = Math.abs(stepSizeB0) < 0.0001; // may be changed to 0.00001
        this.greaterThanToleranceB1 = Math.abs(stepSizeB1) < 0.0001; // may be changed to 0.00001
        this.b0 = this.b0 - stepSizeB0;
        this.b1 = this.b1 - stepSizeB1;
        // System.out.println("new b0: " + this.b0);
        // System.out.println("new b1: " + this.b1);
    }
    
    public void generateModel() {
        for(int i = 0; i < 400000 && (!this.greaterThanToleranceB0 || !this.greaterThanToleranceB1); i++) {
            this.calculateNewB0AndB1();
        }
        System.out.println("final b0: " + this.b0);
        System.out.println("final b1: " + this.b1);
    }

    public void predictY(double x) {
        double y = this.b0 + this.b1 * x;
        System.out.println("predicted y: " + y);
    }
}
