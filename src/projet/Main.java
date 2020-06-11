package projet;

import projet.graphic.ThemeVue;
import projet.graphic.front;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * The type Main.
 */
public class Main implements Serializable {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        initialisationthemesQ();
        //testSerialization();
        Vector<Joueur> vector = initialisationjoueurs();
        start(vector);

        //testThemeVue();

    }

    public static void start(Vector<Joueur> vector) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());
        JButton jouer = new JButton("Jouer au jeu");
        JButton menu = new JButton("Menu th\u00e8me");
        JButton afficheJoueurs = new JButton("Afficher la liste des joueurs");
        JButton quit = new JButton("Quitter");
        // ajout au panel
        panel.add(jouer);
        panel.add(menu);
        panel.add(afficheJoueurs);
        panel.add(quit);
        // config taille et position
        jouer.setBounds(50, 20, 190, 30);
        menu.setBounds(50, 80, 190, 30);
        afficheJoueurs.setBounds(50, 140, 190, 30);
        quit.setBounds(50, 200, 190, 30);
        frame.setContentPane(panel);
        frame.getContentPane().setLayout(null);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("JAVA - Quizz");
        jouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                try {
                    testGraphe();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                // TODO ta fonction pour demarrer le jeu
            }
        });
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                new ThemeVue();
            }
        });
        afficheJoueurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EnsJoueurs ensJoueurs = new EnsJoueurs();
                ensJoueurs.creer(vector);
                frame.dispose();
                ensJoueurs.fillTable();
            }
        });
        quit.addActionListener(actionEvent -> System.exit(0));
    }

    private static void testThemeVue() {
        ThemeVue t = new ThemeVue();
    }

    private static void testGraphe() throws IOException, ClassNotFoundException {

        front f = new front();
    }

    public static Vector<Joueur> initialisationjoueurs() throws IOException {
        Vector<Joueur> ListeJ = new Vector<>(20);
        int numJoueurs = 0;
        char nomJ = 65;//'@' ascii
        int i;
        for (i = 0; i <= 19; i++) {
            Joueur J3 = new Joueur(Character.toString(nomJ), numJoueurs);
            ListeJ.add(J3);
            numJoueurs += 10;
            nomJ += 1;
        }
        File fichier = new File("src/projet/joueur/listeJoueurs.txt");
        ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(ListeJ);
        return ListeJ;
    }


    private static void initialisationthemesQ()  throws IOException{
        ArrayList<String> list = new ArrayList<>();

        /**------------------------------------création fichier theme-------------------------------------**/
        list.add("Histoire");
        list.add("Geographie");
        list.add("Automobile");
        list.add("Mathematiques");
        list.add("Francais");
        list.add("Cuisine");
        list.add("Sport");
        list.add("Politique");
        list.add("Animaux");
        list.add("Astronomie");

        File fichier = new File("src/projet/themesQ/themes.txt");
        ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(list);

        /** Initialisation des questions, adapter en fonction du thèmes et des questions**/


        /**------------------------------------initialisation questions Histoire-------------------------------------**/

        ArrayList<String>  listeH= new  ArrayList<String>();
        listeH.add("Marignan");
        listeH.add("Verdun");
        listeH.add("Paris");
        Question<QCM> questH1 = new Question<>(new QCM("Ou a eut lieu la bataille de 1515 ?", listeH, "Marignan"),1 , "Histoire");
        ArrayList<String>  listeH2= new  ArrayList<String>();
        listeH2.add("Hamid Karzai ");
        listeH2.add("Hosni Moubarak");
        listeH2.add("Pervez Musharraf");
        Question<QCM> questH4 = new Question<>(new QCM("Quel président égyptien a dû abandonner le pouvoir en 2011, suite au Printemps arabe ?", listeH2, "Hosni Moubarak"),2 , "Histoire");
        ArrayList<String>  listeH3= new  ArrayList<String>();
        listeH3.add("Janvier");
        listeH3.add("Mai");
        listeH3.add("Août");
        Question<QCM> questH7 = new Question<>(new QCM("Lors de quel mois de l’année 1789, la Révolution française a-t-elle débuté avec l’ouverture des États généraux ?", listeH3, "Mai"),3 , "Histoire");
        Question<VF> questH2  = new Question<>(new VF("Les girondins sont un mouvement des lumières ", false), 1, "Histoire");
        Question<VF> questH5  = new Question<>(new VF("La revolte des Boxers a eut lieu en Chine ", true), 2, "Histoire");
        Question<VF> questH8  = new Question<>(new VF("Fidel Castro a destitue Marcos Perez Jimenez en 1959", false), 3, "Histoire");
        Question<RC> questH3  = new Question<>(new RC("Comment appel t'on le fils héritier du roi de france", "ledauphin"), 3, "Histoire");
        Question<RC> questH6  = new Question<>(new RC("Qui fut execute apres la révolution francaise le 16 octobre 1793 ?", "Lareine"), 2, "Histoire");
        Question<RC> questH9  = new Question<>(new RC("Qui fur le premier roi de france ?", "clovis"), 3, "Histoire");
        LinkedList<Question<? extends QType>> qListH = new LinkedList<>();

        qListH.add(questH1);
        qListH.add(questH2);
        qListH.add(questH3);
        qListH.add(questH4);
        qListH.add(questH5);
        qListH.add(questH6);
        qListH.add(questH7);
        qListH.add(questH8);
        qListH.add(questH9);

        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Histoire.txt");//Creation du fichier de question pour un thème
        a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(qListH);

        /**------------------------------------initialisation questions Geographie-------------------------------------**/

        ArrayList<String>  listeG= new  ArrayList<String>();
        listeG.add("55");
        listeG.add("75");
        listeG.add("110");
        Question<QCM> questG1 = new Question<>(new QCM("La densité moyenne d'habitants au km carré en France est de :", listeG, "110"),1 , "Geographie");
        ArrayList<String>  listeG2= new  ArrayList<String>();
        listeG2.add("La Volga");
        listeG2.add("Le Danube");
        listeG2.add("Le Rhin");
        Question<QCM> questG4 = new Question<>(new QCM("Le fleuve le plus long d'Europe est :", listeG2, "La Volga"),2 , "Geographie");
        ArrayList<String>  listeG3= new  ArrayList<String>();
        listeG3.add("1896");
        listeG3.add("1906");
        listeG3.add("1926");
        Question<QCM> questG7 = new Question<>(new QCM("Le tremblement de terre qui a détruit la ville de San Francisco et fait au moins 1 000 morts a eu lieu en :", listeG3, "1906"),3 , "Geographie");
        Question<VF> questG2  = new Question<>(new VF("La tour Eiffel fut construite à l’occasion de l'exposition universelle de Paris en 1889", true), 1, "Geographie");
        Question<VF> questG5  = new Question<>(new VF("La Navarre d’autrefois est aujourd’hui dans les Pyrénées espagnoles", true), 2, "Geographie");
        Question<VF> questG8  = new Question<>(new VF("Le mont Gerbier-de-Jonc, source de la Loire, se trouve dans le Jura", false), 3, "Geographie");
        Question<RC> questG3  = new Question<>(new RC("Quel est le fleuve le plong de France", "la Loire"), 1, "Geographie");
        Question<RC> questG6  = new Question<>(new RC("Combien de méridiens compte la Terre ?", "360"), 2, "Geographie");
        Question<RC> questG9  = new Question<>(new RC("Depuis 1989, quel pays a pris le nom d’Union de Myanmar ?", "La Birmanie"), 3, "Geographie");
        LinkedList<Question<? extends QType>> qListG = new LinkedList<>();

        qListG.add(questG1);
        qListG.add(questG2);
        qListG.add(questG3);
        qListG.add(questG4);
        qListG.add(questG5);
        qListG.add(questG6);
        qListG.add(questG7);
        qListG.add(questG8);
        qListG.add(questG9);

        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Geographie.txt");//Creation du fichier de question pour un thème
        a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(qListG);

        /**------------------------------------initialisation questions Automobile-------------------------------------**/

        ArrayList<String>  listeAU= new  ArrayList<String>();
        listeAU.add("Toyota");
        listeAU.add("Acura");
        listeAU.add("Kia");
        Question<QCM> questAU1 = new Question<>(new QCM("Lequel de ces constructeurs automobile n'est pas japonais?", listeAU, "Kia"),1 , "Automobile");
        ArrayList<String>  listeAU2= new  ArrayList<String>();
        listeAU2.add("France");
        listeAU2.add("Italie");
        listeAU2.add("Allemagne");
        listeAU2.add("USA");
        Question<QCM> questAU4 = new Question<>(new QCM("De quel pays provient la voiture la plus rapide du monde", listeAU2, "France"),2 , "Automobile");
        ArrayList<String>  listeAU3= new  ArrayList<String>();
        listeAU3.add("Alfa Romeo");
        listeAU3.add("Lamborghini");
        listeAU3.add("Honda");
        Question<QCM> questAU7 = new Question<>(new QCM("Lequel de ces constructeurs produit des moteurs de F1", listeAU3, "Honda"),3 , "Automobile");
        Question<VF> questAU2  = new Question<>(new VF("Lamborghini produisait des tracteurs avant de faire des voitures sportives", true), 1, "Automobile");
        Question<VF> questAU5  = new Question<>(new VF("Jaguar appartient à un groupe indien", true), 2, "Automobile");
        Question<VF> questAU8  = new Question<>(new VF("Ducati est un producteur de voitures", false), 3, "Automobile");
        Question<RC> questAU3  = new Question<>(new RC("Quelle voiture est caractérisée par un cheval qui cours", "Mustang"), 1, "Automobile");
        Question<RC> questAU6  = new Question<>(new RC("A quel groupe appartient Chrysler", "Fiat"), 2, "Automobile");
        Question<RC> questAU9  = new Question<>(new RC("Quel est le groupe automobile qui a vendu le plus de voiture en 2019", "Volkswagen"), 3, "Automobile");
        LinkedList<Question<? extends QType>> qListAU = new LinkedList<>();

        qListAU.add(questAU1);
        qListAU.add(questAU2);
        qListAU.add(questAU3);
        qListAU.add(questAU4);
        qListAU.add(questAU5);
        qListAU.add(questAU6);
        qListAU.add(questAU7);
        qListAU.add(questAU8);
        qListAU.add(questAU9);

        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Automobile.txt");//Creation du fichier de question pour un thème
        a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(qListAU);

/**------------------------------------initialisation questions Mathématiques-------------------------------------**/

        ArrayList<String>  listeM= new  ArrayList<String>();
        listeM.add("Addition");
        listeM.add("Multiplication");
        listeM.add("Division");
        Question<QCM> questM1 = new Question<>(new QCM("Le produit est le résultat d'une ...", listeM, "Multiplication"),1 , "Mathematiques");
        ArrayList<String>  listeM2= new  ArrayList<String>();
        listeM2.add("4ab");
        listeM2.add("0");
        listeM2.add("2ab*b");
        Question<QCM> questM4 = new Question<>(new QCM("Quelle est l'égalité de (a+b)² - (a-b)² ?", listeM2, "4ab"),2 , "Mathematiques");
        ArrayList<String>  listeM3= new  ArrayList<String>();
        listeM3.add("2");
        listeM3.add("4");
        listeM3.add("8");
        Question<QCM> questM7 = new Question<>(new QCM("Si on double le rayon d'une boule, son volume est multiplié par ", listeM3, "8"),3 , "Mathematiques");
        Question<VF> questM2  = new Question<>(new VF("Le périmètre d'un cercle est égal à 2*pi*r*r", false), 1, "Mathematiques");
        Question<VF> questM5  = new Question<>(new VF("Dans un triangle rectangle, la carré de l'hypoténuse est égal au produit des côtés de l'angle droit", false), 2, "Mathematiques");
        Question<VF> questM8  = new Question<>(new VF("Le centre de gravité d'un triangle est le point de concours des médianes", true), 3, "Mathematiques");
        Question<RC> questM3  = new Question<>(new RC("Quel est le carré du quart du tiers de 12 ?", "1"), 1, "Mathematiques");
        Question<RC> questM6  = new Question<>(new RC("Un triangle ABC a un angle de 50°, un deuxième angle de 80°. Ce triangle ABC est :", "Isocèle"), 2, "Mathematiques");
        Question<RC> questM9  = new Question<>(new RC("Une sphère et un cylindre ont tous deux un rayon de 6 cm. Quelle doit être la hauteur (en cm) du cylindre pour qu'ils aient le même volume ?", "8"), 3, "Mathematiques");
        LinkedList<Question<? extends QType>> qListM = new LinkedList<>();

        qListM.add(questM1);
        qListM.add(questM2);
        qListM.add(questM3);
        qListM.add(questM4);
        qListM.add(questM5);
        qListM.add(questM6);
        qListM.add(questM7);
        qListM.add(questM8);
        qListM.add(questM9);

        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Mathematiques.txt");//Creation du fichier de question pour un thème
        a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(qListM);

/**------------------------------------initialisation questions Francais-------------------------------------**/

        ArrayList<String>  listeF= new  ArrayList<String>();
        listeF.add("Bénine");
        listeF.add("Bénigne");
        listeF.add("Béninne");
        Question<QCM> questF1 = new Question<>(new QCM("Le féminin de bénin est :", listeF, "Bénigne"),1 , "Francais");
        ArrayList<String>  listeF2= new  ArrayList<String>();
        listeF2.add("Cet arbre est sans feuilles");
        listeF2.add("Il s'est lancé sans préparatif");
        listeF2.add("Il a répondu sans ambages");
        Question<QCM> questF4 = new Question<>(new QCM("Parmi ces quatre phrases, laquelle est mal orthographiée ?", listeF2, "Il s'est lancé sans préparatif"),2 , "Francais");
        ArrayList<String>  listeF3= new  ArrayList<String>();
        listeF3.add("Amalgame");
        listeF3.add("Appendice");
        listeF3.add("Ephéméride");
        Question<QCM> questF7 = new Question<>(new QCM("Parmi les noms suivants, lequel n’est pas du genre masculin ?", listeF3, "Ephéméride"),3 , "Francais");
        Question<VF> questF2  = new Question<>(new VF("Une didascalie est un mouvement de la machoire inférieure", false), 1, "Francais");
        Question<VF> questF5  = new Question<>(new VF("L'anachronisme est une faute de chronologie", true), 2, "Francais");
        Question<VF> questF8  = new Question<>(new VF("Un dithyrambe est un éloge exagéré", true), 3, "Francais");
        Question<RC> questF3  = new Question<>(new RC("Que signifie vacuité ?", "vide"), 1, "Francais");
        Question<RC> questF6  = new Question<>(new RC("Dans la phrase Il prononça ces paroles d’un ton comminatoire, le terme comminatoire signifie :", "menaçant"), 2, "Francais");
        Question<RC> questF9  = new Question<>(new RC("Complétez la phrase suivante par le mot adéquat : Le ministre de la Justice est aussi le garde des …", "sceaux"), 3, "Francais");
        LinkedList<Question<? extends QType>> qListF = new LinkedList<>();

        qListF.add(questF1);
        qListF.add(questF2);
        qListF.add(questF3);
        qListF.add(questF4);
        qListF.add(questF5);
        qListF.add(questF6);
        qListF.add(questF7);
        qListF.add(questF8);
        qListF.add(questF9);

        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Francais.txt");//Creation du fichier de question pour un thème
        a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(qListF);

/**------------------------------------initialisation questions Cuisine-------------------------------------**/

        ArrayList<String>  listeC= new  ArrayList<String>();
        listeC.add("Cheval");
        listeC.add("Volaille");
        listeC.add("Boeuf");
        Question<QCM> questC1 = new Question<>(new QCM("Quelle est la viande la plus maigre ?", listeC, "Cheval"),1 , "Cuisine");
        ArrayList<String>  listeC2= new  ArrayList<String>();
        listeC2.add("D’eaux douces");
        listeC2.add("D’eaux salées");
        listeC2.add("D’eaux chaudes");
        Question<QCM> questC4 = new Question<>(new QCM("Le Gardon est un poisson :", listeC2, "D’eaux douces"),2 , "Cuisine");
        ArrayList<String>  listeC3= new  ArrayList<String>();
        listeC3.add("Retire de la graisse");
        listeC3.add("Badigeonne");
        listeC3.add("Dissout dans un liquide");
        Question<QCM> questC7 = new Question<>(new QCM(" Quand on délaye, on :", listeC3, "Dissout dans un liquide"),3 , "Cuisine");
        Question<VF> questC2  = new Question<>(new VF("Le lait de poule est un sirop", false), 1, "Cuisine");
        Question<VF> questC5  = new Question<>(new VF("Abricoter signifie étendre au pinceau de la confiture", true), 2, "Cuisine");
        Question<VF> questC8  = new Question<>(new VF("Le ramboutant est un légume", false), 3, "Cuisine");
        Question<RC> questC3  = new Question<>(new RC("Qu'est ce qu'une araignée", "Une écumoire"), 1, "Cuisine");
        Question<RC> questC6  = new Question<>(new RC("Quel alcool trouve-t-on dans la margarita", "Tequila"), 2, "Cuisine");
        Question<RC> questC9  = new Question<>(new RC("A base de quel ingrédient est fait le Mafé", "Pâte d’arachide"), 3, "Cuisine");
        LinkedList<Question<? extends QType>> qListC = new LinkedList<>();

        qListC.add(questC1);
        qListC.add(questC2);
        qListC.add(questC3);
        qListC.add(questC4);
        qListC.add(questC5);
        qListC.add(questC6);
        qListC.add(questC7);
        qListC.add(questC8);
        qListC.add(questC9);

        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Cuisine.txt");//Creation du fichier de question pour un thème
        a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(qListC);

/**------------------------------------initialisation questions Sport-------------------------------------**/

        ArrayList<String>  listeS= new  ArrayList<String>();
        listeS.add("1 an");
        listeS.add("2 ans");
        listeS.add("4 ans");
        Question<QCM> questS1 = new Question<>(new QCM("Quelle est la périodicité des jeux Olympiques d’été ?", listeS, "4 ans"),1 , "Sport");
        ArrayList<String>  listeS2= new  ArrayList<String>();
        listeS2.add("Bleue");
        listeS2.add("Verte");
        listeS2.add("Orange");
        Question<QCM> questS4 = new Question<>(new QCM("Au judo, quel est le grade le plus élevé parmi ces ceintures ?", listeS2, "Verte"),2 , "Sport");
        ArrayList<String>  listeS3= new  ArrayList<String>();
        listeS3.add("Le Vendée Globe");
        listeS3.add("La Volvo Ocean Race");
        listeS3.add("Le trophée Jules Verne");
        Question<QCM> questS7 = new Question<>(new QCM("Laquelle de ces courses à la voile est une course en solitaire ?", listeS3, "Le Vendée Globe"),3 , "Sport");
        Question<VF> questS2  = new Question<>(new VF("Zlatan Ibrahimovic est un footballeur serbe", false), 1, "Sport");
        Question<VF> questS5  = new Question<>(new VF("L'Italie participe au tournoi des 6 nations", true), 2, "Sport");
        Question<VF> questS8  = new Question<>(new VF("Sebastien Loeb s'est illustré en course automobile sur circuit", false), 3, "Sport");
        Question<RC> questS3  = new Question<>(new RC("Dans quel sport emploie-t-on les termes suivants : split, spare, strike ?", "Bowling"), 1, "Sport");
        Question<RC> questS6  = new Question<>(new RC("Quel est le seul pays d’Amérique du Sud qui accueille un Grand Prix de Formule 1 ?", "Brésil"), 2, "Sport");
        Question<RC> questS9  = new Question<>(new RC("Contre qui a combattu Mohamed Ali lors d’un combat mémorable se déroulant à Kinshasa ?", "George Foreman"), 3, "Sport");
        LinkedList<Question<? extends QType>> qListS = new LinkedList<>();

        qListS.add(questS1);
        qListS.add(questS2);
        qListS.add(questS3);
        qListS.add(questS4);
        qListS.add(questS5);
        qListS.add(questS6);
        qListS.add(questS7);
        qListS.add(questS8);
        qListS.add(questS9);

        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Sport.txt");//Creation du fichier de question pour un thème
        a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(qListS);

        /**------------------------------------initialisation questions Politique-------------------------------------**/

        ArrayList<String>  listeP= new  ArrayList<String>();
        listeP.add("A titre bénévole");
        listeP.add("Moyennant une indemnité fixe et imposable");
        listeP.add("Moyennant une indemnité non imposable calculée en fonction de leur salaire antérieur");
        Question<QCM> questP1 = new Question<>(new QCM("Les ministres exercent leur fonction :", listeP, "Moyennant une indemnité fixe et imposable"),1 , "Politique");
        ArrayList<String>  listeP2= new  ArrayList<String>();
        listeP2.add("Le porte-parole du gouvernement");
        listeP2.add("Les secrétaires d'Etat");
        listeP2.add("Les ministres délégués");
        Question<QCM> questP4 = new Question<>(new QCM("Qui n’est pas tenu d’assister au Conseil des ministres ?", listeP2, "Les secrétaires d'Etat"),2 , "Politique");
        ArrayList<String>  listeP3= new  ArrayList<String>();
        listeP3.add("La CADA");
        listeP3.add("Le CSA");
        listeP3.add("La CNIL");
        Question<QCM> questP7 = new Question<>(new QCM("Quelle instance veille à la bonne utilisation des fichiers pour protéger notre vie privée et nos libertés individuelles ?", listeP3, "La CNIL"),3 , "Politique");
        Question<VF> questP2  = new Question<>(new VF("Les services de gendarmerie dépendent du ministère de l'intérieur", true), 1, "Politique");
        Question<VF> questP5  = new Question<>(new VF("Le Premier Ministre préside le Conseil des ministres", false), 2, "Politique");
        Question<VF> questP8  = new Question<>(new VF("Le médiateur de la République est nommé pour 5 ans", false), 3, "Politique");
        Question<RC> questP3  = new Question<>(new RC("La première élection présidentielle au suffrage universel a eu lieu en :", "1965"), 1, "Politique");
        Question<RC> questP6  = new Question<>(new RC("Qui dirige l’administration ?", "Le Premier Ministre"), 2, "Politique");
        Question<RC> questP9  = new Question<>(new RC("En France, il existe combien de fonctions publiques ?", "3"), 3, "Politique");
        LinkedList<Question<? extends QType>> qListP = new LinkedList<>();

        qListP.add(questP1);
        qListP.add(questP2);
        qListP.add(questP3);
        qListP.add(questP4);
        qListP.add(questP5);
        qListP.add(questP6);
        qListP.add(questP7);
        qListP.add(questP8);
        qListP.add(questP9);

        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Politique.txt");//Creation du fichier de question pour un thème
        a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(qListP);

        /**------------------------------------initialisation questions Animaux-------------------------------------**/

        ArrayList<String>  listeAN= new  ArrayList<String>();
        listeAN.add("La chèvre");
        listeAN.add("L'âne");
        listeAN.add("La vache");
        Question<QCM> questAN1 = new Question<>(new QCM("Quel animal brait", listeAN, "L'âne"),1 , "Animaux");
        ArrayList<String>  listeAN2= new  ArrayList<String>();
        listeAN2.add("La brebis");
        listeAN2.add("La chèvre");
        listeAN2.add("La vache");
        Question<QCM> questAN4 = new Question<>(new QCM("À partir du lait de quel animal, fabrique-t-on le roquefort ?", listeAN2, "La brebis"),2 , "Animaux");
        ArrayList<String>  listeAN3= new  ArrayList<String>();
        listeAN3.add("Une souris");
        listeAN3.add("Un renard");
        listeAN3.add("Un cochon");
        Question<QCM> questAN7 = new Question<>(new QCM("Qu’est-ce qu’un verrat ?", listeAN3, "Un cochon"),3 , "Animaux");
        Question<VF> questAN2  = new Question<>(new VF("Les loups vivent dans une tanière", true), 1, "Animaux");
        Question<VF> questAN5  = new Question<>(new VF("La gestation d'un poney dure 1 an", true), 2, "Animaux");
        Question<VF> questAN8  = new Question<>(new VF("Un puma a une longévité de 20 ans", false), 3, "Animaux");
        Question<RC> questAN3  = new Question<>(new RC("Avec quel autre animal l'alpaga est-il souvent confondu", "le lama"), 1, "Animaux");
        Question<RC> questAN6  = new Question<>(new RC("Quand a été créée la SPA, Société Protectrice des Animaux ?", "1845"), 2, "Animaux");
        Question<RC> questAN9  = new Question<>(new RC("Dans la symbolique hawaïenne, quel animal est associé à la protection, appelée Aumakua ?", "Le requin"), 3, "Animaux");
        LinkedList<Question<? extends QType>> qListAN = new LinkedList<>();

        qListAN.add(questAN1);
        qListAN.add(questAN2);
        qListAN.add(questAN3);
        qListAN.add(questAN4);
        qListAN.add(questAN5);
        qListAN.add(questAN6);
        qListAN.add(questAN7);
        qListAN.add(questAN8);
        qListAN.add(questAN9);

        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Animaux.txt");//Creation du fichier de question pour un thème
        a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(qListAN);

/**------------------------------------initialisation questions Astronomie-------------------------------------**/

        ArrayList<String>  listeAS= new  ArrayList<String>();
        listeAS.add("Saturne");
        listeAS.add("Jupiter");
        listeAS.add("Uranus");
        Question<QCM> questAS1 = new Question<>(new QCM("Quelle cèlebre planète possède d'impressionnants anneaux ?", listeAS, "Saturne"),1 , "Astronomie");
        ArrayList<String>  listeAS2= new  ArrayList<String>();
        listeAS2.add("Une eclipse solaire");
        listeAS2.add("Une eclipse lunaire");
        listeAS2.add("Un transit");
        Question<QCM> questAS4 = new Question<>(new QCM("Comment s'appelle le phénomène qui se produit lorsque la Lune occulte totalement le Soleil ?", listeAS2, "Une eclipse solaire"),3 , "Astronomie");
        ArrayList<String>  listeAS3= new  ArrayList<String>();
        listeAS3.add("300");
        listeAS3.add("3000");
        listeAS3.add("30000");
        Question<QCM> questAS7 = new Question<>(new QCM("Combien d'étoiles est-il possible d'observer dans de bonnes conditions", listeAS3, "3000"),2 , "Astronomie");
        Question<VF> questAS2  = new Question<>(new VF("Il y a 9 planètes dans le système solaire", false), 1, "Astronomie");
        Question<VF> questAS5  = new Question<>(new VF("Mercure ne possède pas de satellites", true), 2, "Astronomie");
        Question<VF> questAS8  = new Question<>(new VF("La Terre se situe à environ 150 000 000 km du Soleil", true), 3, "Astronomie");
        Question<RC> questAS3  = new Question<>(new RC("Qu'est-ce que l'étoile du berger", "Une planète"), 1, "Astronomie");
        Question<RC> questAS6  = new Question<>(new RC("Quelle est la seule galaxie, hormis la Voie Lactée, à être visible à l'oeil nu ?", "Andromède"), 2, "Astronomie");
        Question<RC> questAS9  = new Question<>(new RC("Sur quelle planète se situe la Grande Tâche Rouge ?", "Jupiter"), 3, "Astronomie");
        LinkedList<Question<? extends QType>> qListAS = new LinkedList<>();

        qListAS.add(questAS1);
        qListAS.add(questAS2);
        qListAS.add(questAS3);
        qListAS.add(questAS4);
        qListAS.add(questAS5);
        qListAS.add(questAS6);
        qListAS.add(questAS7);
        qListAS.add(questAS8);
        qListAS.add(questAS9);

        /** Sérialisation de la question**/
        fichier = new File("src/projet/themesQ/Astronomie.txt");//Creation du fichier de question pour un thème
        a = new ObjectOutputStream(new FileOutputStream(fichier));
        a.writeObject(qListAS);


    }

    private static void testSerialization() throws IOException, ClassNotFoundException {
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
        // qList.get(1).afficher();
        //qList.get(1).saisir();
    }
}
