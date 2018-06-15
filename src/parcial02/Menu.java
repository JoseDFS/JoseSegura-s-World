/*
Esta clase es el menu que usan el patron de disenio singleton y es la que manejara el loop del programa obteniendo solo una y unica instancia del mismo.

Esta tiene varios metodos que inicializara los objetos jugador, y al mismo tiempo, tendra acceso a varios metodos que le permitiran utilizar los atributos y metodos del objeto jugador. 
A su vez, lleva el conteo de la fase global del programa.
 */
package parcial02;

import Fuerza.Factory.FuerzaG;
import Fuerza.Unidad.Unidad;
import Lista.Jugador.ListaFuerza;
import Mina.Factory.MinaG;
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
// Este metodo setea los valores requeridos que tiene que tener el objeto jugador.

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
// Este metodo es el que lleva el loop del programa y administra la fase global del programa.

    public void mostrar() throws Exception {
        while (runn) {

            System.out.println("[[[[[[[[[[[[[[[[ Turno Jugador1 ]]]]]]]]]]]]]]]]");
            Turno(Jugador1, Jugador2);
            System.out.println("[[[[[[[[[[[[[[[[ Turno Jugador2 ]]]]]]]]]]]]]]]]");

            Turno(Jugador2, Jugador1);

            if (Jugador1.getVida() <= 0) {
                System.out.println(Jugador2.getNick() + "" + "HA GANADO");
                runn = false;
            }
            if (Jugador2.getVida() <= 0) {
                System.out.println(Jugador1.getNick() + "" + "HA GANADO");
                runn = false;
            }
            Fase++;
            System.out.println("Fase terminada:" + Fase);
        }

    }

    public void Opc1() {
        System.out.println("1. Construir.");
        System.out.println("2. Gestionar Minas.");
        System.out.println("3. Gestionar Fuerzas de combate.");
        System.out.println("4. Mejorar.");
        System.out.println("5. Terminar Turno.");
    }

    public void Opc2() {
        System.out.println("1. Entrenar.");
        System.out.println("2. Gestionar Unidades.");
        System.out.println("3. Atras.");

    }

    public void Opc3() {
        System.out.println("1. Atacar.");
        System.out.println("2. Defender.");
        System.out.println("3. Atras.");

    }

    public void Opc4() {
        System.out.println("1. Recolectar o Generar Recursos.");

        System.out.println("2. Atras.");

    }
