package projet;

import java.util.Vector;

public class EnsJoueurs {
    private Vector<Joueur> vector;

    public EnsJoueurs(Vector<Joueur> vector) {
        this.vector = vector;
    }

    public EnsJoueurs creer(int nombre) {
        Vector<Joueur> vector = new Vector<>();
        for (int i = 0; i < nombre; i++) {
            vector.add(new Joueur());
        }
        return new EnsJoueurs(vector);
    }

    public void afficher() {
        System.out.println("Liste des joueurs :");
        vector.forEach(Joueur::afficher);
    }

    public Joueur selectionnerJoueur() {
        int random = (int) (Math.random() * 100) % vector.size();
        return vector.get(random);
    }
}
