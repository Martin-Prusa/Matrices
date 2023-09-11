package cz.educanet.matrices.matrix;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import cz.educanet.matrices.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimesMatrixMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_ThrowIllegalArgumentException_When_M1ColumnsNotEqualM2Rows() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.createIdentity(3),
                matrixFactory.createZero(4),
                matrixFactory.create(new double[][]{{1, 3, 9}, {4, 6, 7}}),
                matrixFactory.create(new double[][]{{1, 3, 9, 10}, {4, 6, 9, 10}}),
                matrixFactory.create(new double[][]{{1, -2, 3, 1}, {2, -1, 0, 5}}),
                matrixFactory.create(new double[][]{{5, 3}, {-5, 1}, {2, -3}}),
        };

        for (int i = 0; i < matrices.length - 1; i++) {
            int finalI = i;
            Assertions.assertThrows(IllegalArgumentException.class, () -> matrices[finalI].times(matrices[finalI + 1]));
        }
    }

    @Test
    public void should_ReturnResult_When_M1ColumnsEqualM2Rows() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.create(new double[][]{{5, 3}, {-5, 1}, {2, -3}}),
                matrixFactory.create(new double[][]{{1, -2, 3, 1}, {2, -1, 0, 5}}),

                matrixFactory.create(new double[][]{{1, 2}, {3, 6}}),
                matrixFactory.create(new double[][]{{2, 8}, {-1, -4}})
        };

        double[][][] results = new double[][][]{
                {
                        {11, -13, 15, 20},
                        {-3, 9, -15, 0},
                        {-4, -1, 6, -13}
                },
                {
                        {0, 0},
                        {0, 0}
                }
        };

        for (int i = 0; i < matrices.length; i += 2) {
            Utils.matrixEquals(matrices[i].times(matrices[i + 1]), results[i / 2]);
        }
    }

}