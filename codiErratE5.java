/**
 * Created by toni on 06/11/16.
 */
public class codiErratE5 {
    public static void main(String[] args) {
/*        Aquest codi no funcionava perquè l'array no s'havia inicialitzat en cap valor. A més, si s'inicialitza amb un
        valor inferior al número d'iteracions del bucle, genera un error d'ArrayIndexOutOfBounds.*/
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i * i;
        System.out.println(a[i]);
        }
    }
}
