package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Fenetre extends JFrame implements Observer {

    private JPanel pnlPrincipal = new JPanel(new BorderLayout());
    private JPanel pnlCarre = new JPanel(new GridLayout(10, 2));
    private JPanel pnlJeu = new JPanel(new GridLayout(6, 6));
    

    private JMenuBar monMenu = new JMenuBar();
    private final JMenu mnuFichier = new JMenu("Fichier");
    private final JMenu mnuAide = new JMenu("?");
    private final JMenu mnuAPropos = new JMenu("À propos");
    private final JMenuItem mnuNouvellePartie = new JMenuItem("Nouvelle partie");
    private final JMenuItem mnuQuitter = new JMenuItem("Quitter");
    private final JMenuItem mnuSousAide = new JMenuItem("Aide");
    private final JMenuItem mnusousÀPropos = new JMenu("Étienne Gagné,Audrey Lupien et Cloé Lachance");

    public Fenetre() {
        setTitle("circuitAEC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 850);

        add(pnlPrincipal);

        settingWindow();

        setResizable(false);
//        pack();

        this.setVisible(true);
    }

    public void settingWindow() {

        pnlPrincipal.add(pnlJeu, BorderLayout.EAST);
        pnlPrincipal.add(pnlCarre, BorderLayout.WEST);
        pnlJeu.setPreferredSize(new Dimension(700, 800));
        pnlCarre.setPreferredSize(new Dimension(100, 900));

        for (int i = 0; i < 20; i++) {
            JButton carre = new JButton("" + i);
    carre.setPreferredSize(new Dimension(50,50));

            pnlCarre.add(carre);

        }

        pnlPrincipal.setPreferredSize(new Dimension(500, 500));
        JScrollPane scrollPane = new JScrollPane(pnlCarre);
        pnlPrincipal.add(scrollPane);

        monMenu.add(mnuFichier);
        monMenu.add(mnuAide);
        monMenu.add(mnuAPropos);
        mnuFichier.add(mnuNouvellePartie);
        mnuFichier.addSeparator();
        mnuFichier.add(mnuQuitter);
        mnuAide.add(mnuSousAide);
        mnuAPropos.add(mnusousÀPropos);

        setJMenuBar(monMenu);

    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
