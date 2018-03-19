package Vue;

import Modele.Modele;
import static Vue.Amperemetre.imageAmperemetre;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

public class Fenetre extends JFrame implements Observer {

    private int nombrePoint = 0;
    private int nombreNiveau = 0;
    private JPanel pnlPrincipal = new JPanel(new BorderLayout());
    private JPanel pnlCarre = new JPanel(new GridLayout(10, 2));
    private JPanel pnlJeu = new JPanel(new BorderLayout());
    private JPanel pnlNiveau = new JPanel(new BorderLayout());
    private JPanel pnlChronoPoint = new JPanel(new BorderLayout());
    private JPanel pnlTest = new JPanel(new BorderLayout());
    private JPanel pnlGrille = new JPanel(new GridLayout(6, 6));
    private JLabel lblNiveau = new JLabel("Niveau:" + nombreNiveau);
    private JLabel lblEnoncer = new JLabel("Énoncé du problème:");
    private JLabel lblChrono = new JLabel("00:00 min");
    private JLabel lblPoint = new JLabel(nombrePoint + " points");

    private JMenuBar monMenu = new JMenuBar();
    private final JMenu mnuFichier = new JMenu("Fichier");
    private final JMenu mnuAide = new JMenu("?");
    private final JMenuItem mnuAPropos = new JMenuItem("À propos");
    private final JMenu mnuMode = new JMenu("Mode de Jeu");
    private final JMenuItem mnuNouvellePartie = new JMenuItem("Nouvelle partie");
    private final JMenuItem mnuQuitter = new JMenuItem("Quitter");
    private final JMenuItem mnuFormules = new JMenuItem("Formules utiles");
    private final JMenuItem mnuReponses = new JMenuItem("Réponses des niveaux");
    private final JMenuItem mnuRegles = new JMenuItem("Comment jouer ?");
    private final JMenuItem mnuApprentissage = new JMenuItem("Apprentissage");
    private final JMenuItem mnuChrono = new JMenuItem("Chrono");
    private final JMenuItem mnuLibre = new JMenuItem("Libre");
//    private final JMenuItem mnusousÀPropos = new JMenu("Étienne Gagné,Audrey Lupien et Cloé Lachance");
    private Amperemetre amperemetre = new Amperemetre();
    private Ampoule ampoule = new Ampoule();
    private Bobine bobine = new Bobine();
    private Condensateur condensateur = new Condensateur();
    private InterrupteurO interrupteurO = new InterrupteurO();
    private InterrupteurF interrupteurF = new InterrupteurF();
    private Pile pile = new Pile();
    private Resistance resistance = new Resistance();
    private Voltmetre voltmetre = new Voltmetre();

    private JButton btn1 = new JButton();
    private JButton btn2 = new JButton();
    private JButton btn3 = new JButton();
    private JButton btn4 = new JButton();
    private JButton btn5 = new JButton();
    private JButton btn6 = new JButton();
    private JButton btn7 = new JButton();
    private JButton btn8 = new JButton();
    private JButton btn9 = new JButton();

