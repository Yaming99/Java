package projet;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main implements Serializable {

    public static void main(String[] args)  throws IOException, ClassNotFoundException{

        ArrayList<String> list;

        /** création fichier theme **/
//        list.add("Histoire");
//        list.add("Geographie");
//        list.add("Voiture");
//        list.add("Mathématiques");
//        list.add("Francais");
//        list.add("Cuisine");

        File fichier = new File("src/projet/themesQ/themes.txt");
//        ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(fichier));
//        a.writeObject(list);

        ObjectInputStream b = new ObjectInputStream(new FileInputStream(fichier)); /** lecture du fichier**/
        list = (ArrayList<String>) b.readObject();                                 /** lecture du fichier**/
        Themes themes = new Themes(list);
        themes.afficher();
//        themes.modifierTheme();
//        themes.afficher();
//        themes.selectionnerTheme();
//        themes.afficher();
        System.out.println("Selection de 5 th\u00e8mes random :");
        System.out.println(themes.selectionnerCinqThemes());


        /** Initialisation des questions, adapter en fonction du thèmes et des questions**/
//        ArrayList<String>  liste= new  ArrayList<String>();
//        liste.add("sucre");
//        liste.add("beurre");
//        liste.add("ciment");
//        Question<QCM> quest1 = new Question<>(new QCM("Quel element n'est aps necessaire dans un gateau ?", liste, "ciment"),1 , "Cuisine");
//        quest1.afficher();
//        quest1.saisir();
//        Question<VF> quest2  = new Question<>(new VF("Le poulet basquaise vient de la région parisienne", false), 2, "Cuisine");
//        quest2.afficher();
//        quest2.saisir();
//        Question<RC> quest3  = new Question<>(new RC("Quel instrument sert a battre des oeufs ? ", "unfouet"), 3, "Cuisine");
//        quest3.afficher();
//        quest3.saisir();
//
          LinkedList<Question<? extends QType>> qList = new LinkedList<>();
//
//        qList.add(quest1);
//        qList.add(quest2);
//        qList.add(quest3);

        //ListeQuestions listeQuestions = new ListeQuestions(qList);
//        listeQuestions.ajouterQuestion(quest1);
//        listeQuestions.supprimerQuestion();
//        listeQuestions.afficherListe();

        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Cuisine.txt");
//        ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(fichier));
//        a.writeObject(qList);

         b = new ObjectInputStream(new FileInputStream(fichier));     /** lecture du fichier**/
         qList = (LinkedList<Question<? extends QType>>) b.readObject(); /** lecture du fichier**/
        ListeQuestions listeQuestions = new ListeQuestions(qList);
        listeQuestions.afficherListe();
        qList.get(1).afficher();
        qList.get(1).saisir();
//TODO gérer la récupération des questions en fonction du thème choisi, initialiser suffisament de questions par thèmes
    }
}
