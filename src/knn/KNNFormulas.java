package knn;

public class KNNFormulas {
    DataStorage dataStorage;
    Sepal predictSepal;
    int k;
    double[] distances;
    
    public KNNFormulas(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
        distances = new double[dataStorage.getSpecies().length];
    }

    public KNNFormulas() {
        k = 5;
        this.dataStorage = new DataStorage();
        distances = new double[dataStorage.getSpecies().length];
        // predictSepal = new Sepal(5.2, 3.1, "");
    }

    public double[] getDistancesSorted() {
        double[] distancesSorted = new double[distances.length];
        for(int i = 0; i < distances.length; i++) {
            distancesSorted[i] = distances[i];
        }
        for (int i = 0; i < distances.length; i++) {
            for (int j = i + 1; j < distances.length; j++) {
                if (distancesSorted[i] > distancesSorted[j]) {
                    double temp = distancesSorted[i];
                    distancesSorted[i] = distancesSorted[j];
                    distancesSorted[j] = temp;
                }
            }
        }
        return distancesSorted;
    }

    public void classifyAccordingToK() {
        double[] kArray = new double[k];
        String[] kSpecies = new String[k];
        double[] distancesSorted = getDistancesSorted();
    
        for(int i = 0; i < kArray.length; i++) {
            kArray[i] = distancesSorted[i];
        }

        // find kArray values in distances array
        for(int i = 0; i < distances.length; i++) {
            for(int j = 0; j < kArray.length; j++) {
                if(distances[i] == kArray[j]) {
                    kSpecies[j] = dataStorage.getSpecies()[i];
                }
            }
        }
        // print kSpecies
        // for(int i = 0; i < kSpecies.length; i++) {
        //     System.out.println(kSpecies[i]);
        // }

        // count kSpecies occurrences
        int[] kSpeciesCount = new int[k];
        for(int i = 0; i < kSpecies.length; i++) {
            for(int j = 0; j < kSpecies.length; j++) {
                if(kSpecies[i] == kSpecies[j]) {
                    kSpeciesCount[i]++;
                }
            }
        }

        // find most common species
        int max = 0;
        for(int i = 0; i < kSpeciesCount.length; i++) {
            if(kSpeciesCount[i] > max) {
                max = kSpeciesCount[i];
            }
        }

        // print most common species
        // System.out.println("Most common species:");
        for(int i = 0; i < kSpeciesCount.length; i++) {
            if(kSpeciesCount[i] == max) {
                // System.out.println(kSpecies[i]);
                this.predictSepal.setSpecies(kSpecies[i]);
                break;
            }
        }
    }

    public void generateModelAndPredict(double length, double width) {
        this.predictSepal = new Sepal(length, width, "");
        
        euclideanDistance(this.predictSepal, this.dataStorage.getSepal());
        classifyAccordingToK();

        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Predicted species: " + this.predictSepal.getSpecies());
    }

    public void euclideanDistance(Sepal sepal, Sepal[] sepalArray) {
        for (int i = 0; i < sepalArray.length; i++) {
            double distance = 0;
            distance += Math.pow(sepal.getLength() - sepalArray[i].getLength(), 2);
            distance += Math.pow(sepal.getWidth() - sepalArray[i].getWidth(), 2);
            this.distances[i] = Math.sqrt(distance);
        }
    }
}
