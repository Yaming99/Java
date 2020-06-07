package projet.graphic;

import projet.EnsJoueurs;
import projet.Joueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Vector;


public class front extends JFrame {


    private JPanel NomJoueur;
    private JPanel Phase1;
    private JPanel frontGame;
    private JLabel J1Choix;
    private JButton buttest;

   /** Variable pour la définition du nom des joueurs**/
    private JLabel J2Choix;
    private JLabel J3Choix;
    private JLabel ChoixJ4;
    private JButton ChoixJButton;
    private JTextField textFieldJ1;
    private JTextField textFieldJ3;
    private JTextField textFieldJ2;
    private JTextField textFieldJ4;

    private Vector<Joueur> ListeJ = new Vector<>(20);
    private int numJoueurs = 0;
    private EnsJoueurs PlayerManche = new EnsJoueurs();
    private EnsJoueurs Participants = new EnsJoueurs();

    public front() throws IOException, ClassNotFoundException {

        this.setContentPane(NomJoueur);
        this.setSize(500,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        saisisNom();
    }



    /** Permet de modifier les noms des joueurs séléctionnés**/
    private void saisisNom() throws IOException, ClassNotFoundException {
        File fichier = new File("src/projet/joueur/listeJoueurs.txt");
        /** lecture du fichier**/
        ObjectInputStream b = new ObjectInputStream(new FileInputStream(fichier));
        ListeJ = (Vector<Joueur>) b.readObject();//on récupère toutes la liste des participants sauvegardée
        /** lecture du fichier**/
        Participants.creer(ListeJ);             //on fait de cette liste un ensemble de joueurs
        Participants.afficher();
        Vector<Joueur> ListeP = new Vector<>(4); //on séléctionne 4 joueurs dans la liste qui vont devoir s'affronter
        for(int i=0; i<4;i++){
            int x = 0;
            Joueur selection = Participants.selectionnerJoueur();
            while(x == 0){                                      // on vérifie qu'on ne peut pas sélectionner deux fois le meme joueur
                if(!ListeP.contains(selection)){
                    x=1;
                }else{
                    selection = Participants.selectionnerJoueur();
                }
            }
        ListeP.add(selection);
        }
                //on crée un autre ensemble de joueurs, qui nous permettra de ne traiter que
        PlayerManche.creer(ListeP);                            // les joueurs séléctionné. Toutes modifications faites sur un joueurs de cette liste se fera aussi sur le joueur
        ChoixJButton.addActionListener(new ActionListener() {   // de la liste principale
            @Override
            public void actionPerformed(ActionEvent actionEvent) {  // on récupère les noms
                if (!textFieldJ1.getText().equals("")){
                    PlayerManche.getJoueur(0).setNom(textFieldJ1.getText());
                }
                if (!textFieldJ2.getText().equals("")){
                    PlayerManche.getJoueur(1).setNom(textFieldJ2.getText());
                }
                if (!textFieldJ3.getText().equals("")){
                    PlayerManche.getJoueur(2).setNom(textFieldJ3.getText());
                }
                if (!textFieldJ4.getText().equals("")){
                    PlayerManche.getJoueur(3).setNom(textFieldJ4.getText());
                }

                PlayerManche.afficher();
                Participants.afficher();
                try {
                    Phase1();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void Phase1() throws IOException, ClassNotFoundException {
        this.setContentPane(Phase1);
        this.setSize(500,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

