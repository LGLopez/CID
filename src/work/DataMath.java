package work;

public class DataMath {
    private DataStorage dataStorage;
    DataMath() {
        dataStorage = new DataStorage();
    }

    public int[] getStorageX() {
        return dataStorage.getX();
    }

    public int[] getStorageY() {
        return dataStorage.getY();
    }

    public double[] getXYMultiply() {
        int[] x = getStorageX();
        int[] y = getStorageY();
        double[] xy = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            xy[i] = x[i] * y[i];
            // System.out.println("xy[" + i + "]: " + xy[i]);
        }
        return xy;
    }
    
    public double[] getXPower2(){
        int[] x = getStorageX();
        double[] x2 = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            x2[i] = x[i] * x[i];
            // System.out.println("x2[" + i + "]: " + x2[i]);
        }
        return x2;
    }

    public double[] getYPower2(){
        int[] y = getStorageY();
        double[] y2 = new double[y.length];
        for (int i = 0; i < y.length; i++) {
            y2[i] = y[i] * y[i];
            // System.out.println("y2[" + i + "]: " + y2[i]);
        }
        return y2;
    }

    public double getSumX() {
        int[] x = getStorageX();
        double sumX = 0;
        for (int i = 0; i < x.length; i++) {
            sumX += x[i];
        }
        // System.out.println("sumX: " + sumX);
        return sumX;
    }

    public double getSumY() {
        int[] y = getStorageY();
        double sumY = 0;
        for (int i = 0; i < y.length; i++) {
            sumY += y[i];
        }
        // System.out.println("sumY: " + sumY);
        return sumY;
    }

    public double getSumXYMultiplied() {
        double[] xy = getXYMultiply();
        double sumXY = 0;
        for (int i = 0; i < xy.length; i++) {
            sumXY += xy[i];
        }
        // System.out.println("sumXY: " + sumXY);
        return sumXY;
    }

    public double getSumXPower2(){
        double[] x2 = getXPower2();
        double sumX2 = 0;
        for (int i = 0; i < x2.length; i++) {
            sumX2 += x2[i];
        }
        // System.out.println("sumX2: " + sumX2);
        return sumX2;
    }

    public double getSumYPower2(){
        double[] y2 = getYPower2();
        double sumY2 = 0;
        for (int i = 0; i < y2.length; i++) {
            sumY2 += y2[i];
        }
        // System.out.println("sumY2: " + sumY2);
        return sumY2;
    }

    public double getN() {
        int[] x = getStorageX();
        // System.out.println("N: " + x.length);
        return x.length;
    }
}
