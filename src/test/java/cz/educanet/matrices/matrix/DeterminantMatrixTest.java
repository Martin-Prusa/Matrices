package cz.educanet.matrices.matrix;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.Matrix;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeterminantMatrixTest {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_ThrowError_When_MatrixIsNotSquare() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.create(new double[][]{{3, 2, 4}, {9, 8, 7}}),
                matrixFactory.create(new double[][]{{2, 3}})
        };

        for (IMatrix matrix : matrices) {
            Assertions.assertThrows(RuntimeException.class, matrix::determinant);
        }
    }

    @Test
    public void should_ReturnDeterminant_When_MatrixIsSquare() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.create(new double[][]{{1,2,3},{4,5,6},{7,8,9}}),
                matrixFactory.create(new double[][]{{-5,-5,-5},{3,-1,-2},{4,2,1}}),
                matrixFactory.create(new double[][]{{1,2},{3,4}}),
                matrixFactory.create(new double[][]{{0,-2,-5,8},{0,-6,3,1}, {0,11,5,-3}, {-1,-2,-1,3}})
        };

        double[] results = new double[]{0, -10, -2, -441};
        for (int i = 0; i < matrices.length; i++) {
            Assertions.assertEquals(results[i], matrices[i].determinant());
        }
    }

}