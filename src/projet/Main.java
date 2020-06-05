package projet;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main implements Serializable {

    public static void main(String[] args)  throws IOException, ClassNotFoundException{

        ArrayList<String> list;

        /** créaation fichier theme **/
//        list.add("Histoire");
//        list.add("Geographie");
//        list.add("Voiture");
//        list.add("Mathématiques");
//        list.add("Francais");
//        list.add("Cuisine");

        File fichier = new File("src/projet/themesQ/themes.txt");
//        ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(fichier));
//        a.writeObject(list);

        ObjectInputStream b = new ObjectInputStream(new FileInputStream(fichier));
        list = (ArrayList<String>) b.readObject();
        Themes themes = new Themes(list);
        themes.afficher();
        themes.modifierTheme();
        themes.afficher();
        themes.selectionnerTheme();
        themes.afficher();
        System.out.println("Selection de 5 th\u00e8mes random :");
        System.out.println(themes.selectionnerCinqThemes());

        Question<QCM> quest1 = new Question<>(new QCM("Ma question 1", list, "test1"),1 , "theme");
        quest1.afficher();
        quest1.saisir();
        Question<VF> quest2  = new Question<>(new VF("Ma question 2", true), 1, "theme");
        quest2.afficher();
        quest2.saisir();
        Question<RC> quest3  = new Question<>(new RC("Ma question 3", "Rep"), 1, "theme");
        quest3.afficher();
        quest3.saisir();

        LinkedList<Question<? extends QType>> qList = new LinkedList<>();

        qList.add(quest1);
        qList.add(quest2);
        qList.add(quest3);

        ListeQuestions listeQuestions = new ListeQuestions(qList);
        listeQuestions.ajouterQuestion(quest1);
        listeQuestions.supprimerQuestion();
        listeQuestions.afficherListe();
    }
}
