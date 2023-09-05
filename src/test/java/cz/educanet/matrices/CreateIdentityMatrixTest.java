package cz.educanet.matrices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateIdentityMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_NumberOnDiagonaleAre1() {
        IMatrix m = matrixFactory.createIdentity(5);
        Utils.checkDiagonal(m, new double[]{1,1,1,1,1});
    }

}