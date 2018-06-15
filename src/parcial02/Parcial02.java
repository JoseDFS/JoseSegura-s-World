/*
Esta clase es el main del programa que se encargara de tener la instancia de un objeto tipo menu.
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
        } catch (Exception ex) {
            Logger.getLogger(Parcial02.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    }
