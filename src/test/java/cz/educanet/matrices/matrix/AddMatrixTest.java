package cz.educanet.matrices.matrix;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import cz.educanet.matrices.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_ThrowException_When_SizeIsDifferent() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.createIdentity(4),
                matrixFactory.create(new double[][]{{3, 2, 4}, {9, 8, 7}, {23, 33, 43}}),
                matrixFactory.createZero(2)
        };

        for (int i = 0; i < matrices.length-1; i++) {
            int finalI = i;
            Assertions.assertThrows(IllegalArgumentException.class, () -> matrices[finalI].add(matrices[finalI +1]));
        }


    }

    @Test
    public void should_ReturnResult_When_SizeIsSame() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.createIdentity(3).add(matrixFactory.create(new double[][]{{4, 4, 5}, {2, 1, 0}, {9, 9, 6}})),
                matrixFactory.create(new double[][]{{1, 4}, {2, 0}}).add(matrixFactory.create(new double[][]{{2, 3}, {7, 5}})),
        };

        double[][][] results = new double[][][]{
                {
                        {5, 4, 5},
                        {2, 2, 0},
                        {9, 9, 7}
                },
                {
                        {3, 7},
                        {9, 5}
                }
        };

        for (int i = 0; i < matrices.length; i++) {
            Utils.matrixEquals(matrices[i], results[i]);
        }
    }
}