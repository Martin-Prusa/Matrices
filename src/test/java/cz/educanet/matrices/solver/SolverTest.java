package cz.educanet.matrices.solver;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import cz.educanet.matrices.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    private final Solver solver = new Solver();

    @Test
    public void should_SolveEquations_When_MatrixIsSquare() {
        IMatrix[] matrices = new IMatrix[]{
                matrixFactory.create(new double[][]{{1, 2}, {4, 3}}),
                matrixFactory.create(new double[][]{{4, 3, 0}, {2, 2, -2}, {5, 3, 1}})
        };

        IMatrix[] solutions = new IMatrix[]{
                matrixFactory.create(new double[][]{{5}, {15}}),
                matrixFactory.create(new double[][]{{4}, {0}, {-2}})
        };

        double[][] results = new double[][]{{3, 1}, {-11, 16, 5}};

        for (int i = 0; i < matrices.length; i++) {
            double[] r = solver.solve(matrices[i], solutions[i]);
            for (int j = 0; j < r.length; j++) {
                Assertions.assertEquals(results[i][j], r[j]);
            }
        }
    }

}