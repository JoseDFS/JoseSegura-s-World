/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Worlds.Raza;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class ListaRazas {

    private ArrayList<Raza> razas;

    Scanner L = new Scanner(System.in);

    public ListaRazas() {
        razas = new ArrayList<>();

        Raza Elfos = new Raza("Elfos", "", 3, 2, 2, 3, 1);
        razas.add(Elfos);

        Raza Enanos = new Raza("Enanos", "", 2, 1, 2, 2, 2);
        razas.add(Enanos);

        Raza ExMachina = new Raza("Ex-Machina", "", 1, 2, 2, 3, 3);
        razas.add(ExMachina);

    }

    public void mostrarRazas() {

        if (razas.isEmpty()) {
            System.out.println("No hay razas");
        } else {
            System.out.println("--------Disboard------");
            System.out.println("---------Razas--------");
            System.out.println("Nombre:  | Descripcion:");
            razas.forEach((e) -> {
                System.out.println(e.toString());
            });

        }
    }

    public Raza elegirRaza() {
        Raza raza = null;

        raza = buscarRaza();
        while (raza == null) {
            System.err.println("Elija un numero de raza que pertenezca a la lista");
            raza = buscarRaza();
        }
        System.out.println("Se ha seleccionado la raza:" + "" + raza.getNombre());
        System.out.println("");

        return raza;

    }

    private Raza buscarRaza() {
        Raza raza = null;
        int opc = 0;
        String n = "";

        System.out.println("Elige una raza:");
        mostrarRazas();
        System.out.println("");
        String bug = "";
        while (n.isEmpty()) {
            n = L.nextLine();
            if (n.isEmpty()) {
                System.out.println("No ha ingresado nada");

            } else {
                try {
                    opc = Integer.parseInt(n);
                } catch (NumberFormatException e) {
                    System.err.println("Escriba el numero de la raza a elegir");
                    System.out.println("");
                    n = "";
                }
            }

        }

        for (Iterator<Raza> iter = razas.iterator(); iter.hasNext();) {
            Raza tempRaza = iter.next();
            if (tempRaza.getNumeroRaza() == opc) {
                raza = tempRaza;

            }
        }
        return raza;
    }

}
