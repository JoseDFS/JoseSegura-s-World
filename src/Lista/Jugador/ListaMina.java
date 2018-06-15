/*
 Esta clase es la que representa los objetos tipo mina que posee cada objeto jugador y es la encargada de llamar a la factoria abstracta y administrar dichos objetos en una lista.
 */
package Lista.Jugador;

import Mina.Factory.MinaFactory;
import Mina.Factory.MinaG;
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
public class ListaMina {

    private ArrayList<MinaG> minas;
    private TorreFactory factory;
    private String[] minas1 = {"Lithium", "Mana", "Spiritus"};
    private String[] minas2 = {"Obsidiana", "Hierro", "Armonium"};
    private String[] minas3 = {"Beltium", "Cranium", "Solium"};

    int costo1,costo2,costo3,costo4,costo5,costo6,costo7,costo8,costo9;
    

    public ListaMina() {
        this.minas = new ArrayList<>();
        this.factory = TorreProducer.getFactory("Mina");

    }

    public ArrayList<MinaG> getMinas() {
        return minas;
    }
    
    

    public void addMina(int faseIni, int numeroRaza, int faseMinas, Jugador jugador) throws Exception {
        String[] MinasM = null;
        MinaG minag  = null;
        if (numeroRaza == 1) {
            MinasM = this.minas1;

            costo1 = 2000;
            costo2= 1000;
            costo3 = 0;

            costo4= 1500;
            costo5 = 1000;
            costo6 = 750;

            costo7= 1500;
            costo8= 1000;
            costo9 = 0;
        }
        if (numeroRaza == 2) {
            MinasM = this.minas2;

            costo1 = 750;
            costo2 = 500;
            costo3 = 0;

            costo4 = 1000;
            costo5 = 500;
            costo6 = 300;

            costo7 = 2000;
            costo8 = 1500;
            costo9 = 0;
        }
        if (numeroRaza == 3) {
            MinasM = this.minas3;

            costo1 = 1000;
            costo2 = 750;
            costo3 = 0;

            costo4 = 1000;
            costo5 = 1000;
            costo6 = 750;

            costo7 = 2000;
            costo8 = 1000;
            costo9 = 0;
        }
        boolean construir = false;
        boolean opt = true;
        String mina = "";
        Scanner choose = new Scanner(System.in);
        System.out.println("Que tipo de Mina quiere construir? Escriba el numero de la Mina.");
        while (opt) {
            for (int i = 0; i < MinasM.length; i++) {
                System.out.println((i + 1) + "." + MinasM[i]);
            }
            try {
                int po = Integer.parseInt(choose.nextLine()) - 1;
                if ((po == 1) && (jugador.getR1() >= costo1) && (jugador.getR2() >= costo2) && (jugador.getR3() >= costo3)) {
                    mina = MinasM[po];
                    construir = true;
                    opt = false;
                }
                if ((po == 2) && (jugador.getR1() >= costo4) && (jugador.getR2() >= costo5) && (jugador.getR3() >= costo6)) {
                    mina = MinasM[po];
                    construir = true;
                    opt = false;
                }
                if ((po == 3) && (jugador.getR1() >= costo7) && (jugador.getR2() >= costo8) && (jugador.getR3() >= costo9)) {
                    mina = MinasM[po];
                    construir = true;
                    opt = false;
                }
                else{
                 System.out.println("No tiene los suficientes recursos");
                 opt = false;
                }
                    
                    
            } catch (IndexOutOfBoundsException e) {
                System.err.println("No esta ese tipo de Mina");
                System.out.println("");
                choose.nextLine();
                opt = true;
                construir = false;

            }

        }
        if(construir){
        minag = factory.getMinaG(mina, (faseIni + faseMinas), numeroRaza);
        minas.add(minag);
        }
       
    }

    public void mostrar() {

        if (minas.isEmpty()) {
            System.out.println("No hay minas construidas");
        } else {
            System.out.println("-----Minas-----");
            System.out.println("  Tipo:         |  Vida:  | Estado:");
            minas.forEach((e) -> {

                System.out.println(minas.indexOf(e) + 1 + "." + e.toString());

            });

        }
    }

    public MinaG elegirTorre() {
        int numero = -1;
        boolean opt = true;
        MinaG temp = null;
        System.out.println("Elija el numero de la mina:");
        Scanner L = new Scanner(System.in);
        while (opt) {
            try {
                numero = Integer.parseInt(L.nextLine()) - 1;
                opt = false;

                temp = minas.get(numero);
                System.out.println("Obtuve temp");

            } catch (IndexOutOfBoundsException e) {
                System.err.println("No esta ese tipo de Torre");
                System.out.println("");
                L.nextLine();
                opt = true;
            }

        }
        System.out.println("Retorne minaG");
        return temp;

    }
public MinaG elegirMinaAtaque() {
        int numero = -1;
        boolean opt = true;
        MinaG temp = null;
        System.out.println("Elija el numero de la torre:");
        Scanner L = new Scanner(System.in);
        while (opt) {
            try {
                numero = Integer.parseInt(L.nextLine()) - 1;
                opt = false;

                temp = minas.get(numero);
                if (temp.getHabilitada()) {
                    System.out.println("Obtuve temp");
                } else {
                    System.out.println("La torre no esta construida, puede ser que el enemigo no tenga minas aun construidas." + "\n" + "1.Atras 2.Elegir otra Mina");
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
        System.out.println("Retorne MinaG");
        return temp;

    }
    public void Construccion(int fase) {
        minas.forEach((e) -> {
            if (fase == e.getFaseHabilitada()) {
                e.Habilitar();
            }
            if (e.getVida() <= 0) {
                eliminar(e);
            }
            if (e.getCapacidad() > 0) {
                e.setRecurso(e.getRecurso() + e.getGenerar());
            }

        });

    }

    public void eliminar(MinaG elim) {

        System.out.println("Ha caido una mina");
        for (Iterator<MinaG> iter = minas.iterator(); iter.hasNext();) {
            MinaG fuerza = iter.next();
            if (fuerza.equals(elim)) {
                iter.remove();

            }
        }

    }
}
