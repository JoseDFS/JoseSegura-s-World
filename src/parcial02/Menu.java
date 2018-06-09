/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial02;

import Lista.Jugador.ListaFuerza;
import World.Players.Jugador;
import Worlds.Raza.ListaRazas;
import Worlds.Raza.Raza;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Menu {

    private static Menu menu;

    private Jugador Jugador1;
    private Jugador Jugador2 ;
   
    private final ListaRazas Razas = new ListaRazas();
    
    private int Fase = 1;

    private boolean runn = true;

    private Scanner choose = new Scanner(System.in);

    private Menu() {
        IniJugador( 1);
        IniJugador( 2);
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public void IniJugador( int i) {
        String n = "";

        while (n.isEmpty()) {
            System.out.println("Ingrese Nick del Jugador" + i + ":");
            n = choose.nextLine();
            if (n.isEmpty()) {
                System.out.println("No ha ingresado un nombre");
                System.out.println("");
            }

        }
        if(i==1)
            Jugador1= new Jugador(n,Razas.elegirRaza());
        else
            Jugador2= new Jugador(n,Razas.elegirRaza());
        
        
    }

    public void mostrar() {
        while (runn) {
            System.out.println("[[[[[[[[[[[[[[[[ Turno Jugador1 ]]]]]]]]]]]]]]]]");
            Turno("============[ " + Jugador1.getNick() + " ]===========" + "\n" + Jugador1.toString());
            System.out.println("[[[[[[[[[[[[[[[[Turno Jugador2]]]]]]]]]]]]]]]]");
            Turno("============[ " + Jugador2.getNick() + " ]===========" + "\n" + Jugador2.toString());
            Fase++;
            System.out.println("Fase terminada:" + Fase);
        }

    }

    public void Opc1() {
        System.out.println("1. Construir.");
        System.out.println("2. Gestionar Minas.");
        System.out.println("3. Gestionar Fuerzas de combate.");
        System.out.println("4. Atacar.");
        System.out.println("5. Defender.");
        System.out.println("6. Mejorar.");
        System.out.println("7. Terminar Turno.");
    }

    public void Turno(String jugador) {
        int optn = -44;

        while (optn != 7) {
            System.out.println(jugador);
            Opc1();
            try {
                System.out.println("--------------------------------------");
                optn = choose.nextInt();
                System.out.println("");
                switch (optn) {
                    case 1:
                        System.out.println("Construyendo");
                        //subMenu1();
                        break;
                    case 2:
                        System.out.println("Minas");
                        //subMenu2();
                        break;
                    case 3:
                        System.out.println("Fuerzas");
                        //subMenu3();
                        break;

                    case 4:
                        System.out.println("Atacando");
                        //subMenu4();
                        break;

                    case 5:
                        System.out.println("Defendiendo");
                        //subMenu4();
                        break;

                    case 6:
                        System.out.println("Mejorando");
                        //subMenu4();
                        break;

                    case 7:
                        System.out.println("Turno finalizado");
                        System.out.println("");
                        break;
                    default:
                        System.out.println("opción no valida");
                        System.out.println("");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Caractér o caracteres no validos");
                System.out.println("");
                choose.nextLine();
            }
        }

    }
}
