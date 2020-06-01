package projet;

public class RC implements QType {
    private String texte;
    private String bonneRep;

    public RC(String texte, String bonneRep) {
        // Check l'input de l'user
        if (texte == null || bonneRep == null) {
            throw new NullPointerException("Votre input est null !");
        }
        // pas de texte pour la question ou pas de reponse
        if (texte.isBlank() || bonneRep.isBlank()) {
            throw new IllegalArgumentException("Input pour le texte ou la bonne r\u00e9ponse est vide.");
        }
        this.texte = texte;
        this.bonneRep = bonneRep;
    }

    @Override
    public String toString() {
        return texte;
    }

    @Override
    public void afficher() {
        System.out.println(toString());
        System.out.println("Votre r\u00e9ponse :");
    }

    @Override
    public boolean check(String reponse) {
        return reponse.equals(this.bonneRep);
    }
}
