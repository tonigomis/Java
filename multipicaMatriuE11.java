import java.util.Arrays;

/**
 * Created by toni on 08/11/16.
 */
public class multipicaMatriuE11 {
    public static void main(String[] args) {
        // Joc de proves
        int[][] arr1 = {{2, 0, 1}, {3, 0, 0}, {5, 1, 1}};
        int[][] arr2 = {{1, 0, 1}, {1, 2, 1}, {1, 1, 0}};

        checkCompatibility(arr1, arr2);
        System.out.println(checkCompatibility(arr1, arr2) ? "Les matrius " + Arrays.deepToString(arr1) + " i "
                + Arrays.deepToString(arr2) + " són compatibles." : "Aquestes dues matrius no es poden multiplicar!");

        int[][] arrResultat = new int[arr1.length][arr2.length];
        multiplicaMatriu(arr1, arr2, arrResultat);
    }

    static int[][] multiplicaMatriu(int[][] arr1, int[][] arr2, int[][] arrResultat) {
        for (int x = 0; x < arr1.length; x++) {
            for (int y = 0; y < arr2.length; y++) {
                for (int z = 0; z < arr1[x].length; z++) {
                    arrResultat[x][y] += arr1[x][z] * arr2[z][y];
                }
                System.out.print(arrResultat[x][y] + " ");
            }
            System.out.println();
        }
        return arrResultat;
    }

    static boolean checkCompatibility(int[][] arr1, int[][] arr2) {
        return (arr1.length == arr2[0].length);
    }
}
// Joc de proves
// int[][] arr1 = {{2, 0, 1}, {3, 0, 0}, {5, 1, 1}};
// int[][] arr2 = {{1, 0, 1}, {1, 2, 1}, {1, 1, 0}};

// Joc de proves
//int[][] arr1 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
//int[][] arr2 = {{1, -1, 2}, {2, -1, 2}, {3, -3, 0}};

// Joc de proves <-- No funciona
//int[][] arr1 = {{2, 0}, {3, 0}, {5, 1}};
//int[][] arr2 = {{1, 0, 1}, {1, 2, 1}};

// Joc de proves <-- No funciona correctament
//int[][] arr1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}};
//int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};