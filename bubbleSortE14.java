import java.util.Arrays;

/**
 * Created by toni on 14/11/16.
 */
public class bubbleSortE14 {
    public static void main(String[] args) {
        int[] arr = {4, -2, 7, -9, 6, 3, 9, 8, -5, 1};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        ordena(arr, arr2);
    }

    static void ordena(int[] arr, int[] arr2) {
        int canviaDreta;
        int canviaEsquerra;
        for (int dreta = arr.length-1; dreta > 0; dreta--) {
            if (arr[dreta] < arr[dreta-1]){
                canviaDreta = arr[dreta];
                arr[dreta] = arr[dreta-1];
                arr[dreta-1] = canviaDreta;
            }
            for (int esquerra = 0; esquerra < arr.length-1; esquerra++) {
                if (arr[esquerra] > arr[esquerra+1]) {
                    canviaEsquerra = arr[esquerra];
                    arr[esquerra] = arr[esquerra+1];
                    arr[esquerra+1] = canviaEsquerra;
                }
            }
        }
        System.out.println("Original: " + Arrays.toString(arr2));
        System.out.print("Ordenada: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
