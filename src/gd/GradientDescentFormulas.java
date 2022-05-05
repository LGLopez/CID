package gd;

public class GradientDescentFormulas {
    // create functions to calculate gradient descent formulas
    private double b0;
    private double b1;
    private double n;
    private double learningRate;
    private DataStorage dataStorage;
    private double error;

    public GradientDescentFormulas(double x) {
        dataStorage = new DataStorage();
        this.b0 = 0;
        this.b1 = 0;
        this.learningRate = 0.001;
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

    public double getYHat(double x) {
        // yHat = a + bx
        return this.b0 + this.b1*x;
    }

    // calculate the loss function
    public double calculateLossFunction() {
        // error = 1/n * sum(y - y_hat)^2
        double error = 0;
        double temp = 0;
        for (int i = 0; i < this.n; i++) {
            double xi = dataStorage.getX()[i];
            temp = dataStorage.getY()[i]-getYHat(xi);
        }
        error += Math.pow(temp, 2);
        error = error/this.n;
        System.out.println("error = " + error);
        return error;
    }

    // calculate the gradient descent formula for b0
    public double calculateB0() {
        // b0 = b0 - (learningRate * (1/n) * sum(y - y_hat))
        double b0 = this.b0 - this.learningRate * (-(2/this.n) * calculateLossFunction());
        System.out.println("b0: " + b0);
        return b0;
    }

    // calculate the gradient descent formula for b1
    public double calculateB1() {
        // b1 = b1 - learningRate * (1/n) * sum(y - y_hat)
        double b1 = this.b1 - this.learningRate * (1/n) * calculateLossFunction();
        System.out.println("b1: " + b1);
        return b1;
    }

    // calculate the gradient descent formula for b0 and b1
    public void calculateB0AndB1() {
        // b0 = b0 - (learningRate * (1/n) * sum(y - y_hat))
        // b1 = b1 - learningRate * (1/n) * sum(y - y_hat)
        this.b0 = this.b0 - this.learningRate * calculateLossFunction();
        this.b1 = this.b1 - this.learningRate * calculateLossFunction();
        System.out.println("b0: " + this.b0);
        System.out.println("b1: " + this.b1);
    }

    public void main() {
        // calculate the gradient descent formula for b0 and b1
        for (int i = 0; i < 10; i++) {
            calculateB0AndB1();
        }
    }
}
