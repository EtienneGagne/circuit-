
package Vue;

import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;


public class Amperemetre extends ImageIcon {
static Image imageAmperemetre = Toolkit.getDefaultToolkit().getImage("amperemetreps.png");
    public Amperemetre() {
        super(imageAmperemetre);
    }

   public Image getImg(){
       return imageAmperemetre;
   }

    

  
    
}
