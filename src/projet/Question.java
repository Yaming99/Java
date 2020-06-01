package projet;

import java.util.Scanner;

public class Question<T extends QType> {
    private T texte;
    private int niveau;
    private static int nb = 0;
    private String theme;

    public void afficher() {
        texte.afficher();
    }

    public int getNb() {
        return nb;
    }

    public boolean saisir() {
        boolean bonneRep;
        System.out.println("Saisir la r\u00e9ponse : ");
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();
        bonneRep = texte.check(reponse);
        if (bonneRep) System.out.println("R\u00e9ponse : " + "correcte.");
        else System.out.println("R\u00e9ponse : " + "fausse.");
        return bonneRep;
    }

    public Question(T texte, int niveau, String theme) {
        // texte ou theme vide ou null
        if (theme.isBlank() || texte == null || theme == null) {
            throw new NullPointerException("Input vide.");
        }
        else if (niveau > 3 || niveau < 1) {
            throw new IllegalArgumentException("Niveau : de 1 \u00e0 3 seulement.");
        }
        this.texte = texte;
        this.niveau = niveau;
        nb++;
        this.theme = theme;
    }

    public int getNiveau() {
        return niveau;
    }
}
