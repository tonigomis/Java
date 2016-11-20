package matinversa;

/**
 * Created by pnegre on 16/11/16.
 */
public class MatriuInversa {
    static double[][] invert(double[][] mat) {
        double det = calcDeterminant(mat);
        double[][] cofact = calcCofactors(mat);
        double[][] adj = transpose(cofact);

        // Dividim cada element pel determinant de la matriu original
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[0].length; j++) {
                adj[i][j] /= det;
            }
        }

        return adj;
    }

    static double[][] calcCofactors(double[][] mat) {
        return null;
    }

    static double[][] calcMinors(double[][] mat) {
        return null;
    }

    static double[][] getMinor(double[][] mat, int x, int y) {
        return null;
    }

    static double calcDeterminant(double[][] mat) {
        if (mat.length != mat[0].length) throw new RuntimeException("La matriu no és quadrada!");
        if (mat.length == 2) return mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1];
        else {
            int contador;
            int fila;
            double det = 0;
            for (fila = 0; fila < mat.length; fila++) {
                double[][] minor = new double[mat.length-1][mat.length-1];
                for (int pos = 0; pos < mat.length; pos++) {
                    if (pos != fila) {
                        for (int columna = 1; columna < mat.length; columna++) {
                            contador = -1;
                            if (pos < fila) {
                                contador = pos;
                            }
                            else if (pos > fila) {
                                contador = pos - 1;
                            }
                            minor[contador][columna-1] = mat[pos][columna];
                        }
                    }
                }
                if (fila % 2 == 0) {
                    det += mat[fila][0] * calcDeterminant(minor);
                } else {
                    det -= mat[fila][0] * calcDeterminant(minor);
                }
            }
            return det;
        }
    }

    static double[][] transpose(double[][] mat) {
        int dimv = mat.length;
        int dimh = mat[0].length;
        double[][] result = new double[dimh][dimv];
        for (int i = 0; i < dimv; i++) {
            for (int j = 0; j < dimh; j++) {
                result[j][i] = mat[i][j];
            }
        }
        return result;
    }

    // Funció que mostra una matriu per pantalla
    static void printMat(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("%06.2f ", mat[i][j]);
            }
            System.out.println();
        }
    }
}
