/**
 * Created by toni on 13/11/16.
 */
public class provaRetorn {
    public static void main(String[] args) {
        System.out.println(funció());

    }

    static int valorsA() {
        int a = 2;
        return a;
    }

    static int valorsB() {
        int b = 21;
        return b;
    }

    static double funció() {
        return Math.pow(valorsA(),valorsB());
    }
}
