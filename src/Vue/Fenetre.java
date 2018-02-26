
package Vue;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Fenetre extends JFrame implements Observer{
    
      
      private JMenuBar monMenu = new JMenuBar();
      private final JMenu mnuFichier = new JMenu("Fichier");
      private final JMenu mnuAide = new JMenu("?");
      private final JMenu mnuAPropos=new JMenu("À propos");
      private final JMenuItem mnuNouvellePartie = new JMenuItem("Nouvelle partie");
      private final JMenuItem mnuQuitter = new JMenuItem("Quitter");
      private final JMenuItem mnuSousAide = new JMenuItem("Aide");
      private final JMenuItem mnusousÀPropos=new JMenu("Étienne Gagné,Audrey Lupien et Cloé Lachance");
      
    public Fenetre(){
        setTitle("circuitAEC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600,850);
        settingWindow();
        this.setVisible(true);
    }
    public void settingWindow(){
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
