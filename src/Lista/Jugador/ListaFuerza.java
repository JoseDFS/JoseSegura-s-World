/*
 Esta clase representa las torres de fuerzas de combate que posee cada objeto jugador, es la encargada de llamar a la factoria abstracta y administrar dichos objetos en una lista.
 */
package Lista.Jugador;

import Fuerza.Factory.FuerzaG;
import Torre.Factory.TorreFactory;
import Torre.Factory.TorreProducer;
import World.Players.Jugador;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
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

    int[] costo1;
    int[] costo2;
    int[] costo3;

    public ListaFuerza() {
        this.fuerzas = new ArrayList<>();

        this.factory = TorreProducer.getFactory("Fuerza");

    }

    public ArrayList<FuerzaG> getFuerzas() {
        return fuerzas;
    }
    
    

    public void addFuerza(int faseIni, int numeroRaza, int faseTorres, Jugador jugador) throws Exception {
        String[] torresT = null;
        if (numeroRaza == 1) {
            torresT = this.torres1;

            costo1[0] = 1000;
            costo1[1] = 750;
            costo1[2] = 0;

            costo2[0] = 1000;
            costo2[1] = 1000;
            costo2[2] = 750;

            costo3[0] = 2000;
            costo3[1] = 1000;
            costo3[2] = 1000;
        }
        if (numeroRaza == 2) {
            torresT = this.torres2;

            costo1[0] = 750;
            costo1[1] = 500;
            costo1[2] = 0;

            costo2[0] = 1000;
            costo2[1] = 500;
            costo2[2] = 300;

            costo3[0] = 2000;
            costo3[1] = 1500;
            costo3[2] = 1000;
        }
        if (numeroRaza == 3) {
            torresT = this.torres3;

            costo1[0] = 1000;
            costo1[1] = 750;
            costo1[2] = 0;

            costo2[0] = 1000;
            costo2[1] = 1000;
            costo2[2] = 750;

            costo3[0] = 2000;
            costo3[1] = 1000;
            costo3[2] = 1000;
        }
        boolean construir = false;
        boolean opt = true;
        String torre = "";
        Scanner choose = new Scanner(System.in);
        System.out.println("Que tipo de Torre de Fuerzas de Combate quiere construir? Escriba el numero de la Torre.");
        while (opt) {
            for (int i = 0; i < torresT.length; i++) {
                System.out.println((i + 1) + "." + torresT[i]);
            }
            try {
                int po = Integer.parseInt(choose.nextLine()) - 1;
                if ((po == 1) && (jugador.getR1() >= costo1[0]) && (jugador.getR2() >= costo1[1]) && (jugador.getR3() >= costo1[2])) {
                    torre = torresT[po];
                    construir = true;
                    opt = false;
                }
                if ((po == 2) && (jugador.getR1() >= costo2[0]) && (jugador.getR2() >= costo2[1]) && (jugador.getR3() >= costo2[2])) {
                    torre = torresT[po];
                    construir = true;
                    opt = false;
                }
                if ((po == 3) && (jugador.getR1() >= costo3[0]) && (jugador.getR2() >= costo3[1]) && (jugador.getR3() >= costo3[2])) {
                    torre = torresT[po];
                    construir = true;
                    opt = false;
                } else {
                    System.out.println("No tiene los suficientes recursos" + "\n" + "1.Atras 2.Elegir otra Torre");
                    int opc = -44;

                    try {

                        opc = choose.nextInt();
                        System.out.println("");
                        switch (opc) {
                            case 1:
                                opt = false;
                                break;

                            case 2:
                                opt = true;
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

            } catch (IndexOutOfBoundsException e) {
                System.err.println("No esta ese tipo de Torre");
                System.out.println("");
                choose.nextLine();
                opt = true;
                construir = false;
            }

        }
        if (construir) {
            FuerzaG fuerza = factory.getFuerzaG(torre, (faseIni + faseTorres), numeroRaza);
            fuerzas.add(fuerza);
        }
    }

    public void mostrar() {

        if (fuerzas.isEmpty()) {
            System.out.println("No hay torres de fuerzas");
        } else {
            System.out.println("-----Torres de Combate-----");
            System.out.println("  Tipo:         |  Vida:  | Estado:");
            fuerzas.forEach((e) -> {

                System.out.println(fuerzas.indexOf(e) + 1 + "." + e.toString());

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

            } catch (IndexOutOfBoundsException e) {
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
            if (e.getVida() <= 0) {
                eliminar(e);
            }
            e.HabilitarU(fase);
        });

    }

    public void eliminar(FuerzaG elim) {

        System.out.println("Ha caido una torre");
        for (Iterator<FuerzaG> iter = fuerzas.iterator(); iter.hasNext();) {
            FuerzaG fuerza = iter.next();
            if (fuerza.equals(elim)) {
                iter.remove();

            }
        }

    }

    public void mostrarHabililitadas() {
        if (fuerzas.isEmpty()) {
            System.out.println("No hay torres de fuerzas habilitadas");

        } else {
            System.out.println("-----Torres de Combate-----");
            System.out.println("  Tipo:         |  Vida:  | Estado:");
            fuerzas.forEach((e) -> {
                if (e.getHabilitada()) {
                    System.out.println(fuerzas.indexOf(e) + 1 + "." + e.toString());

                }

            });

        }
    }

    public FuerzaG elegirTorreAtaque() {
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
                if (temp.getHabilitada()) {
                    System.out.println("Obtuve temp");
                } else {
                    System.out.println("La torre no esta construida, puede ser que el enemigo no tenga torres aun construidas." + "\n" + "1.Atras 2.Elegir otra Torre");
                    int opc = -44;

                    try {

                        opc = L.nextInt();
                        System.out.println("");
                        switch (opc) {
                            case 1:
                                temp = null;
                                break;

                            case 2:
                                opt = true;
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
                        L.nextLine();

                    }
                }

            } catch (IndexOutOfBoundsException e) {
                System.err.println("No esta ese tipo de Torre");
                System.out.println("");
                L.nextLine();
                opt = true;
            }

        }
        System.out.println("Retorne fruerzaG");
        return temp;

    }

}
