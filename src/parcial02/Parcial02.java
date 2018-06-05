/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial02;

import Fuerza.Factory.FuerzaG;
import Torre.Factory.TorreFactory;
import Torre.Factory.TorreProducer;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Parcial02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TorreFactory factory;
        String a="Fuerza";
        
        factory = TorreProducer.getFactory(a);
        
        FuerzaG Mili = factory.getFuerzaG("Transporte Aereo", 0);
        Mili.Habilitar();
    }
    
}