    public Fenetre(Modele modele) {

        setTitle("circuitAEC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 850);
//900,850

        settingWindow();
        initMenu();
        evenement();
        mouse();

        setResizable(false);
        //pack();
        //setLayout(null);
        this.setVisible(true);
    }

    public void settingWindow() {
        add(pnlPrincipal);

        pnlPrincipal.add(pnlJeu, BorderLayout.EAST);
        pnlPrincipal.add(pnlCarre, BorderLayout.WEST);
        pnlPrincipal.add(pnlTest, BorderLayout.WEST);
        pnlJeu.setPreferredSize(new Dimension(700, 900));
        // pnlCarre.setPreferredSize(new Dimension(100, 900));
        pnlJeu.add(pnlNiveau, BorderLayout.NORTH);
        pnlJeu.add(pnlChronoPoint, BorderLayout.SOUTH);
        pnlJeu.add(pnlGrille, BorderLayout.CENTER);

        pnlNiveau.add(lblNiveau, BorderLayout.NORTH);
        pnlNiveau.add(lblEnoncer, BorderLayout.SOUTH);
        pnlChronoPoint.add(lblChrono, BorderLayout.WEST);
        pnlChronoPoint.add(lblPoint, BorderLayout.EAST);

        pnlCarre.add(btn1);
        pnlCarre.add(btn2);
        pnlCarre.add(btn3);
        pnlCarre.add(btn4);
        pnlCarre.add(btn5);
        pnlCarre.add(btn6);
        pnlCarre.add(btn7);
        pnlCarre.add(btn8);
        pnlCarre.add(btn9);

        btn1.setIcon(amperemetre);
        btn2.setIcon(ampoule);
        btn3.setIcon(bobine);
        btn4.setIcon(condensateur);;
        btn5.setIcon(interrupteurO);
        btn6.setIcon(interrupteurF);
        btn7.setIcon(pile);
        btn8.setIcon(resistance);
        btn9.setIcon(voltmetre);

        JScrollPane scrollPane = new JScrollPane(pnlCarre);
        pnlPrincipal.add(scrollPane);

    }

    private void initMenu() {

        monMenu.add(mnuFichier);
        monMenu.add(mnuAide);
        monMenu.add(mnuMode);

        mnuFichier.add(mnuNouvellePartie);
        mnuFichier.addSeparator();
        mnuFichier.add(mnuAPropos);
        mnuFichier.addSeparator();
        mnuFichier.add(mnuQuitter);

        mnuAide.add(mnuFormules);
        mnuAide.addSeparator();
        mnuAide.add(mnuReponses);
        mnuAide.addSeparator();
        mnuAide.add(mnuRegles);

        mnuMode.add(mnuApprentissage);
        mnuMode.addSeparator();
        mnuMode.add(mnuChrono);
        mnuMode.addSeparator();
        mnuMode.add(mnuLibre);

        setJMenuBar(monMenu);

        listenersMenus();
    }

    public void listenersMenus() {
        mnuNouvellePartie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
//            	finDePartie();
//            	modele.reset();
            }
        });

        mnuAPropos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Étienne Gagné,Audrey Lupien et Cloé Lachance, créé le 54 fevars");
            }
        });

        mnuQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                int dialogBouton = JOptionPane.YES_NO_OPTION;
                int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous "
                        + "vraiment quitter ce merveilleux jeux?", "Question", dialogBouton);
                if (reponse == JOptionPane.NO_OPTION) {

                } else if (reponse == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        mnuFormules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Ajouter Formules ici!!!");
            }
        });

        mnuReponses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Object reponse = JOptionPane.showInputDialog(null,
                        "De quel niveau voulez-vous voir la réponse ?", "Réponses",
                        JOptionPane.QUESTION_MESSAGE, null, new String[]{"1", "2", "3", "4", "5", "..."}, null);

            }
        });
        mnuRegles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Écrire les règles du jeu ici!!!");
            }
        });

        mnuApprentissage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
//            	
            }
        });

        mnuChrono.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
//            	
            }
        });

        mnuLibre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
//            	
            }
        });

    }

    public void evenement() {

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JButton btnAmperemetre = new JButton();
                btnAmperemetre.setIcon(amperemetre);
                pnlGrille.add(btnAmperemetre);

                setVisible(true);

            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JButton btnAmpoule = new JButton();

                btnAmpoule.setIcon(ampoule);

                pnlGrille.add(btnAmpoule);

                setVisible(true);

            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));
                JButton btnBobine = new JButton();
                btnBobine.setIcon(bobine);
                pnlGrille.add(btnBobine);
                setVisible(true);

            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));
                JButton btnCondensateur = new JButton();
                btnCondensateur.setIcon(condensateur);
                pnlGrille.add(btnCondensateur);
                setVisible(true);

            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));
                JButton btnInterrupteurO = new JButton();
                btnInterrupteurO.setIcon(interrupteurO);
                pnlGrille.add(btnInterrupteurO);
                setVisible(true);

            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));
                JButton btnInterrupteurF = new JButton();
                btnInterrupteurF.setIcon(interrupteurF);
                pnlGrille.add(btnInterrupteurF);
                setVisible(true);

            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));
                JButton btnPile = new JButton();
                btnPile.setIcon(pile);
                pnlGrille.add(btnPile);
                setVisible(true);

            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));
                JButton btnResistance = new JButton();
                btnResistance.setIcon(resistance);
                pnlGrille.add(btnResistance);
                setVisible(true);

            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));
                JButton btnVoltmetre = new JButton();
                btnVoltmetre.setIcon(voltmetre);
                pnlGrille.add(btnVoltmetre);
                setVisible(true);

            }
        });
      
        
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JComponent jc = (JComponent) e.getSource();
                TransferHandler th = jc.getTransferHandler();
                th.exportAsDrag(jc, e, TransferHandler.COPY);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

//             btnAmperemetre.addMouseListener(ml);
//             btnAmpoule.addMouseListener(ml);
//             
//             btnAmperemetre.setTransferHandler(new TransferHandler("test"));
//             btnAmpoule.setTransferHandler(new TransferHandler("test2"));
    }

    public void mouse() {

        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JComponent jc = (JComponent) e.getSource();
                TransferHandler th = jc.getTransferHandler();
                th.exportAsDrag(jc, e, TransferHandler.COPY);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        btn1.addMouseListener(ml);
        btn2.addMouseListener(ml);

        btn1.setTransferHandler(new TransferHandler("test"));
        btn2.setTransferHandler(new TransferHandler("test2"));
    }

    public int getNombreNiveau() {
        return nombreNiveau;
    }

    public int getNombrePoint() {
        return nombrePoint;
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
