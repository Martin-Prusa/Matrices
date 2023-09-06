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

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix add(IMatrix matrix) {
        return null;
    }

    @Override
    public IMatrix transpose() {
        if(rawArray.length == 0) return new Matrix(new double[][]{});
        double[][] transposed = new double[rawArray[0].length][rawArray.length];
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
        if(rawArray.length != 0) return rawArray.length == rawArray[0].length;
        return true;
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
