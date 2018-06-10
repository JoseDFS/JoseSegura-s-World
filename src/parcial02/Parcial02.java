/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial02;

import Lista.Jugador.ListaFuerza;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Parcial02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {

        try {
            Menu menu = Menu.getInstance();
            
            menu.mostrar();
        } /*
        ListaFuerza Fuerzas = new ListaFuerza();
        try {
        Fuerzas.addFuerza();
        } catch (Exception ex) {
        System.err.println("No se pudo construir la torre");
        }
        Fuerzas.mostrar();
        TorreFactory factory;
        String a="Fuerza";
        factory = TorreProducer.getFactory(a);
        FuerzaG Mili = factory.getFuerzaG("Transporte Aereo", 0);
        Mili.Habilitar();
         */ catch (Exception ex) {
            Logger.getLogger(Parcial02.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    }
