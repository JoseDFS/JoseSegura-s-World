/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial02;

import Fuerza.Factory.FuerzaG;
import Lista.Jugador.ListaFuerza;
import World.Players.Jugador;
import Worlds.Raza.ListaRazas;
import Worlds.Raza.Raza;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Menu {

    private static Menu menu;

    private Jugador Jugador1;
    private Jugador Jugador2;

    private final ListaRazas Razas = new ListaRazas();

    private int Fase = 1;

    private boolean runn = true;

    private Scanner choose = new Scanner(System.in);

    private Menu() {
        IniJugador(1);
        IniJugador(2);
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public void IniJugador(int i) {
        String n = "";

        while (n.isEmpty()) {
            System.out.println("Ingrese Nick del Jugador" + i + ":");
            n = choose.nextLine();
            if (n.isEmpty()) {
                System.out.println("No ha ingresado un nombre");
                System.out.println("");
            }

        }
        if (i == 1) {
            Jugador1 = new Jugador(n, Razas.elegirRaza());
        } else {
            Jugador2 = new Jugador(n, Razas.elegirRaza());
        }

    }

    public void mostrar() throws Exception {
        while (runn) {
            System.out.println("[[[[[[[[[[[[[[[[ Turno Jugador1 ]]]]]]]]]]]]]]]]");
            Turno(Jugador1);
            System.out.println("[[[[[[[[[[[[[[[[ Turno Jugador2 ]]]]]]]]]]]]]]]]");

            Turno(Jugador2);
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

    public void Opc2() {
        System.out.println("1. Entrenar.");
        System.out.println("2. Gestionar Unidades.");
        System.out.println("3. Atras.");

    }

    public void Turno(Jugador jugador) throws Exception {
        jugador.Fuerzas.Construccion(Fase);
        int optn = -44;

        while (optn != 7) {
            System.out.println("============[ " + jugador.getNick() + " ]===========" + "\n" + jugador.toString());

            Opc1();
            try {
                System.out.println("--------------------------------------");
                optn = choose.nextInt();
                System.out.println("");
                switch (optn) {
                    case 1:
                        System.out.println("Construyendo");

                        jugador.Fuerzas.addFuerza(Fase, jugador.getNumeroRaza(), jugador.getRaza().getFaseTorres());

                        break;
                    case 2:
                        System.out.println("Minas");
                        //subMenu2();
                        break;
                    case 3:
                        System.out.println("Fuerzas");

                        GestionFuerzas(jugador);
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

    public void GestionFuerzas(Jugador jugador) {
        FuerzaG temp = null;
        int optn = -44;
        jugador.Fuerzas.mostrar();
        while (optn != 3) {

            System.out.println("============[ " + jugador.getNick() + " ]===========" + "\n" + jugador.toString());
            Opc2();
            try {
                System.out.println("--------------------------------------");
                optn = choose.nextInt();
                System.out.println("");
                switch (optn) {
                    case 1:
                        System.out.println("Entrenando");
                        jugador.Fuerzas.mostrar();
                        temp = jugador.Fuerzas.elegirTorre();
                        if (temp.getHabilitada()) {
                            temp.Entrenar(Fase);
                        }
                        else
                            System.out.println("Nose se peude entrenar, torre en construccion...");

                        break;
                    case 2:
                        System.out.println("Unidades");
                        jugador.Fuerzas.mostrar();
                        temp = jugador.Fuerzas.elegirTorre();
                        temp.mostrarUnidades();
                        break;
                    case 3:

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
