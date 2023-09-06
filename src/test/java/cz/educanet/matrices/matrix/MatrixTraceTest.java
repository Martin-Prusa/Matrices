package cz.educanet.matrices.matrix;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTraceTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_ReturnTrace_When_MatrixIsSquare() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.create(new double[][]{{3, 2, 4}, {9, 8, 7}, {23, 33, 43}}),
                matrixFactory.create(new double[][]{{2, 3}, {4, 9}}),
                matrixFactory.createZero(3),
                matrixFactory.createIdentity(4),
                matrixFactory.createDiagonal(new double[]{5, 6, 1})
        };

        double[] results = new double[]{54, 11, 0, 4, 12};

        for (int i = 0; i < matrices.length; i++) {
            Assertions.assertEquals(results[i], matrices[i].getTrace());
        }

    }

    @Test
    public void should_ThrowError_When_MatrixIsNotSquare() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.create(new double[][]{{3, 2, 4}, {9, 8, 7}}),
                matrixFactory.create(new double[][]{{2, 3}})
        };

        for (IMatrix matrix : matrices) {
            Assertions.assertThrows(RuntimeException.class, matrix::getTrace);
        }
    }

}