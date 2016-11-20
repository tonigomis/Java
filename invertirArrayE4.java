import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by toni on 06/11/16.
 */
public class invertirArrayE4 {
    public static void main(String[] args) {
        try{
            entrada();
        } catch (Exception e) {
            System.out.println("S'ha produït un error!");
        }
    }

    static void entrada() {

        // Declaram les variables que farem servir i cream l'objecte Scanner per rebre els inputs de l'usuari
        Scanner s = new Scanner(System.in);
        String opt;
        int llarg;

        // Demanam la quantitat d'elements de l'array per poder inicialitzar-la amb el número de posicions correcte
        System.out.println("Quants d'elements té l'array que vols introduïr?");
        llarg = Integer.parseInt(s.nextLine());
        int[] arr = new int[llarg];

        // Demanam a l'usuari que introdueixi els valors de la seva array
        System.out.println("Introdueix els valors de l'array que vols invertir: ");

/*      Amb aquest bucle recorrem l'array que ha definit l'usuari, i anam emplenant els valors de cada posició amb
        les dades que ens fa arribar per teclat */
        for (int j = 0; j < arr.length; j++) {
            opt = String.valueOf(s.nextInt());
            arr[j] = Integer.parseInt(opt);
        }
        // Aquí imprimim l'array completa introduïda per l'usuari, a mode de comprovació
        System.out.println("Heu demanat invertir l'array: " + Arrays.toString(arr));

        // Cridam la funció que recorrerà l'array de forma inversa i n'imprimirà els valors per pantalla
        invertirArray(arr);
    }
    // Aquest mètode ens mostra l'array en ordre invertit, sense modificar l'original
    static void invertirArray(int[] arr) {
        System.out.print("[");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
