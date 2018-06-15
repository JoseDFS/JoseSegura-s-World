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

    int costo1, costo2, costo3, costo4, costo5, costo6, costo7, costo8, costo9;

    public ListaFuerza() {
        this.fuerzas = new ArrayList<>();

        this.factory = TorreProducer.getFactory("Fuerza");

    }

    public ArrayList<FuerzaG> getFuerzas() {
        return fuerzas;
    }

    public void addFuerza(int faseIni, int numeroRaza, int faseTorres, Jugador jugador) throws Exception {
     
        String[] torresT = null;
        FuerzaG fuerza = null;
        if (numeroRaza == 1) {
            torresT = this.torres1;

            costo1 = 2000;
            costo2 = 1000;
            costo3 = 300;

            costo4 = 1500;
            costo5 = 1000;
            costo6 = 200;

            costo7 = 1500;
            costo8 = 1000;
            costo9 = 450;
        }
        if (numeroRaza == 2) {
            torresT = this.torres2;

            costo1 = 1500;
            costo2 = 750;
            costo3 = 300;

            costo4 = 1300;
            costo5 = 1000;
            costo6 = 200;

            costo7 = 1500;
            costo8 = 1000;
            costo9 = 450;
        }
        if (numeroRaza == 3) {
            torresT = this.torres3;

            costo1 = 2000;
            costo2 = 750;
            costo3 = 150;

            costo4 = 1350;
            costo5 = 1000;
            costo6 = 450;

            costo7 = 1000;
            costo8 = 2350;
            costo9 = 600;
        }
        boolean construir = false;
        boolean opt = true;
        String torre = "";
        Scanner choose = new Scanner(System.in);
        System.out.println("Que tipo de Torre de fuerzas de combate quiere construir? Escriba el numero de la Torre.");
        while (opt) {
            for (int i = 0; i < torresT.length; i++) {
                System.out.println((i + 1) + "." + torresT[i]);
            }
            try {
                int po = Integer.parseInt(choose.nextLine()) - 1;
                if ((po == 1) && (jugador.getR1() >= costo1) && (jugador.getR2() >= costo2) && (jugador.getR3() >= costo3)) {
                    torre = torresT[po];
                    construir = true;
                    opt = false;
                }
                if ((po == 2) && (jugador.getR1() >= costo4) && (jugador.getR2() >= costo5) && (jugador.getR3() >= costo6)) {
                    torre = torresT[po];
                    construir = true;
                    opt = false;
                }
                if ((po == 3) && (jugador.getR1() >= costo7) && (jugador.getR2() >= costo8) && (jugador.getR3() >= costo9)) {
                    torre = torresT[po];
                    construir = true;
                    opt = false;
                }
                 else{
                 System.out.println("No tiene los suficientes recursos" );
                 opt = false;
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
            fuerza = factory.getFuerzaG(torre, (faseIni + faseTorres), numeroRaza);
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
