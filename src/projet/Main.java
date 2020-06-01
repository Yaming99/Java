package projet;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        list.add("test6");

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
