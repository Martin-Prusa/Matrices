package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Utils {
    public static void matrixEquals(IMatrix m, double[][] d) {
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                Assertions.assertEquals(d[i][j], m.get(i, j));
            }
        }
    }

    public static void checkDiagonal(IMatrix m, double[] diagonale) {
        for (int i = 0; i < diagonale.length; i++) {
            for (int j = 0; j < diagonale.length; j++) {
                if(i == j) assertEquals(diagonale[i], m.get(i, j));
                else assertEquals(0, m.get(i, j));
            }
        }
    }
}
