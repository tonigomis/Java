/**
 * Created by toni on 02/11/16.
 */
public class limitArraysE2 {
    public static void main(String[] args) {
        int[] a = new int[1000];
        System.out.println(a[1000]);
    }
}

// El programa genera una excepció perquè l'índex al que esteim provant d'accedir es troba fora dels límits. Quan
// declaram una array a de 1000 posicions, la primera és la a[0], mentre que la darrera és la a[999].