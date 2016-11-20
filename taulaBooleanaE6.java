import java.util.Arrays;

/**
 * Created by toni on 06/11/16.
 */
public class taulaBooleanaE6 {
    public static void main(String[] args) {
        emplenaTaula();
    }

    static boolean[][] emplenaTaula() {
        boolean[][] taula = {{true, true, false, false, true}, {true, false, false, true, true},
                {true, false, false, false, true}, {false, true, false, true, true}};
        int x = 0;
        while (x < taula.length) {
            for (int y = 0; y < taula[x].length; y++) {
                System.out.print(taula[x][y] ? "*" : " ");
            }
            System.out.println();
            x++;
        }
        System.out.println(Arrays.deepToString(taula));
        return taula;
    }
}
