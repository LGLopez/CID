package lr;

public class DataStorage {
    // public static double[][] trainingSet = {
    //     {1, 1, 0},
    //     {4, 2, 1},
    //     {2, 4, 1}
    // };
    
    public static double[][] trainingSet = {
        {1, 1, 1, 0},
        {1, 4, 2, 1},
        {1, 2, 4, 1}
    };

    public double[][] getTrainingSet() {
        return trainingSet;
    }
}
