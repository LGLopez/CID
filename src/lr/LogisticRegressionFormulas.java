package lr;

public class LogisticRegressionFormulas {
    double w0;
    double w1;
    double w2;
    double learningRate;
    double[] wArray = { 0, 0, 0 };
    DataStorage ds;
    double[][] trainingSet;

    public LogisticRegressionFormulas() {
        ds = new DataStorage();
        this.w0 = 0;
        this.w1 = 0;
        this.w2 = 0;
        this.learningRate = 0.1;
        this.trainingSet = ds.getTrainingSet();
    }

    public double getW0() {
        return w0;
    }

    public double getW1() {
        return w1;
    }

    public double getW2() {
        return w2;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void reasignWeights(double w0, double w1, double w2) {
        this.w0 = w0;
        this.w1 = w1;
        this.w2 = w2;
    }

    public double getSigmoid(double[] xArray) {
        // sigmoid function
        // get the correct value from the training set
        double x = this.w0 + (this.w1 * xArray[0]) + (this.w2 * xArray[1]);
        double sigmoid = 1 / (1 + Math.exp(-x));
        return sigmoid;
    }

    public void calculateGradientDescent(double w, int j) {
        double sum = 0;
        for(int i = 0; i < trainingSet.length; i++) {
            double[] x = { trainingSet[i][1], trainingSet[i][2] };
            sum += (trainingSet[i][3] - getSigmoid(x) ) * trainingSet[i][j];
        }
        wArray[j] = w + (learningRate * sum);
        // System.out.println("w" + j + ": " + wArray[j]);
    }

    public void generateModel() {
        for(int i =0; i<100; i++) {
            calculateGradientDescent(wArray[0], 0);
            calculateGradientDescent(wArray[1], 1);
            calculateGradientDescent(wArray[2], 2);
            reasignWeights(wArray[0], wArray[1], wArray[2]);
        }
        System.out.println("Final w0: " + wArray[0]);
        System.out.println("Final w1: " + wArray[1]);
        System.out.println("Final w2: " + wArray[2]);
    }

    public void predictY(double x1, double x2) {
        double[] x = { x1, x2 };
        double sigmoid = getSigmoid(x);
        System.out.println("Sigmoid: " + sigmoid);
    }
}
