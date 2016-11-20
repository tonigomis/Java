/**
 * Created by toni on 17/11/16.
 */
public class duplicatsE17 {
    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 3, 1, 8, 2, 9, 4};
        duplicats(arr);
    }

     static void duplicats(int[] arr) {
         for (int i = 0; i < arr.length ; i++) {
             for (int j = 1; j < arr.length; j++) {
                 if (arr[i] == arr[j]){
                     System.out.println(" Hi ha un element duplicat: " + arr[i]);
                     return;
                 }
             }
         }
    }
}
