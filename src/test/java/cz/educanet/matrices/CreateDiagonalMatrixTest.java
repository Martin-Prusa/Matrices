package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateDiagonalMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_NumberOnCoordinatesIsValid() {
        double[] diagonale = new double[]{1, 2, 3};
        IMatrix m = matrixFactory.createDiagonal(diagonale);

        assertEquals(diagonale.length, m.getRows());
        assertEquals(diagonale.length, m.getColumns());

        Utils.checkDiagonal(m, diagonale);
    }

}