/**
 * Created by toni on 08/11/16.
 */
public class igualtatArrayE9 {
    public static void main(String[] args) {

        // Aquest codi imprimeix "fals" perquè amb l'operador booleà l'únic que es compara en aquest cas són les
        // direccions de memòria, que són diferents ja que es tracta de dos arrays distints que estan ubicats cadascun
        // en una posició de la memòria pròpia.
        int[] a = { 1, 2, 3 };
        int[] b = { 1, 2, 3 };
        System.out.println(a == b);
    }
}
