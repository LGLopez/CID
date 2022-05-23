package lr;

public class LogisticRegressionFormulas {
    double w0;
    double w1;
    double w2;
    double learningRate;
    double[] wArray = { 0, 0, 0 };
    double[][] trainingSet = {
            { 1, 1, 1, 0 },
            { 1, 4, 2, 1 },
            { 1, 2, 4, 1 }
    };

    public LogisticRegressionFormulas() {
        this.w0 = 0;
        this.w1 = 0;
        this.w2 = 0;
        this.learningRate = 0.1;
    }

    public LogisticRegressionFormulas(double w0, double w1, double w2) {
        this.w0 = w0;
        this.w1 = w1;
        this.w2 = w2;
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

    public double getSigmoid() {
        // sigmoid function
        // get the correct value from the training set
        double x = this.w0 + (this.w1 * this.trainingSet[0][0]) + (this.w2 * this.trainingSet[0][1]);
        double sigmoid = 1 / (1 + Math.exp(-x));
        return sigmoid;
    }

    public void calculateGradientDescent(double w, int j) {
        double sum = 0;
        for(int i = 0; i < trainingSet.length; i++) {
            sum += (trainingSet[i][3] - getSigmoid() ) * trainingSet[i][j];
        }
        wArray[j] = w - (learningRate * sum);
        System.out.println("w" + j + ": " + wArray[j]);
    }

    public void generateModel() {
        for(int i =0; i<100; i++) {
            calculateGradientDescent(wArray[0], 0);
            calculateGradientDescent(wArray[1], 1);
            calculateGradientDescent(wArray[2], 2);
            reasignWeights(wArray[0], wArray[1], wArray[2]);
        }
    }

}
