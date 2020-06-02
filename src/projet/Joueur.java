package projet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//test
public class Joueur {
    private static int numero = 90;
    private static char nom = 64; // '@' ascii
    private int score = 0;
    private String etat = "en attente";
    private ArrayList<String> listeEtats = new ArrayList<>(Arrays.asList("s\u00e9lectionn\u00e9", "gagnant", "super gagnant", "\u00e9limin\u00e9", "en attente"));

    public Joueur() {
        numero += 10;
        nom++;
    }

    public void saisir() {
        // TODO saisir quoi ???????????
    }

    public void afficher() {
        System.out.println("Joueur :");
        System.out.println("N° " + numero);
        System.out.println("Nom   : " + nom);
        System.out.println("Score : " + this.score);
        System.out.println("Etat  : " + this.etat);
    }

    public void changerEtat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisissez l'\u00e9tat :");
        String etat = sc.nextLine();
        if (!listeEtats.contains(etat)) {
            throw new NullPointerException("Mauvais \u00e9tat !");
        }
        this.etat = etat;
    }

    public void majScore(int score) {
        if (score <= 0) {
            return;
        }
        this.score += score;
    }
}
