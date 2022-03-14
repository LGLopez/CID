package mlr;

public class DataHelperMatrix {
    // join the two arrays into a matrix with one added at the start
    public double[][] joinArrays(double[] x1, double[] x2) {
        double[][] matrix = new double[x1.length][3]; // create a general way to find the second dimension of the matrix
        for (int i=0; i<x1.length; i++) {
            matrix[i][0] = 1;
            matrix[i][1] = x1[i];
            matrix[i][2] = x2[i];
        }
        return matrix;
    }
    // print join arrays matrix
    public void printJoinArrays(double[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    // print vector
    public void printVector(double[] vector) {
        for (int i=0; i<vector.length; i++) {
            System.out.print(vector[i]+" ");
        }
        System.out.println();
    }

    // transpose the matrix joined
    public double[][] transposeMatrix(double[][] matrix) {
        double[][] matrixTranspose = new double[matrix[0].length][matrix.length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                matrixTranspose[j][i] = matrix[i][j];
            }
        }
        return matrixTranspose;
    }

    // multiply matrix with vector
    public double[] multiplyMatrixWithVector(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length]; // column quantity
        for (int i=0; i<matrix.length; i++) {
            result[i] = 0;
            for (int j=0; j<matrix[i].length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    // multiply matrix transpose with matrix
    public double[][] multiplyMatrixWithMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix2[0].length];
        for (int i=0; i<matrix1.length; i++) {
            for (int j=0; j<matrix2[0].length; j++) {
                result[i][j] = 0;
                for (int k=0; k<matrix1[i].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // inverse of a 3x3 matrix using Gauss-Jordan elimination
    public double[][] inverseMatrix(double[][] matrix) {
        double[][] inverseMatrix = new double[matrix.length][matrix.length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                if (i == j) {
                    inverseMatrix[i][j] = 1;
                } else {
                    inverseMatrix[i][j] = 0;
                }
            }
        }
        // Gauss-Jordan elimination
        for (int i=0; i<matrix.length; i++) {
            // find pivot
            int pivot = i;
            for (int j=i; j<matrix.length; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[pivot][i])) {
                    pivot = j;
                }
            }
            // swap rows
            double[] temp = matrix[i];
            matrix[i] = matrix[pivot];
            matrix[pivot] = temp;
            // swap rows in inverse matrix
            temp = inverseMatrix[i];
            inverseMatrix[i] = inverseMatrix[pivot];
            inverseMatrix[pivot] = temp;
            // divide pivot row by pivot element
            double pivotElement = matrix[i][i];
            for (int j=0; j<matrix.length; j++) {
                matrix[i][j] /= pivotElement;
                inverseMatrix[i][j] /= pivotElement;
            }
            // subtract pivot row from other rows
            for (int j=0; j<matrix.length; j++) {
                if (j!=i) {
                    double multiplier = matrix[j][i];
                    for (int k=0; k<matrix.length; k++) {
                        matrix[j][k] -= matrix[i][k] * multiplier;
                        inverseMatrix[j][k] -= inverseMatrix[i][k] * multiplier;
                    }
                }
            }
        }
        return inverseMatrix;
    }
    
}
