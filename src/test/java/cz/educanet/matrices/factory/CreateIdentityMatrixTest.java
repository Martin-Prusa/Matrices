package cz.educanet.matrices.factory;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import cz.educanet.matrices.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateIdentityMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_NumberOnDiagonaleAre1() {
        IMatrix m = matrixFactory.createIdentity(5);
        Utils.checkDiagonal(m, new double[]{1,1,1,1,1});

        IMatrix m2 = matrixFactory.createIdentity(3);
        Utils.checkDiagonal(m2, new double[]{1,1,1});
    }

    @Test
    public void should_Succeed_When_SizeIsValid() {
        int[] validSizes = {2, 4, 6, 10};

        for (int size : validSizes) {
            IMatrix matrix = matrixFactory.createIdentity(size);

            Assertions.assertEquals(size, matrix.getRows());
            Assertions.assertEquals(size, matrix.getColumns());
        }
    }

    @Test
    public void should_ThrowException_When_NegativeSize() {
        int[] negativeSizes = {-2, -10, -Integer.SIZE};

        for (int size : negativeSizes)
            Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createIdentity(size));
    }

}