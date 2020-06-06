package projet.graphic;

import projet.EnsJoueurs;
import projet.Joueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class front extends JFrame {

    private JPanel NomJoueur;
    private JPanel Phase1;
    private JPanel frontGame;
    private JLabel J1Choix;


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

    public front(){
        this.setContentPane(NomJoueur);
        this.setSize(500,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        saisisNom();


    }

    private void saisisNom(){
        ChoixJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                initJ(textFieldJ1, textFieldJ2);
                initJ(textFieldJ3, textFieldJ4);
                EnsJoueurs Participants = new EnsJoueurs();
                Participants.creer(ListeJ);
                Participants.afficher();
            }
        });
    }

    private void initJ(JTextField textFieldJ3, JTextField textFieldJ4) {
        if (!textFieldJ3.getText().equals("")){
            Joueur J3 = new Joueur(textFieldJ3.getText(),numJoueurs);
            ListeJ.add(J3);
            numJoueurs+=10;
        }
        if (!textFieldJ4.getText().equals("")){
            Joueur J4 = new Joueur(textFieldJ4.getText(),numJoueurs);
            ListeJ.add(J4);
            numJoueurs+=10;
        }
    }
}

