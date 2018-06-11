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
    private String[] torres1 = {"Arqueros", "Quimera", "Fenix"};
    private String[] torres2 = {"Guerreros", "Tanque", "Dirigible"};
    private String[] torres3 = {"Scouts", "LossenTank", "WingForm"};

    public ListaFuerza() {
        this.fuerzas = new ArrayList<>();

        this.factory = TorreProducer.getFactory("Fuerza");

    }

    public void addFuerza(int faseIni, int numeroRaza, int faseTorres) throws Exception {
        String[] torresT = null;
        if (numeroRaza == 1) {
            torresT = this.torres1;
        }
        if (numeroRaza == 2) {
            torresT = this.torres2;
        }
        if (numeroRaza == 3) {
            torresT = this.torres3;
        }

        boolean opt = true;
        String torre = "";
        Scanner choose = new Scanner(System.in);
        System.out.println("Que tipo de Torre de Fuerzas de Combate quiere construir? Escriba el numero de la Torre.");
        while (opt) {
            for (int i = 0; i < torresT.length; i++) {
                System.out.println((i + 1) + "." + torresT[i]);
            }
            try {
                torre = torresT[Integer.parseInt(choose.nextLine()) - 1];
                opt = false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("No esta ese tipo de Torre");
                System.out.println("");
                choose.nextLine();
                opt = true;

            }

        }
        FuerzaG fuerza = factory.getFuerzaG(torre, (faseIni + faseTorres), numeroRaza);
        fuerzas.add(fuerza);
    }

    public void mostrar() {
        
        if (fuerzas.isEmpty()) {
            System.out.println("No hay torres de fuerzas");
        } else {
            System.out.println("-----Torres de Combate-----");
            System.out.println("  Tipo:         |  Vida:  | Estado:");
            fuerzas.forEach((e) -> {

                System.out.println(fuerzas.indexOf(e)+1+"." + e.toString());
               
            });

        }
    }

    public FuerzaG elegirTorre() {
        int numero = -1;
        boolean opt = true;
        FuerzaG temp = null;
        System.out.println("Elija el numero de la torre:");
        Scanner L = new Scanner(System.in);
        while (opt) {
            try {
                numero = Integer.parseInt(L.nextLine()) - 1;
                opt = false;

                temp = fuerzas.get(numero);
                System.out.println("Obtuve temp");

            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("No esta ese tipo de Torre");
                System.out.println("");
                L.nextLine();
                opt = true;
            }

        }
        System.out.println("Retorne fruerzaG");
        return temp;

    }

    public void Construccion(int fase) {
        fuerzas.forEach((e) -> {
            if (fase == e.getFaseHabilitada()) {
                e.Habilitar();
            }
            e.HabilitarU(fase);
        });

    }

}
