import java.util.Scanner;

/**
 * Created by toni on 14/11/16.
 */
public class lastTryE13 {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Aquest programa serveix per determinar els pesos de cada part de \nl'avaluació, introduir les notes i obtenir una mitjana ponderada.");
        double[] pesos = new double[3];
        double notaPractiques = 0;
        double notaExamens = 0;
        double notaExercicis = 0;
        menu(pesos, notaPractiques, notaExamens, notaExercicis);
    }

    static void menu(double[] pesos, double notaPractiques, double notaExamens, double notaExercicis) {
        boolean[] comprova = new boolean[4];
        try {
            boolean opt = true;
            int opcio;
            do {
                System.out.println(
                        "  ________________________________________________  \n" +
                        " | Què vols fer?                                  | \n" +
                        " | 1.- Establir els pesos de les parts a avaluar: | \n" +
                        " | 2.- Introduir les notes de les pràctiques:     | \n" +
                        " | 3.- Introduir notes dels examens:              | \n" +
                        " | 4.- Introduir les notes dels exercicis:        | \n" +
                        " | 5.- Calcular la mitjana ponderada:             | \n" +
                        " | 6.- Comprovar l'estat del programa:            | \n" +
                        " | 0.- Sortir.                                    | \n" +
                        "  ------------------------------------------------\n");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1:
                        fixaPesos();
                        comprova[0] = true;
                        break;
                    case 2:
                        notesPractiques(pesos);
                        comprova[1] = true;
                        break;
                    case 3:
                        notesExamens(notaPractiques, pesos);
                        comprova[2] = true;
                        break;
                    case 4:
                        notesExercicis(notaPractiques, notaExamens, pesos);
                        comprova[3] = true;
                        break;
                    case 5:
                        if (comprova[0] && comprova[1] && comprova[2] && comprova[3]) {
                            calculaMitjana(notaPractiques, notaExamens, notaExercicis, pesos);
                            break;
                        } else {
                            System.out.println("Has de completar totes les passes prèvies!");
                            break;
                        }
                    case 6:
                        System.out.print(comprova[0] ? "Pesos ok!\n" : "Falta assignar pesos!\n");
                        System.out.print(comprova[1] ? "Pràctiques ok!\n" : "Falten les notes de les pràctiques!\n");
                        System.out.print(comprova[2] ? "Examens ok!\n" : "Falten les notes dels examens!\n");
                        System.out.print(comprova[3] ? "Exercicis ok!\n" : "Falten les notes dels exercicis!\n");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            System.out.println("S'ha produït un error!");
                        }
                        break;
                    case 0:
                        System.out.println("Adéu!");
                        opt = false;
                        break;
                    default:
                        System.out.println("Has de triar una opció vàlida!\n");
                        break;
                }
            } while (opt);
        } catch (Exception e) {
            System.out.println("S'ha produït un error!");
        }
    }

    static double[] fixaPesos() {
        double[] pesos = new double[3];
        double total;
        System.out.println("Estableix els pesos de les parts de l'avaluació: ");
        System.out.println("Pràctiques: ");
        pesos[0] = s.nextDouble();
        System.out.println("Examens: ");
        pesos[1] = s.nextDouble();
        System.out.println("Exercicis: ");
        pesos[2] = s.nextDouble();
        total = pesos[0] + pesos[1] + pesos[2];
        for (int i = 0; i < pesos.length; i++) {
            pesos[i] /= total;
        }
        notesPractiques(pesos);
        return pesos;
    }

    static double notesPractiques(double[] pesos) {
        int sumaPractiques = 0;
        int numNotes, nota;
        double notaPractiques;
        System.out.println("Quantes notes de pràctiques vols introduir?");
        numNotes = s.nextInt();
        System.out.println("Introdueix les notes: ");
        int i = 0;
        while (i < numNotes) {
            nota = s.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("Introdueix una nota vàlida!");
                continue;
            }
            sumaPractiques += nota;
            i++;
        }
        notaPractiques = sumaPractiques / numNotes;
        notesExamens(notaPractiques, pesos);
        return notaPractiques;
    }

    static double notesExamens(double notaPractiques, double[] pesos) {
        int sumaExamens = 0;
        int numNotes;
        int nota;
        double notaExamens;
        System.out.println("Quantes notes d'examen vols introduir?");
        numNotes = s.nextInt();
        System.out.println("Introdueix les notes: ");
        int i = 0;
        while (i < numNotes) {
            nota = s.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("Introdueix una nota vàlida!");
                continue;
            }
            sumaExamens += nota;
            i++;
        }
        notaExamens = sumaExamens / numNotes;
        notesExercicis(notaPractiques, notaExamens, pesos);
        return notaExamens;
    }

    static double notesExercicis(double notaPractiques, double notaExamens, double[] pesos) {
        int sumaExercicis = 0;
        int numNotes;
        int nota;
        double notaExercicis;
        System.out.println("Quantes notes d'exercicis vols introduir?");
        numNotes = s.nextInt();
        System.out.println("Introdueix les notes: ");
        int i = 0;
        while (i < numNotes) {
            nota = s.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("Introdueix una nota vàlida!");
                continue;
            }
            sumaExercicis += nota;
            i++;
        }
        notaExercicis = sumaExercicis/numNotes;
        calculaMitjana(notaPractiques, notaExamens, notaExercicis, pesos);
        return notaExercicis;
    }

    static void calculaMitjana(double notaPractiques, double notaExamens, double notaExercicis, double[] pesos) {
        double t1 = notaPractiques * pesos[0];
        double t2 = notaExamens * pesos[1];
        double t3 = notaExercicis * pesos[2];
        double notaMitjana = t1 + t2 + t3;
        System.out.printf("La nota mitjana de l'assignatura és: %.03f\n", notaMitjana);
    }
}


// Si no crid la següent funció dins cadascuna d'elles no funciona, em dóna una nota mitjana de 0,0.
// En canvi, si execut el programa encadenat sí que obtenc el resultat esperat (però fa inútil el menú i la comprovació.
// So... Why? :~(