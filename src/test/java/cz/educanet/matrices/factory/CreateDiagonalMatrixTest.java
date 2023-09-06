package cz.educanet.matrices.factory;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import cz.educanet.matrices.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateDiagonalMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_NumberOnCoordinatesIsValid() {
        double[][] diagonals = new double[][]{{1, 2, 3}, {4,5,6,7,7}};

        for (double[] diagonale : diagonals) {
            IMatrix m = matrixFactory.createDiagonal(diagonale);
            Utils.checkDiagonal(m, diagonale);
        }
    }

    @Test
    public void should_Succeed_WhenSizeIsValid() {
        double[][] diagonals = new double[][]{{1, 2, 3}, {4,5,6,7,7}};

        for (double[] diagonale : diagonals) {
            IMatrix m = matrixFactory.createDiagonal(diagonale);

            assertEquals(diagonale.length, m.getRows());
            assertEquals(diagonale.length, m.getColumns());
        }
    }

    @Test
    public void should_ThrowException_When_EmptyArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createDiagonal(new double[]{}));
    }

}