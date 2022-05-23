package knn;

public class DataStorage {
    Sepal[] sepal;
    String[] species = {"setosa", "setosa", "virginica", "setosa", "setosa", "setosa", "virginica", "versicolor", "virginica", "versicolor", "virginica",  "versicolor",  "versicolor",  "versicolor",  "versicolor"};
    double[] length = {5.3, 5.1, 7.2, 5.4, 5.1, 5.4, 7.4, 6.1, 7.3, 6.0, 5.8, 6.3, 5.1, 6.3, 5.5};
    double[] width  = {3.7, 3.8, 3.0, 3.4, 3.3, 3.9, 2.8, 2.8, 2.9, 2.7, 2.8, 2.3, 2.5, 2.5, 2.4};

    public DataStorage() {
        if(species.length == length.length && species.length == width.length) {
            sepal = new Sepal[species.length];
            for(int i = 0; i < species.length; i++) {
                sepal[i] = new Sepal(length[i], width[i], species[i]);
            }
        }
    }
    
    public Sepal[] getSepal() {
        return sepal;
    }

    public String[] getSpecies() {
        return species;
    }

    public double[] getLength() {
        return length;
    }

    public double[] getWidth() {
        return width;
    }

    public void setSepal(Sepal[] sepal) {
        this.sepal = sepal;
    }

    public void setSpecies(String[] species) {
        this.species = species;
    }

    public void setLength(double[] length) {
        this.length = length;
    }

    public void setWidth(double[] width) {
        this.width = width;
    }
}
