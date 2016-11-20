/**
 * Created by toni on 15/11/16.
 */
public class ProvaInversaMatriuE15 {
    public static void main(String[] args) {
        //double[][] arr = {{1, 2}, {3, 4}};
        double[][] arr = {{1, 2, 3}, {4, 5, 6}, {2, -4, 1}}; // Resultat= -33

        /*determinant(arr, minor);
        System.out.println(determinant(arr, minor));*/
    }


    static double[][] obtenirMenor(double[][] arr, int fila, double[][] minor) {
        int contador;
        minor = new double[arr.length - 1][arr.length - 1];
        for (int pos = 0; pos < arr.length; pos++) {
            if (pos != fila) {
                for (int columna = 1; columna < arr.length; columna++) {
                    contador = -1;
                    if (pos < fila) {
                        contador = pos;
                    } else if (pos > fila) {
                        contador = pos - 1;
                    }
                    minor[contador][columna - 1] = arr[pos][columna];
                }
            }
        }
        return minor;
    }

    static double determinant(double[][] arr, double[][] minor) {
        if (arr.length != arr[0].length) throw new RuntimeException("La matriu no és quadrada!");
        if (arr.length == 2) return arr[0][0] * arr[1][1] - arr[1][0] * arr[0][1];
        else {
            int fila;
            double det = 0;
            for (fila = 0; fila < arr.length; fila++) {
                minor = obtenirMenor(arr, fila, minor);

            }
            if (fila % 2 == 0) {
                det += arr[fila][0] * determinant(arr, minor);
            } else {
                det -= arr[fila][0] * determinant(arr, minor);
            }
            return det;
        }
    }

}