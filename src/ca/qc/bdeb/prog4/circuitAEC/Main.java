/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.circuitAEC;

import Modele.Modele;
import Vue.Fenetre;

/**
 *
 * @author 1637157
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modele modele = new Modele();
       Fenetre fenetre=new Fenetre(modele);
        
    }
    
}
