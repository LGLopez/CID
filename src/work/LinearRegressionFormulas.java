package work;

public class LinearRegressionFormulas {
    DataMath dataMath;

    LinearRegressionFormulas() {
        dataMath = new DataMath();
    }

    public double getB(){
        // b = (n*sumXY - sumX*sumY) / (n*sumX2 - sumX*sumX)
        double n = dataMath.getStorageX().length;
        double sumXY = dataMath.getSumXYMultiplied();
        double sumX = dataMath.getSumX();
        double sumY = dataMath.getSumY();
        double sumX2 = dataMath.getSumXPower2();
        double b = (n*sumXY - sumX*sumY) / (n*sumX2 - sumX*sumX);
        System.out.println("b: " + b);
        return b;
    }

    public double getA(){
        // a = (sumY * sumX2 - sumX * sumXY) / (n*sumX2 - sumX*sumX)
        double n = dataMath.getStorageX().length;
        double sumXY = dataMath.getSumXYMultiplied();
        double sumX = dataMath.getSumX();
        double sumY = dataMath.getSumY();
        double sumX2 = dataMath.getSumXPower2();
        double a = (sumY * sumX2 - sumX * sumXY) / (n*sumX2 - sumX*sumX);
        System.out.println("a: " + a);
        return a;
    }

    public double getR(){
        // r = (n*sumXY - sumX*sumY) / (Math.sqrt(n*sumX2 - sumX*sumX)*Math.sqrt(n*sumY2 - sumY*sumY))
        double n = dataMath.getStorageX().length;
        double sumXY = dataMath.getSumXYMultiplied();
        double sumX = dataMath.getSumX();
        double sumY = dataMath.getSumY();
        double sumX2 = dataMath.getSumXPower2();
        double sumY2 = dataMath.getSumYPower2();
        double r = (n*sumXY - sumX*sumY) / (Math.sqrt(n*sumX2 - sumX*sumX)*Math.sqrt(n*sumY2 - sumY*sumY));
        // System.out.println("r: " + r);
        return r;
    }

    public double getY(double x){
        // y = a + bx
        double a = getA();
        double b = getB();
        double y = a + b*x;
        System.out.println("y: " + y);
        return y;
    }
}
