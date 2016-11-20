import java.util.Scanner;

/**
 * Created by toni on 10/11/16.
 */
public class ProvesE13 {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        double[] pesos = new double[3];
        //menu(pesos, notaExercicis, notaExamens, notaPractiques);
    }

    static void menu(double[] pesos, double notaExercicis, double notaExamens, double notaPractiques) {
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
                        "  ------------------------------------------------");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1:
                        fixaPesos(s, pesos);
                        comprova[0] = true;
                        break;
                    case 2:
                        notesPractiques();
                        comprova[1] = true;
                        break;
                    case 3:
                        notesExamen();
                        comprova[2] = true;
                        break;
                    case 4:
                        notesExercicis();
                        comprova[3] = true;
                        break;
                    case 5:
                        if (comprova[0] && comprova[1] && comprova[2] && comprova[3]) {
                            calculaMitjana(pesos, notaExercicis, notaExamens, notaPractiques);
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

    static double notesPractiques() {
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
        notaPractiques = resultatsPractiques[0] / resultatsPractiques[1];
        return notaPractiques;
    }

    static double notesExamen() {
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
        notaExamens = resultatsExamens[0] / resultatsExamens[1];
        return notaExamens;
    }

    static double notesExercicis() {
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
        notaExercicis = resultatsExercicis[0]/resultatsExercicis[1];
        return notaExercicis;

    }

    static double[] fixaPesos(Scanner s, double[] pesos) {
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
        return pesos;
    }

    static void calculaMitjana(double[] pesos, double notaExercicis, double notaExamens, double notaPractiques) {
        try {
            System.out.println(notesExercicis());
            System.out.println(notesPractiques());
            System.out.println(notesExamen());
        } catch (Exception e) {
            System.out.println("Aquí!");
        }


    }

}
