
package Vue;


import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Ampoule extends ImageIcon{
    static Image imageAmpoule = Toolkit.getDefaultToolkit().getImage("ampouleps.png");

    public Ampoule() {
        super(imageAmpoule);
    }
    
}
