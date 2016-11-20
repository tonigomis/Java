import java.util.Scanner;

/**
 * Created by toni on 02/11/16.
 */
public class distanciaEuclidianaE3 {
    public static void main(String[] args) {

        // Cream un objecte Scanner per poder introduir qualsevol adreça a l'eix de coordenades
        Scanner s = new Scanner(System.in);

        // Declaram i inicialitzam les dues arrays amb què hem de treballar
        double[] x = new double[2];
        double[] y = new double[2];

/*      Aquestes arrays amb inicialització explícita són aquí per si es vol executar el programa sense haver d'introduir
        res a través d'Scanner.
        double[] x = {2, 5};
        double[] y = {-3, 4};*/

        // Cridam la funció que ens permetrà inserir valors dins ambdues arrays, passant-les per paràmetre juntament amb l'objecte Scanner.
        emplenaArrays(x, y, s);

        // Imprimim el resultat obtingut amb un format apropiat, a la vegada que executam la funció que ens calcularà la distància euclidiana.
        System.out.printf("La distància euclidiana en un plànol cartesià entre els punts (%.0f, %.0f) i (%.0f, %.0f) " +
                "és %.3f", x[0], x[1], y[0], y[1], calcula(x, y));
    }

    static void emplenaArrays(double[] x, double[] y, Scanner s) {

        // Declaram les variables dels bucles dins el mètode, perquè les necessitarem més endavant com a paràmetres
        int i, j;

/*        Aquest primer bucle ens demana els valors que corresponen a la primera array i els col·loca al seu lloc. A més,
        segons el valor de la iteració ens recuperarà un o un altre nom per al valor a introduïr.*/
        for (i = 0; i < x.length; i++) {
            System.out.println("Introdueix el valor de " + valorX(i) + ":");
            x[i] = s.nextDouble();
        }

        // El segon bucle fa exactament el mateix amb l'array de Y
        for (j = 0; j < y.length; j++) {
            System.out.println("Introdueix el valor de " + valorY(j) + ":");
            y[j] = s.nextDouble();
        }
    }

    // Aquestes dues senzilles funcions ens retornen el nom de la posició de l'array segons la iteració i el bucle on es trobin
    static String valorX(int i) {
        switch (i) {
            case 0:
                return "x1";
            case 1:
                return "y1";
        }
        return null;
    }

    static String valorY(int j) {
        switch (j) {
            case 0:
                return "x2";
            case 1:
                return "y2";
        }
        return null;
    }

    // Passam els dos arrays per paràmetre i ens retornen la distància euclidiana, en una sola línia
    static double calcula(double[] x, double[] y) {
        return Math.sqrt(Math.pow((x[0] - y[0]), 2) + (Math.pow((x[1] - y[1]), 2)));
    }
}