package cz.educanet.matrices.matrix;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import cz.educanet.matrices.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransposeMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_ReturnTransposed() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.create(new double[][]{{3, 2, 4}, {9, 8, 7}, {23, 33, 43}}),
                matrixFactory.createDiagonal(new double[]{5, 6, 1}),
                matrixFactory.create(new double[][]{{3, 2, 4}, {9, 8, 7}}),
                matrixFactory.create(new double[][]{{2, 3}})
        };

        double[][][] results = new double[][][]{
                {{3, 9, 23}, {2, 8, 33}, {4, 7, 43}},
                {{5, 0, 0}, {0, 6, 0}, {0, 0, 1}},
                {{3, 9}, {2, 8}, {4, 7}},
                {{2}, {3}}
        };

        for (int i = 0; i < matrices.length; i++) {
            Utils.matrixEquals(matrices[i].transpose(), results[i]);
        }
    }

}