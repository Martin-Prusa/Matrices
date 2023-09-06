package cz.educanet.matrices;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix times(IMatrix matrix) {
        return null;
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix times(Number scalar) {
        return null;
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        if(getRows() != matrix.getRows() || getColumns() != matrix.getColumns()) throw new IllegalArgumentException("matrices must have an equal number of rows and columns to be added");
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
        if(rawArray.length == 0) return new Matrix(new double[][]{});
        double[][] transposed = new double[getColumns()][getRows()];
        for (int i = 0; i < rawArray.length; i++) {
            for (int j = 0; j < rawArray[i].length; j++) {
                transposed[j][i] = rawArray[i][j];
            }
        }
        return new Matrix(transposed);
    }

    /**
     * TODO: Implement
     */
    @Override
    public double determinant() {
        return 0;
    }

    @Override
    public boolean isSquare() {
        return getRows() == getColumns();
    }

    @Override
    public boolean isDiagonal() {
        if(!isSquare()) return false;
        for (int i = 0; i < rawArray.length; i++) {
            for (int j = 0; j < rawArray[i].length; j++) {
                if(i != j && rawArray[i][j] != 0) return false;
            }
        }

        return true;
    }

    @Override
    public Number getTrace() {
        if(!isSquare()) throw new RuntimeException("Must be square matrix");
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
        if(n >= getRows() || n < 0 || m >= getColumns() || m < 0)
            throw new IllegalArgumentException();

        return rawArray[n][m];
    }
}
