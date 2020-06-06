package projet;

import projet.graphic.front;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //initialisation();
//        testSerialization();
        testGraphe();
    }

    private static void testGraphe(){
        front f = new front();
    }

    private static void initialisation()  throws IOException, ClassNotFoundException{
        ArrayList<String> list = new ArrayList<>();

        /** création fichier theme **/
        list.add("Histoire");
        list.add("Geographie");
        list.add("Voiture");
        list.add("Mathématiques");
        list.add("Francais");
        list.add("Cuisine");

        File fichier = new File("src/projet/themesQ/themes.txt");
        ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(list);

        /** Initialisation des questions, adapter en fonction du thèmes et des questions**/
        ArrayList<String>  liste= new  ArrayList<String>();
        liste.add("Marignan");
        liste.add("Verdun");
        liste.add("Paris");
        Question<QCM> quest1 = new Question<>(new QCM("Ou a eut lieu la bataille de 1515 ?", liste, "Marignan"),1 , "Histoire");
//        quest1.afficher();
//        quest1.saisir();
        Question<VF> quest2  = new Question<>(new VF("Les girondins sont un mouvement des lumières ", false), 2, "Histoire");
//        quest2.afficher();
//        quest2.saisir();
        Question<RC> quest3  = new Question<>(new RC("Comment appel t'on le fils héritier du roi de france", "ledauphin"), 3, "Histoire");
//        quest3.afficher();
//        quest3.saisir();

        LinkedList<Question<? extends QType>> qList = new LinkedList<>();

        qList.add(quest1);
        qList.add(quest2);
        qList.add(quest3);


        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Histoire.txt");
        a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(qList);
    }

    private static void testSerialization()  throws IOException, ClassNotFoundException {
        ArrayList<String> list;

        File fichier = new File("src/projet/themesQ/themes.txt");
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

        LinkedList<Question<? extends QType>> qList;


        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Histoire.txt");

        b = new ObjectInputStream(new FileInputStream(fichier));     /** lecture du fichier**/
        qList = (LinkedList<Question<? extends QType>>) b.readObject(); /** lecture du fichier**/
        ListeQuestions listeQuestions = new ListeQuestions(qList);
        listeQuestions.afficherListe();
        qList.get(1).afficher();
        qList.get(1).saisir();
    }
}
