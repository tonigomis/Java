import java.util.Arrays;

/**
 * Created by toni on 08/11/16.
 */
public class copiaArrayE8 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr2 = new int[arr.length][arr.length];
        System.out.println(Arrays.deepToString(arr2));
        copiaArray(arr,arr2);
        System.out.println(Arrays.deepToString(arr2));
    }

    static int[][] copiaArray(int[][] arr, int[][] arr2) {
        System.arraycopy(arr, 0, arr2, 0, arr[0].length-1);
        return arr2;
    }
}
