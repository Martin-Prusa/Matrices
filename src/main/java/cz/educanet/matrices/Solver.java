package cz.educanet.matrices;

import java.util.Arrays;

public class Solver {

    public double[] solve(IMatrix matrix, IMatrix results) {
        if(matrix.getRows() != matrix.getColumns() || matrix.getRows() != results.getRows()) throw new IllegalArgumentException();

        double detA = matrix.determinant();

        double[] determinants = new double[matrix.getColumns()];

        for (int i = 0; i < matrix.getColumns(); i++) {
            determinants[i] = new Matrix(replaceColumn(matrix, results, i)).determinant();
        }

        return Arrays.stream(determinants).map(a -> a/detA).toArray();
    }

    private double[][] copy2DArray(IMatrix old) {
        double[][] n = new double[old.getRows()][old.getColumns()];
        for (int i = 0; i < old.getRows(); i++) {
            for (int j = 0; j < old.getColumns(); j++) {
                n[i][j] = old.get(i, j);
            }
        }
        return n;
    }

    private double[][] replaceColumn(IMatrix matrix, IMatrix results, int column) {
        double[][] replaced = copy2DArray(matrix);
        for (int j = 0; j < results.getRows(); j++) {
            replaced[j][column] = results.get(j, 0);
        }
        return replaced;
    }
}
