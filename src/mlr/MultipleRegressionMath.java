package mlr;

public class MultipleRegressionMath {
    DataStorage dataStorage;
    DataHelperMatrix dataHelperMatrix;

    MultipleRegressionMath(){
        dataHelperMatrix = new DataHelperMatrix();
        dataStorage = new DataStorage();
    }

    public double[] getXValuesMLR(){
        double[] x1 = dataStorage.getX1();
        double[] x2 = dataStorage.getX2();
        double[] y = dataStorage.getY();

        double[][] matrixJoined = dataHelperMatrix.joinArrays(x1, x2);
        double[][] matrixTranspose = dataHelperMatrix.transposeMatrix(matrixJoined);
        double[] matrixByVector = dataHelperMatrix.multiplyMatrixWithVector(matrixTranspose, y);
        double[][] matrixTransposeByMatrix = dataHelperMatrix.multiplyMatrixWithMatrix(matrixTranspose, matrixJoined);
        double[][] matrixTransposeByMatrixInverse = dataHelperMatrix.inverseMatrix(matrixTransposeByMatrix);
        double[] matrixByVectorInverse = dataHelperMatrix.multiplyMatrixWithVector(matrixTransposeByMatrixInverse, matrixByVector);
        return matrixByVectorInverse;
    }

    public void printFullMLR(){
        double[] x1 = dataStorage.getX1();
        double[] x2 = dataStorage.getX2();
        double[] y = dataStorage.getY();

        double[][] matrixJoined = dataHelperMatrix.joinArrays(x1, x2);
        double[][] matrixTranspose = dataHelperMatrix.transposeMatrix(matrixJoined);
        double[] matrixByVector = dataHelperMatrix.multiplyMatrixWithVector(matrixTranspose, y);
        double[][] matrixTransposeByMatrix = dataHelperMatrix.multiplyMatrixWithMatrix(matrixTranspose, matrixJoined);
        double[][] matrixTransposeByMatrixInverse = dataHelperMatrix.inverseMatrix(matrixTransposeByMatrix);
        double[] matrixByVectorInverse = dataHelperMatrix.multiplyMatrixWithVector(matrixTransposeByMatrixInverse, matrixByVector);

        System.out.println("X1: ");
        for (int i=0; i<x1.length; i++) {
            System.out.print(x1[i]+" ");
        }
        System.out.println();
        System.out.println("X2: ");
        for (int i=0; i<x2.length; i++) {
            System.out.print(x2[i]+" ");
        }
        System.out.println();
        System.out.println("Y: ");
        for (int i=0; i<y.length; i++) {
            System.out.print(y[i]+" ");
        }
        System.out.println();
        System.out.println("Matrix joined: ");
        dataHelperMatrix.printJoinArrays(matrixJoined);
        System.out.println("Matrix transpose: ");
        dataHelperMatrix.printJoinArrays(matrixTranspose);
        System.out.println("Matrix by vector: ");
        dataHelperMatrix.printVector(matrixByVector);
        System.out.println("Matrix transpose by matrix: ");
        dataHelperMatrix.printJoinArrays(matrixTransposeByMatrix);
        System.out.println("Matrix transpose by matrix inverse: ");
        dataHelperMatrix.printJoinArrays(matrixTransposeByMatrixInverse);
        System.out.println("Matrix by vector inverse: ");
        dataHelperMatrix.printVector(matrixByVectorInverse);
    }

    public void printMLRValue(){
        double[] finalVector = getXValuesMLR();
        System.out.println("Final vector: ");
        dataHelperMatrix.printVector(finalVector);
    }

    public double predictY(double x1, double x2){
        double[] finalVector = getXValuesMLR();
        double y = finalVector[0] + finalVector[1]*x1 + finalVector[2]*x2;
        System.out.println(finalVector[0] + " + " + finalVector[1] + " * " + x1 + " + " + finalVector[2] + " * " + x2 + " = " + y);
        return y;
    }
}
