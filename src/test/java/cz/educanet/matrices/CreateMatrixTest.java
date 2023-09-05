package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_NumberOnCoordinatesIsValid() {
        double[][] d = {{3, 2, 4}, {9, 8, 7}, {23, 33, 43}};
        IMatrix m = matrixFactory.create(d);
        Utils.matrixEquals(m, d);
    }

}