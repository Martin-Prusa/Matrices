package cz.educanet.matrices.matrix;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsSquareMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_ReturnTrue_When_MatrixIsSquare() {
        double[][][] data = {{{3, 2, 4}, {9, 8, 7}, {23, 33, 43}}, {{2, 3}, {4, 9}}};
        for (double[][] d : data) {
            IMatrix m = matrixFactory.create(d);
            Assertions.assertTrue(m.isSquare());
        }
    }

    @Test
    public void should_ReturnFalse_When_MatrixIsNotSquare() {
        double[][][] data = {{{3, 2, 4}, {9, 8, 7}}, {{2}, {4}}};
        for (double[][] d : data) {
            IMatrix m = matrixFactory.create(d);
            Assertions.assertFalse(m.isSquare());
        }
    }

}