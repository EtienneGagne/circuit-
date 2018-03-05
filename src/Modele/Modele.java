/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Observable;

/**
 *
 * @author 1637157
 */
public class Modele  extends Observable{
      private int nombrePoint=0;
    private int nombreNiveau=0;
    public void reset() {
        
    	setChanged();
    	notifyObservers(this);   
        
    }

    public int getNombreNiveau() {
        return nombreNiveau;
    }

    public int getNombrePoint() {
        return nombrePoint;
    }

    public void setNombreNiveau(int nombreNiveau) {
        this.nombreNiveau = nombreNiveau++;
    }

    public void setNombrePoint(int nombrePoint) {
        this.nombrePoint = nombrePoint++;
    }
    
}
