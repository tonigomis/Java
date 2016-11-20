import java.util.Scanner;
/**
* Created by toni on 13/11/16.
*/
public class prova3E13 {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args){
        menu();
    }


    static void calculaMitjana(double notaTotalPractiques, double notaTotalExamens, double notaTotalExercicis, double[] pesos, double resultat, double pesPractiques, double pesExamens, double pesExercicis) {
        pesPractiques = notaTotalPractiques * pesos[0];
        pesExamens = notaTotalExamens * pesos[1];
        pesExercicis = notaTotalExercicis * pesos[2];
        resultat =  pesPractiques + pesExamens + pesExercicis;
        System.out.println("La mitjana ponderada és: " + resultat);
    }

    static void menu() {
        boolean[] comprova = new boolean[4];
        double notaTotalPractiques = 0;
        double notaTotalExamens = 0;
        double notaTotalExercicis = 0;
        double resultat = 0;
        double pesPractiques = 0;
        double pesExamens = 0;
        double pesExercicis = 0;
        double[] pesos = new double[3];
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
                        fixaPesos(pesos);
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
                        //if (comprova[0] && comprova[1] && comprova[2] && comprova[3]) {
                            calculaMitjana(notaTotalPractiques, notaTotalExamens, notaTotalExercicis, pesos, pesPractiques, pesExamens, pesExercicis, resultat);

                            break;
                       /* } else {
                            System.out.println("Has de completar totes les passes prèvies!");
                            break;
                        }*/
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
        int numNotes, nota;
        double notaTotalPractiques = 0;
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
            notaTotalPractiques += nota;
            i++;
        }
        notaTotalPractiques /= numNotes;
        return notaTotalPractiques;
    }

    static double notesExamen() {
        int numNotes, nota;
        double notaTotalExamens = 0;
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
            notaTotalExamens += nota;
            i++;
        }
        notaTotalExamens /= numNotes;
        return notaTotalExamens;
    }

    static double notesExercicis() {
        int numNotes, nota;
        double notaTotalExercicis = 0;
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
            notaTotalExercicis += nota;
            i++;
        }
        notaTotalExercicis /= numNotes;
        return notaTotalExercicis;
    }

    static double[] fixaPesos(double[] pesos) {
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

}
