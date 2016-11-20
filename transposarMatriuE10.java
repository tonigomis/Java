import java.util.Arrays;

/**
 * Created by toni on 08/11/16.
 */
public class transposarMatriuE10 {
    public static void main(String[] args) {

        // Declaram la matriu original
        int[][] matriu = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        // Declaram la segona matriu, que és la que utilitzarem per guardar els nous valors de la transposició.
        // Utilitzam matriu[0].length per si la matriu no és quadrada
        int[][] matriu2 = new int[matriu[0].length][matriu.length];
        // Mostram l'Array que ens ha creat per allotjar la transposició de la primera array
        System.out.println(Arrays.deepToString(matriu2));
        // Cridam la funció de transposició, passant les dues arrays com a paràmetres
        transposaMatriu(matriu, matriu2);
        // Imprimim els valors de la nova matriu obtinguda
        System.out.println(Arrays.deepToString(matriu2));
    }

    static int[][] transposaMatriu(int[][] matriu, int[][] matriu2) {
        // Cream un primer bucle per recórrer la primera matriu
        for (int x = 0; x < matriu.length; x++) {
            // Hi anidam un segon bucle que s'encarregarà d'assignar els valors de matriu2, però per columna enlloc
            // d'arrignar-los per fila.
            for (int y = 0; y < matriu[x].length; y++) {
                //La transposició s'aconsegueix invertint l'ordre de les coordenades entre els dos
                // arrays matriu[x][y] es converteix en matriu2[y][x]
                matriu2[y][x] = matriu[x][y];
            }
        }
        return matriu2;
    }
}
