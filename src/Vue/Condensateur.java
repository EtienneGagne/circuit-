
package Vue;


import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Condensateur extends ImageIcon {
    
static Image imageCondensateur = Toolkit.getDefaultToolkit().getImage("condensateurps.png");

    public Condensateur() {
        super(imageCondensateur);
    }
    
}
