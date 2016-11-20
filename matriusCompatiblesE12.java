import java.util.Arrays;

/**
 * Created by toni on 09/11/16.
 */
public class matriusCompatiblesE12 {
    public static void main(String[] args) {
        // Declaram les matrius que farem servir per al programa i en feim una inicialització explícita.
        int[][] arr1 = {{2, 0}, {3, 0}, {5, 1}};
        int[][] arr2 = {{1, 0, 1}, {1, 2, 1}};

        // Comprovam que les matrius creades són compatibles per operar entre sí. Mostram un missatge que ens indica si són correctes o no.
        System.out.println(checkCompatibility(arr1,arr2) ? "Les matrius " + Arrays.deepToString(arr1) + " i " +
                Arrays.deepToString(arr2) + " són compatibles.\n\nEl resultat és: " : "Aquestes dues matrius no es poden multiplicar!");

        // Cridam la funció booleana que hem creat per determinar si són compatibles, i en cas afirmatiu executam la funció de multiplicació.
        if(checkCompatibility(arr1, arr2)) {
            // Cream la matriu resultat utilitzant els valors de llargada horitzontal de la matriu 1 i vertical de la matriu 2.
            int[][] matriuResultat = new int[arr1.length][arr2[0].length];
            // Agafam les dues matrius originals com a paràmetre de la funció de multiplicació, juntament amb la matriu resultat on guardarem el que obtindrem.
            multiplicaMatriu(arr1, arr2, matriuResultat);
        }
    }

    static boolean checkCompatibility(int[][] arr1, int[][] arr2) {
        return (arr1.length == arr2[0].length);
    }

    static void multiplicaMatriu(int[][] arr1, int[][] arr2, int[][] matriuResultat) {
        // Declaram les tres variables que ens serviran per moure'ns per les posicions de les matrius
        int x, y, z;
        // En aquest primer bucle establim la posició (fila) on operam en la primera matriu
        for (x = 0; x < arr1.length; x++) {
            // En el segon bucle determinam en quina columna esteim a la segona matriu
            for (y = 0; y < arr2[0].length; y++) {
                // El tercer ens serveix per moure'ns per les columnes de la primera matriu
                for (z = 0; z < arr1[0].length; z++) {
                    // Incorporam a les posicions 'x' i 'y' de la matriuResultat el producte de (fila 'x' i la columna 'z' d'arr1) per la (columna 'z' (arr1) i la columna 'y' (arr2);
                    matriuResultat[x][y] += arr1[x][z] * arr2[z][y];
                }
                System.out.printf("%s", String.format("  %d  ", matriuResultat[x][y]));
            }
            System.out.println();
        }
    }
}

// Aquí hem creat un petit joc de proves per comprovar si el programa funciona. Tots els resultats han estat els esperats.

    // Joc de proves 1 (Matrius diferents i compatibles) <-- OK
    //int[][] arr1 = {{2, 0}, {3, 0}, {5, 1}};
    //int[][] arr2 = {{1, 0, 1}, {1, 2, 1}};

    // Joc de proves 2 (Matrius diferents i compatibles) <-- OK
    //int[][] arr1 = {{1, 0, 1}, {1, 2, 1}};
    //int[][] arr2 = {{2, 0}, {3, 0}, {5, 1}};

    // Joc de proves 3 (Matrius diferents i incompatibles) <-- Aquestes matrius són incompatibles. Impossible operar
    //int[][] arr1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}};
    //int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};

    // Joc de proves 4 (Matrius quadrades) <-- OK
    //int[][] arr1 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
    //int[][] arr2 = {{1, -1, 2}, {2, -1, 2}, {3, -3, 0}};