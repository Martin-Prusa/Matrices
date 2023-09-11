package cz.educanet.matrices;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        if (getColumns() != matrix.getRows())
            throw new IllegalArgumentException("the number of columns in the first matrix must be equal to the number of rows in the second matrix");
        double[][] result = new double[getRows()][matrix.getColumns()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                for (int k = 0; k < matrix.getRows(); k++) {
                    result[i][j] += (get(i, k) * matrix.get(k, j));
                }
            }
        }

        return new Matrix(result);
    }

    @Override
    public IMatrix times(Number scalar) {
        double[][] d = new double[getRows()][getColumns()];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                d[i][j] = scalar.doubleValue() * rawArray[i][j];
            }
        }
        return new Matrix(d);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        if (getRows() != matrix.getRows() || getColumns() != matrix.getColumns())
            throw new IllegalArgumentException("matrices must have an equal number of rows and columns to be added");
        double[][] sum = new double[getRows()][getColumns()];
        for (int i = 0; i < rawArray.length; i++) {
            for (int j = 0; j < rawArray[i].length; j++) {
                sum[i][j] = rawArray[i][j] + matrix.get(i, j);
            }
        }
        return new Matrix(sum);
    }

    @Override
    public IMatrix transpose() {
        if (rawArray.length == 0) return new Matrix(new double[][]{});
        double[][] transposed = new double[getColumns()][getRows()];
        for (int i = 0; i < rawArray.length; i++) {
            for (int j = 0; j < rawArray[i].length; j++) {
                transposed[j][i] = rawArray[i][j];
            }
        }
        return new Matrix(transposed);
    }

    @Override
    public double determinant() {
        if(!isSquare()) throw new RuntimeException("Must be square matrix");

        double det = 0;

        if(getRows() == 1) return rawArray[0][0];

        for (int i = 0; i < getColumns(); i++) {

            double[][] newRawArray = new double[getRows()-1][getColumns()-1];
            for (int j = 0; j < newRawArray.length; j++) {
                int skip = 0;
                for (int k = 0; k < newRawArray[j].length+1; k++) {
                    if(k == i) {
                        skip++;
                        continue;
                    }
                    newRawArray[j][k-skip] = rawArray[j+1][k];
                }
            }

            IMatrix newMatrix = new Matrix(newRawArray);


            det += (get(0, i)*newMatrix.determinant()) * (i % 2 == 1 ? -1 : 1);
        }

        return det;
    }

    @Override
    public boolean isSquare() {
        return getRows() == getColumns();
    }

    @Override
    public boolean isDiagonal() {
        if (!isSquare()) return false;
        for (int i = 0; i < rawArray.length; i++) {
            for (int j = 0; j < rawArray[i].length; j++) {
                if (i != j && rawArray[i][j] != 0) return false;
            }
        }

        return true;
    }

    @Override
    public Number getTrace() {
        if (!isSquare()) throw new RuntimeException("Must be square matrix");
        double sum = 0;
        for (int i = 0; i < rawArray.length; i++) {
            sum += rawArray[i][i];
        }
        return sum;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public double get(int n, int m) {
        if (n >= getRows() || n < 0 || m >= getColumns() || m < 0)
            throw new IllegalArgumentException();

        return rawArray[n][m];
    }
}
