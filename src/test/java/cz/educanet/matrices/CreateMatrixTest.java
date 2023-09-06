package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_NumberOnCoordinatesIsValid() {
        double[][][] data = {{{3, 2, 4}, {9, 8, 7}, {23, 33, 43}}, {{2, 3, 5, 6}, {4, 9, 3, 2}}};

        for (double[][] d : data) {
            IMatrix m = matrixFactory.create(d);
            Utils.matrixEquals(m, d);
        }
    }

    @Test
    public void should_Succeed_When_SizeIsCorrect() {
        double[][][] data = {{{3, 2, 4}, {9, 8, 7}, {23, 33, 43}}, {{2, 3, 5, 6}, {4, 9, 3, 2}}};
        for (double[][] d : data) {
            IMatrix m = matrixFactory.create(d);
            Assertions.assertEquals(d.length, m.getRows());
            if(d[0] != null) Assertions.assertEquals(d[0].length, m.getColumns());
        }
    }

}