package projet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

/**
 * The type Ens joueurs.
 */
public class EnsJoueurs {
    private Vector<Joueur> vector = new Vector<Joueur>(20);
    private String[] columnNames = {"N°", "Nom", "Score",
            "Etat"};
    private JTable table = new JTable() {
        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            // redimensione automatiquement la largeur des colonnes
            Component component = super.prepareRenderer(renderer, row, column);
            int rendererWidth = component.getPreferredSize().width;
            TableColumn tableColumn = getColumnModel().getColumn(column);
            tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
            return component;
        }
    };
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane scrollPane = new JScrollPane(table);
    private DefaultTableCellRenderer cellRenderer;

    /**
     * Creer.
     *
     * @param vector the vector
     */
    public void creer(Vector<Joueur> vector) {
        this.vector = vector;
    }


    /**
     * Afficher.
     */
    public void afficher() {
        System.out.println("Liste des joueurs :");
        vector.forEach(Joueur::afficher);
    }

    /**
     * Selectionner joueur joueur.
     *
     * @return the joueur
     */
    public Joueur selectionnerJoueur() {
        int random = (int) (Math.random() * 100) % vector.size();
        return vector.get(random);
    }

    /**
     * Create window.
     */
    public void createWindow() {
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        // config fenetre
        scrollPane.setBounds(20, 70, 1800, 300);
        model.setColumnIdentifiers(columnNames); // nom des columns
        table.setModel(model);
        table.setFillsViewportHeight(true);
        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.getContentPane().setLayout(null);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Modifier un th\u00e8me");
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    /**
     * Fill table.
     */
    public void fillTable() {
        createWindow();
        vector.forEach((player) -> model.addRow(new Object[]{player.getNumero(), player.getNom(), player.getScore(), player.getEtat()}));
    }

    /**
     * Gets joueur.
     *
     * @param index the index
     * @return the joueur
     */
    public Joueur getJoueur(int index) {
        return vector.get(index);
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return vector.size();
    }

    /**
     * Gets vector.
     *
     * @return the vector
     */
    public Vector<Joueur> getVector() {
        return vector;
    }

    /**
     * Remove.
     *
     * @param ToRemove the to remove
     */
    public void remove(Joueur ToRemove) {
        ToRemove.setEtat("\u00e9limin\u00e9");
        vector.remove(ToRemove);
    }

    /**
     * Recup liste vector.
     *
     * @return the vector
     */
    public Vector<Joueur> recupListe() {
        Vector<Joueur> joueurs = new Vector<>(20);
        try {
            File fichier = new File("src/projet/joueur/listeJoueurs.txt");
            ObjectInputStream b = new ObjectInputStream(new FileInputStream(fichier));
            joueurs = (Vector<Joueur>) b.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return joueurs;
    }

}
