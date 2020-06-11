package projet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The type Joueur.
 */
public class Joueur implements Serializable {
    private int numero = 100;
    //    private char nom = 64; // '@' ascii
    private String nom;
    private int score = 0;
    private String etat = "en attente";
    private ArrayList<String> listeEtats = new ArrayList<>(Arrays.asList("s\u00e9lectionn\u00e9", "gagnant", "super gagnant", "\u00e9limin\u00e9", "en attente"));
    private static final long serialVersionUID = 8707119228364053775L;

    /**
     * Instantiates a new Joueur.
     */
    public Joueur() {
        numero += 10;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Instantiates a new Joueur.
     *
     * @param nomJ the nom j
     * @param numJ the num j
     */
    public Joueur(String nomJ, int numJ) {
        numero += numJ;
        nom = nomJ;
    }

    /**
     * Sets etat.
     *
     * @param etat the etat
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * Saisir boolean.
     *
     * @param Question the question
     * @return the boolean
     */
    public boolean saisir(Question Question) {
        System.out.println("Saisir la r\u00e9ponse : ");
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();
        return Question.saisir(reponse);
    }

    /**
     * Afficher.
     */
    public void afficher() {
        System.out.println("Joueur :");
        System.out.println("N° " + numero);
        System.out.println("Nom   : " + nom);
        System.out.println("Score : " + this.score);
        System.out.println("Etat  : " + this.etat);
    }

    /**
     * Gets etat.
     *
     * @return the etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * Changer etat.
     */
    public void changerEtat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisissez l'\u00e9tat :");
        String etat = sc.nextLine();
        if (!listeEtats.contains(etat)) {
            throw new NullPointerException("Mauvais \u00e9tat !");
        }
        this.etat = etat;
    }

    /**
     * Gets numero.
     *
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }


    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(int score) {
        this.score += score;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }
}
