
package Vue;


import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class Pile extends ImageIcon{
static Image imagePile = Toolkit.getDefaultToolkit().getImage("batterieps.png");
    public Pile() {
        super(imagePile);
    }
    
}