// Este metodo es el que muestra las opciones de las principales acciones que puede realizar un jugador en su turno.

    public void Turno(Jugador jugadorA, Jugador jugadorB) throws Exception {
        jugadorA.Fuerzas.Construccion(Fase);
        jugadorA.Minas.Construccion(Fase);
        jugadorA.setR1(jugadorA.getR1()+300);
        jugadorA.setR2(jugadorA.getR1()+400);
       
        
        
        FuerzaG temp = null;
        MinaG temp2 = null;

        int optn = -44;

        while (optn != 5) {
            System.out.println("============[ " + jugadorA.getNick() + " ]===========" + "\n" + jugadorA.toString());

            Opc1();
            try {
                System.out.println("--------------------------------------");
                optn = choose.nextInt();
                System.out.println("");
                switch (optn) {
                    case 1:
                        System.out.println("Construyendo");
                        System.out.println("1.Torres de Combate.");
                        System.out.println("2.Minas.");
                        System.out.println("3.Atras.");
                        int opc = -44;

                        try {
                            System.out.println("--------------------------------------");
                            opc = choose.nextInt();
                            System.out.println("");
                            switch (opc) {
                                case 1:
                                    System.out.println("----------Torres de combate--------------");

                                    jugadorA.Fuerzas.addFuerza(Fase, jugadorA.getNumeroRaza(), jugadorA.getRaza().getFaseTorres(), jugadorA);
                                    System.out.println("se construyo torre");
                                    break;

                                case 2:
                                    System.out.println("----------Minas--------------");

                                     jugadorA.Minas.addMina(Fase, jugadorA.getNumeroRaza(), jugadorA.getRaza().getFaseTorres(), jugadorA);
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

                        break;

                    case 2:
                        System.out.println("Minas");
                        GestionMinas(jugadorA);
                        break;
                    case 3:
                        System.out.println("Fuerzas");
                        if ((jugadorB.getFuerzas().getFuerzas().isEmpty()) && (jugadorB.getMinas().getMinas().isEmpty())) {
                            AtacarCentro(jugadorA, jugadorB);
                        } else {
                            GestionFuerzas(jugadorA, jugadorB);
                        }
                        break;

                    case 4:
                        System.out.println("Mejorando");
                        int CostoT = 0,
                         costor1,
                         costor2,
                         costor3;
                        if (jugadorA.getMejora() == 1) {
                            CostoT = (int) (0.25 * (11000 + 5500 + 3300));
                            costor1 = CostoT / 3;
                            costor2 = CostoT / 3;
                            costor3 = CostoT / 3;

                            if (jugadorA.getR1() >= costor1 && jugadorA.getR2() >= costor2 && jugadorA.getR1() >= costor1) {
                                jugadorA.setCapacidad1(11000);
                                jugadorA.setCapacidad2(5500);
                                jugadorA.setCapacidad2(3300);

                            } else {
                                System.out.println("No tienes los recursos suficientes");
                            }

                        }
                        if (jugadorA.getMejora() == 2) {
                            CostoT = (int) (0.25 * (12100 + 6050 + 3630));
                            costor1 = CostoT / 3;
                            costor2 = CostoT / 3;
                            costor3 = CostoT / 3;

                            if (jugadorA.getR1() >= costor1 && jugadorA.getR2() >= costor2 && jugadorA.getR1() >= costor1) {
                                jugadorA.setCapacidad1(12100);
                                jugadorA.setCapacidad2(6050);
                                jugadorA.setCapacidad2(3630);

                            } else {
                                System.out.println("No tienes los recursos suficientes");
                            }
                        }
                        if (jugadorA.getMejora() == 3) {
                            CostoT = (int) (0.25 * (13310 + 6655 + 3993));
                            costor1 = CostoT / 3;
                            costor2 = CostoT / 3;
                            costor3 = CostoT / 3;

                            if (jugadorA.getR1() >= costor1 && jugadorA.getR2() >= costor2 && jugadorA.getR1() >= costor1) {
                                jugadorA.setCapacidad1(13310);
                                jugadorA.setCapacidad2(6655);
                                jugadorA.setCapacidad2(3993);

                            } else {
                                System.out.println("No tienes los recursos suficientes");
                            }
                        }

                        break;

                    case 5:
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
// Este metodo permite el acceso a las unidades que pertenecen al jugador que esta en turno.

    public void Unidades(Jugador jugadorA, Jugador jugadorB) {
        FuerzaG temp = null;
        FuerzaG temp2 = null;

        MinaG temp3 = null;
        Unidad unidad = null;
        Unidad unidad2 = null;
        boolean bool = true;
        System.out.println("Unidades");
        jugadorA.Fuerzas.mostrar();

        int optn = -44;

        while (optn != 3) {

            System.out.println("============[ " + jugadorA.getNick() + " ]===========" + "\n" + jugadorA.toString());
            Opc3();
            try {
                System.out.println("--------------------------------------");
                optn = choose.nextInt();
                System.out.println("");
                switch (optn) {
                    case 1:
                        try {
                            int optn2 = -42;
                            System.out.println("--------------------------------------");
                            System.out.println("Atacar Torres de Fuerza o Minas?" + "\n" + "1.Torres  2.Minas");
                            optn2 = choose.nextInt();
                            System.out.println("");
                            switch (optn2) {
                                case 1:
                                    temp = jugadorA.Fuerzas.elegirTorre();

                                    System.out.println("Atacando");
                                    temp.mostrarUnidades();
                                    unidad = temp.ElegirUnidad();
                                    if (unidad == null) {
                                        System.out.println("Unidad null");
                                        break;
                                    }
                                    System.out.println("============[ " + "Enemigo:" + jugadorB.getNick() + " ]===========");
                                    jugadorB.Fuerzas.mostrar();
                                    temp2 = jugadorB.Fuerzas.elegirTorreAtaque();
                                    if (temp2 == null) {
                                        System.out.println("temp null");
                                        break;
                                    }
                                    temp2.setAtacadaPor(unidad);
                                    unidad.MAtacar(temp2, Fase);
                                    break;
                                case 2:
                                    temp = jugadorA.Fuerzas.elegirTorre();

                                    System.out.println("Atacando");
                                    temp.mostrarUnidades();
                                    unidad = temp.ElegirUnidad();
                                    if (unidad == null) {
                                        System.out.println("Unidad null");
                                        break;
                                    }
                                    System.out.println("============[ " + "Enemigo:" + jugadorB.getNick() + " ]===========");
                                    jugadorB.Minas.mostrar();
                                    temp3 = jugadorB.Minas.elegirMinaAtaque();
                                    if (temp3 == null) {
                                        System.out.println("temp null");
                                        break;
                                    }
                                    temp3.setAtacadaPor(unidad);
                                    unidad.MAtacarM(temp3, Fase);
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

                        break;
                    case 2:
                        System.out.println("Defendiendo");
                        if (jugadorA.getAtacadaPor() != null) {
                            System.out.println("Defendiendo Centro de mando!!!");
                            temp = jugadorA.Fuerzas.elegirTorre();

                            temp.mostrarUnidades();
                            unidad = temp.ElegirUnidad();
                            if (unidad == null) {
                                System.out.println("Esta torre no tiene unidades disponibles");
                                temp2 = jugadorA.Fuerzas.elegirTorre();
                                while (unidad == null || bool) {
                                    temp.ElegirUnidad();
                                    System.out.println("La torre no tiene unidades disponibles." + "\n" + "1.Atras 2.Elegir otra Torre");
                                    int opc = -44;

                                    try {

                                        opc = choose.nextInt();
                                        System.out.println("");
                                        switch (opc) {
                                            case 1:
                                                bool = false;
                                                break;

                                            case 2:

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
                                if (!bool) {
                                    break;
                                }
                            }

                            unidad2 = jugadorA.getAtacadaPor();
                            if (unidad2 == null) {
                                System.out.println("Esta torre no esta siendo atacada");
                                break;
                            }

                            unidad.MDefender(unidad2);

                        } else {
                            System.out.println("Que torre desea defender?");
                            temp = jugadorA.Fuerzas.elegirTorre();

                            temp.mostrarUnidades();
                            unidad = temp.ElegirUnidad();
                            if (unidad == null) {
                                System.out.println("Esta torre no tiene unidades disponibles");
                                temp2 = jugadorA.Fuerzas.elegirTorre();
                                while (unidad == null || bool) {
                                    temp2.ElegirUnidad();
                                    System.out.println("La torre no tiene unidades disponibles." + "\n" + "1.Atras 2.Elegir otra Torre");
                                    int opc = -44;

                                    try {

                                        opc = choose.nextInt();
                                        System.out.println("");
                                        switch (opc) {
                                            case 1:
                                                bool = false;
                                                break;

                                            case 2:

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
                                if (!bool) {
                                    break;
                                }
                            }

                            unidad2 = temp.GetAtacadaPor();
                            if (unidad2 == null) {
                                System.out.println("Esta torre no esta siendo atacada");
                                break;
                            }

                            unidad.MDefender(unidad2);
                        }

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
// Este metodo es el que le permite al jugador que esta en turno tener acceso a las torres que son objetos de tipo fuerzaG.

    public void GestionFuerzas(Jugador jugadorA, Jugador jugadorB) {
        FuerzaG temp = null;
        int optn = -44;
        jugadorA.Fuerzas.mostrar();
        while (optn != 3) {

            System.out.println("============[ " + jugadorA.getNick() + " ]===========" + "\n" + jugadorA.toString());
            Opc2();
            try {
                System.out.println("--------------------------------------");
                optn = choose.nextInt();
                System.out.println("");
                switch (optn) {
                    case 1:
                        System.out.println("Entrenando Unidad en la Torre a elegir");
                        jugadorA.Fuerzas.mostrar();
                        temp = jugadorA.Fuerzas.elegirTorre();

                        if (temp.getHabilitada()) {
                            System.out.println(jugadorA.getMina1() + ":" + "" + temp.getCosto1() + "  " + jugadorA.getMina2() + ":" + "" + temp.getCosto2() + "  " + jugadorA.getMina3() + ":" + "" + temp.getCosto3());
                            temp.Entrenar(Fase, jugadorA);
                        } else {
                            System.out.println("Nose se peude entrenar, torre en construccion...");
                        }

                        break;
                    case 2:
                        Unidades(jugadorA, jugadorB);
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
// Este metodo es el que le permite al jugador que esta en turno tener acceso a las torres que son objetos de tipo minaG.

    public void GestionMinas(Jugador jugadorA) {
        MinaG temp = null;
        int optn = -44;
        jugadorA.Minas.mostrar();
        while (optn != 2) {

            System.out.println("============[ " + jugadorA.getNick() + " ]===========" + "\n" + jugadorA.toString());
            Opc4();
            try {
                System.out.println("--------------------------------------");
                optn = choose.nextInt();
                System.out.println("");
                switch (optn) {
                    case 1:
                        System.out.println("Recolectando Recursos en la Mina a elegir");
                        jugadorA.Fuerzas.mostrar();
                        temp = jugadorA.Minas.elegirTorre();

                        if (temp.getHabilitada()) {
                            if (temp.getNumeroR() == 1) {
                                jugadorA.setR1(jugadorA.getR1() + temp.getRecurso());
                            }
                            if (temp.getNumeroR() == 2) {
                                jugadorA.setR1(jugadorA.getR2() + temp.getRecurso());
                            }
                            if (temp.getNumeroR() == 3) {
                                jugadorA.setR3(jugadorA.getR3() + temp.getGenerar());
                            }

                        } else {
                            System.out.println("Nose se puede recolectar o generar, torre en construccion...");
                        }

                        break;
                    case 2:

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

    private void AtacarCentro(Jugador jugadorA, Jugador jugadorB) {
        FuerzaG temp = null;

        Unidad unidad = null;

        boolean bool = true;
        System.out.println("Unidades");
        jugadorA.Fuerzas.mostrar();

        int optn = -44;

        while (optn != 2) {

            System.out.println("============[ " + jugadorA.getNick() + " ]===========" + "\n" + jugadorA.toString());

            try {

                System.out.println("--------------------------------------");

                optn = choose.nextInt();
                System.out.println("");
                switch (optn) {
                    case 1:
                        temp = jugadorA.Fuerzas.elegirTorre();

                        System.out.println("Atacando");
                        temp.mostrarUnidades();
                        unidad = temp.ElegirUnidad();
                        if (unidad == null) {
                            System.out.println("Esta torre no tiene unidades disponibles");
                            temp = jugadorA.Fuerzas.elegirTorre();
                            while (unidad == null || bool) {
                                temp.ElegirUnidad();
                                System.out.println("La torre no tiene unidades disponibles." + "\n" + "1.Atras 2.Elegir otra Torre");
                                int opc = -44;

                                try {

                                    opc = choose.nextInt();
                                    System.out.println("");
                                    switch (opc) {
                                        case 1:
                                            bool = false;
                                            break;

                                        case 2:

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
                            if (!bool) {
                                break;
                            }
                        }

                        jugadorB.setAtacadaPor(unidad);

                        unidad.MAtacarJ(jugadorB, Fase);
                        break;
                    case 2:

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
