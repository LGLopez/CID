package knn;

public class Sepal {
    private double length;
    private double width;
    private String species;

    public Sepal(double length, double width, String species) {
        this.length = length;
        this.width = width;
        this.species = species;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Sepal{" + "length=" + length + ", width=" + width + ", species=" + species + '}';
    }
}
