package lr;

public class LogisticRegressionFormulas {
    double w0;
    double w1;
    double w2;
    double learningRate;
    double[] wArray = {0, 0, 0};
    double[][] trainingSet = {
        {1, 1, 1, 0},
        {1, 4, 2, 1},
        {1, 2, 4, 1}
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

    public double getGradient(int i) {
        double gradient = 0;

        gradient += (1 / (1 + Math.exp(-(this.w0 + this.w1 * this.trainingSet[i][0] + this.w2 * this.trainingSet[i][1])))) - this.trainingSet[i][2];

        System.out.println("Gradient: " + gradient);
        return gradient;
    }

    public double getNewW(double w, int i) {
        double newW = w - (this.learningRate * getGradient(i));
        System.out.println("New W: " + newW);
        return newW;
    }
    
    public void generateModel() {
        // for (int j = 0; j < 100; j++) {
            for (int i = 0; i < wArray.length; i++) {
                wArray[i] = getNewW(wArray[i], i);
            }
        // }
        // print w0, w1, w2
        System.out.println("w0 = " + wArray[0]);
        System.out.println("w1 = " + wArray[1]);
        System.out.println("w2 = " + wArray[2]);
        
        // this.w1 = getNewW(this.w1);
        // this.w2 = getNewW(this.w2);
    }

}
