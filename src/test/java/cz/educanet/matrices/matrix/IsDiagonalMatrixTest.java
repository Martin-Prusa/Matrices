package cz.educanet.matrices.matrix;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsDiagonalMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_BeDiagonal_When_MatrixIsDiagonal() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.createIdentity(5),
                matrixFactory.createDiagonal(new double[]{5,6,9,1}),
                matrixFactory.createDiagonal(new double[]{3,4,1}),
                matrixFactory.createZero(3)
        };
        for (IMatrix matrix : matrices) {
            Assertions.assertTrue(matrix.isDiagonal());
        }
    }

    @Test
    public void should_NotBeDiagonal_When_MatrixIsNotSquare() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.create(new double[][]{{3, 2, 4}, {9, 8, 7}}),
                matrixFactory.create(new double[][]{{2}, {4}}),
                matrixFactory.create(new double[][]{{3, 2, 4}, {9, 8, 7}, {23, 33, 43}})
        };
        for (IMatrix matrix : matrices) {
            Assertions.assertFalse(matrix.isDiagonal());
        }
    }

    @Test
    public void should_NotBeDiagonal_When_MatrixIsNotDiagonal() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.create(new double[][]{{3, 2, 4}, {9, 8, 7}, {23, 33, 43}}),
                matrixFactory.create(new double[][]{{3, 2}, {9, 8}})
        };
        for (IMatrix matrix : matrices) {
            Assertions.assertFalse(matrix.isDiagonal());
        }
    }
}