package Vue;

import Modele.Modele;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class Fenetre extends JFrame implements Observer {

    private int nombrePoint = 0;
    private int nombreNiveau = 0;
    static long chrono = 0;
    private JLabel probleme;
    Color couleur = new Color(70, 130, 180);
    private JPanel pnlPrincipal = new JPanel(new BorderLayout());
    private JPanel pnlCarre = new JPanel(new GridLayout(10, 2));
    private JPanel pnlJeu = new JPanel(new BorderLayout());
    private JPanel pnlNiveau = new JPanel(new BorderLayout());
    private JPanel pnlChronoPoint = new JPanel(new BorderLayout());
    private JPanel pnlTest = new JPanel(new BorderLayout());
    private JPanel pnlGrille = new JPanel(new GridLayout(6, 6));
    private JLabel lblNiveau = new JLabel("Niveau : " + nombreNiveau + "\n");
    private JLabel lblEnoncer = new JLabel("Énoncé du problème : " + probleme);
    private JLabel lblChrono = new JLabel("     00:00 min    ");
    private JLabel lblPoint = new JLabel(nombrePoint + " points     ");

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
        modele.addObserver(this);

        //this.modele = modele;
        modele.addObserver(this);

        setTitle("circuitAEC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 850);
//900,850

        settingWindow();
        initMenu();
        evenement();

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
        pnlJeu.add(pnlNiveau, BorderLayout.NORTH);
        pnlJeu.add(pnlChronoPoint, BorderLayout.SOUTH);
        pnlJeu.add(pnlGrille, BorderLayout.CENTER);
        pnlGrille.setBackground(couleur);
        pnlNiveau.add(lblNiveau, BorderLayout.NORTH);
        pnlNiveau.setBackground(couleur);
        pnlNiveau.add(lblEnoncer, BorderLayout.SOUTH);
        pnlChronoPoint.add(lblChrono, BorderLayout.WEST);
        pnlChronoPoint.add(lblPoint, BorderLayout.EAST);
        pnlChronoPoint.setBackground(couleur);

        pnlCarre.add(btn1);
        pnlCarre.add(btn2);
        pnlCarre.add(btn3);
        pnlCarre.add(btn4);
        pnlCarre.add(btn5);
        pnlCarre.add(btn6);
        pnlCarre.add(btn7);
        pnlCarre.add(btn8);
        pnlCarre.add(btn9);

        btn1.add(new JLabel(amperemetre));
        btn2.add(new JLabel(ampoule));
        btn3.add(new JLabel(bobine));
        btn4.add(new JLabel(condensateur));
        btn5.add(new JLabel(interrupteurO));
        btn6.add(new JLabel(interrupteurF));
        btn7.add(new JLabel(pile));
        btn8.add(new JLabel(resistance));
        btn9.add(new JLabel(voltmetre));

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
                JOptionPane.showMessageDialog(null, "Règles et commandes du jeu : \n"
                        + "_________________________\n"
                        + "Premièrement, choisissez votre mode de jeu\n"
                        + "     -Apprentissage (mode avec pointage)\n"
                        + "     -Chrono (mode avec pointage et chronomètre)\n"
                        + "     -Libre (mode sans pointage ni chrono pour visualiser nos exercices)\n"
                        + "Dans les 2 premiers modes, vous devez compléter les niveaux pour accumuler des points. \n"
                        + "Les niveaux consistent à compléter des circuits où il manque des éléments \n"
                        + "Commandes du jeu : \n"
                        + "_________________\n"
                        + "Avec la souris cliquez et maintenez l'élément, puis glissez-le et lâchez l'élément à l'entroit désiré\n");
            }
        });

        mnuApprentissage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
//            	
            }
        });

        mnuChrono.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Timer timer = new Timer(1000, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        lblChrono.setText(String.valueOf((System.nanoTime()%1000)-1000)+ "sec");
                    }
                    
                });
                timer.start();
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
                //pnlGrille.add(new JLabel(amperemetre));

                pnlGrille.add(new JLabel(amperemetre));
                setVisible(true);

            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));

                pnlGrille.add(new JLabel(ampoule));
                setVisible(true);

            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));

                pnlGrille.add(new JLabel(bobine));
                setVisible(true);

            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));

                pnlGrille.add(new JLabel(condensateur));
                setVisible(true);

            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));

                pnlGrille.add(new JLabel(interrupteurO));
                setVisible(true);

            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));

                pnlGrille.add(new JLabel(interrupteurF));
                setVisible(true);

            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));

                pnlGrille.add(new JLabel(pile));
                setVisible(true);

            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));

                pnlGrille.add(new JLabel(resistance));
                setVisible(true);

            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pnlGrille.add(new JLabel(amperemetre));

                pnlGrille.add(new JLabel(voltmetre));
                setVisible(true);

            }
        });
    }

    public int getNombreNiveau() {
        return nombreNiveau;
    }

    public int getNombrePoint() {
        return nombrePoint;
    }

    @Override
    public void update(Observable o, Object o1) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}
