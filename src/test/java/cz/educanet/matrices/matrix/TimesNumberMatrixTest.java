package cz.educanet.matrices.matrix;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import cz.educanet.matrices.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimesNumberMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_ReturnResult() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.createIdentity(4),
                matrixFactory.create(new double[][]{{3, 2, 4}, {9, 8, 7}})
        };

        double[] scalars = new double[]{5, 10};

        double[][][] results = new double[][][]{
                {
                        {5, 0, 0, 0},
                        {0, 5, 0, 0},
                        {0, 0, 5, 0},
                        {0, 0, 0, 5}
                }, {
                        {30, 20, 40},
                        {90, 80, 70}
                }
        };

        for (int i = 0; i < matrices.length; i++) {
            Utils.matrixEquals(matrices[i].times(scalars[i]), results[i]);
        }
    }

}