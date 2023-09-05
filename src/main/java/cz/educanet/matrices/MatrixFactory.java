package cz.educanet.matrices;

public class MatrixFactory implements IMatrixFactory {

    public static final IMatrixFactory instance = new MatrixFactory();

    private MatrixFactory() {
    }

    @Override
    public IMatrix create(double[][] data) {
        return new Matrix(data);
    }

    @Override
    public IMatrix createDiagonal(double[] diagonal) {
        if(diagonal.length == 0) throw new IllegalArgumentException();
        double[][] d = new double[diagonal.length][diagonal.length];
        for (int i = 0; i < diagonal.length; i++) {
            d[i][i] = diagonal[i];
        }

        return new Matrix(d);
    }

    @Override
    public IMatrix createIdentity(int size) {
        if(size < 0) throw new IllegalArgumentException();
        double[][] d = new double[size][size];
        for (int i = 0; i < size; i++) {
            d[i][i] = 1;
        }
        return new Matrix(d);
    }

    @Override
    public IMatrix createZero(int size) {
        if (size < 0)
            throw new IllegalArgumentException();

        return new Matrix(new double[size][size]);
    }
}
