
package Vue;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

public class Fenetre extends JFrame implements Observer{
    
    public Fenetre(){
        setTitle("circuitAEC");
        
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
       
}
