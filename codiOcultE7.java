/**
 * Created by toni on 08/11/16.
 */
public class codiOcultE7 {
    public static void main(String[] args) {
        int[] a = new int[10];

        // El primer for fa un compte enrere des de 9 fins a 0
        for (int i = 0; i < 10; i++)
        a[i] = 9 - i;
        // El segon bucle substitueix els valors de les primeres iteracions, però a partir de la cinquena ho deixa tot
        // igual perquè els cinc darrers valors de l'array són identics als cinc primers que sí que han estat sustituïts.
        for (int i = 0; i < 10; i++)
        a[i] = a[a[i]];
        // El tercer bucle imprimeix el resultat
        for (int i = 0; i < 10; i++)
                System.out.println(a[i]);
    }
}
