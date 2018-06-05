/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista.Jugador;

import Fuerza.Factory.FuerzaG;
import Torre.Factory.TorreFactory;
import Torre.Factory.TorreProducer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class ListaFuerza {

    private ArrayList<FuerzaG> fuerzas;
    private TorreFactory factory;
    private String[] torres = {"Milicia", "Transporte Aereo", "Transporte Terrestre","otroVehiculo"};

    public ListaFuerza() {
        fuerzas = new ArrayList<>();
        factory = TorreProducer.getFactory("Fuerza");
    }

    public void addFuerza() throws Exception  {

        boolean opt = true;
        String torre = "";
        Scanner choose = new Scanner(System.in);
        System.out.println("Que tipo de torre de Fuerzas de Combate quiere construir? Escriba el numero de la Torre.");
        while (opt) {
            for (int i = 0; i < torres.length; i++) {
                System.out.println((i + 1) + "." + torres[i]);
            }
            try {
                torre = torres[choose.nextInt() - 1];
                opt = false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("No esta ese tipo de Torre");
                System.out.println("");
                choose.nextLine();
                opt = true;

            }
            
        }
        FuerzaG fuerza = factory.getFuerzaG(torre, 0);
        fuerzas.add(fuerza);
        fuerza.Habilitar();
    }

}
