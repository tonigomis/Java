import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by toni on 14/11/16.
 */
public class simplificacioE13 {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Aquest programa serveix per determinar els pesos de cada part de \nl'avaluació, introduir les notes i obtenir una mitjana ponderada.\n");
        fixaPesos();
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
        int[] notesPractiques = new int[numNotes];
        System.out.println("Introdueix les notes: ");
        int i = 0;
        while (i < numNotes) {
            nota = s.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("Introdueix una nota vàlida!");
                continue;
            }
            sumaPractiques += nota;
            notesPractiques[i] = nota;
            i++;
        }
        int[] resultatsPractiques = new int[2];
        resultatsPractiques[1] = numNotes;
        resultatsPractiques[0] = sumaPractiques;
        notaPractiques = (double) resultatsPractiques[0] / resultatsPractiques[1];
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
        int[] notesExamen = new int[numNotes];
        System.out.println("Introdueix les notes: ");
        int i = 0;
        while (i < numNotes) {
            nota = s.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("Introdueix una nota vàlida!");
                continue;
            }
            sumaExamens += nota;
            notesExamen[i] = nota;
            i++;
        }
        int[] resultatsExamens = new int[2];
        resultatsExamens[1] = numNotes;
        resultatsExamens[0] = sumaExamens;
        notaExamens = (double) resultatsExamens[0] / resultatsExamens[1];
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
        int[] notesExercicis = new int[numNotes];
        System.out.println("Introdueix les notes: ");
        int i = 0;
        while (i < numNotes) {
            nota = s.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("Introdueix una nota vàlida!");
                continue;
            }
            sumaExercicis += nota;
            notesExercicis[i] = nota;
            i++;
        }
        int[] resultatsExercicis = new int[2];
        resultatsExercicis[1] = numNotes;
        resultatsExercicis[0] = sumaExercicis;
        notaExercicis = (double) resultatsExercicis[0]/resultatsExercicis[1];
        calculaMitjana(notaPractiques, notaExamens, notaExercicis, pesos);
        return notaExercicis;
    }

    static void calculaMitjana(double notaPractiques, double notaExamens, double notaExercicis, double[] pesos) {
        double t1 = notaPractiques * pesos[0];
        double t2 = notaExamens * pesos[1];
        double t3 = notaExercicis * pesos[2];
        double notaMitjana = t1 + t2 + t3;
        System.out.printf("La nota mitjana de l'assignatura és: %.03f", notaMitjana);
    }
}
