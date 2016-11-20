import java.util.Arrays;

/**
 * Created by toni on 15/11/16.
 */
public class inversaMatriuE15 {
    public static void main(String[] args) {
        //double[][] arr = {{1, 2}, {3, 4}};
        double[][] arr = {{1, 2, 3}, {4, 5, 6}, {2, -4, 1}}; // Resultat= -33

        System.out.println(determinant(arr));
    }

    static double determinant(double[][] arr) {
        if (arr.length != arr[0].length) throw new RuntimeException("La matriu no és quadrada!");
        if (arr.length == 2) return arr[0][0] * arr[1][1] - arr[1][0] * arr[0][1];
        else {
            int contador;
            int fila;
            double det = 0;
            for (fila = 0; fila < arr.length; fila++) {
                double[][] minor = new double[arr.length-1][arr.length-1];
                for (int pos = 0; pos < arr.length; pos++) {
                    if (pos != fila) {
                        for (int columna = 1; columna < arr.length; columna++) {
                            contador = -1;
                            if (pos < fila) {
                                contador = pos;
                            }
                            else if (pos > fila) {
                                contador = pos - 1;
                            }
                            minor[contador][columna-1] = arr[pos][columna];
                        }
                    }
                }
                if (fila % 2 == 0) {
                    det += arr[fila][0] * determinant(minor);
                } else {
                    det -= arr[fila][0] * determinant(minor);
                }
            }
            return det;
        }
    }
/*
    static double[][] obtenirMenor(double[][] arr) {
        double[][] minor = new double[arr.length-1][arr.length-1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < minor[0].length; j++) {
                minor[i][j] = arr[i+1][j+1];

            }
            //System.out.println(Arrays.toString(minor[i]));



        }
        //System.out.println(Arrays.deepToString(minor));

        return minor;
    }*/
}
