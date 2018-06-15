/*
Esta clase es la que representa el objeto fuerza que son las torres en las que todas tienen en comun varios metodos o atributos, la instancia de este estara manejado por el patron de disenio
builder. En este caso sera administrado por la clase director fuerza. 

Esta clase implementa la interfaz fuerza G que es de donde hereda los metodos a utilizar.
 */
package Fuerza.Builder;

import Fuerza.Factory.FuerzaG;
import Fuerza.Unidad.Unidad;
import World.Players.Jugador;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Fuerza implements FuerzaG {

    private final String tipo;
    private final int FaseHabilitada;

    private boolean habilitada;
    private int vida;

    private int trayectoUnidad;
    private int vidaUnidad;
    private int ataqueUnidad;
    private int faseUnidad;
    private int costo1, costo2, costo3;

    private int numeroF;

    private Unidad atacando = null;

    private ArrayList<Unidad> unidades;

    Fuerza(FuerzaBuilder builder) {
        this.FaseHabilitada = builder.FaseHabilitada;
        this.vida = builder.vida;
        this.tipo = builder.tipo;
        this.habilitada = builder.habilitada;
        this.ataqueUnidad = builder.ataqueUnidad;
        this.vidaUnidad = builder.vidaUnidad;
        this.faseUnidad = builder.faseUnidad;
        this.trayectoUnidad = builder.trayectoUnidad;
        this.numeroF = builder.numeroF;
        if (numeroF == 1) {
            costo1 = 200;
            costo2 = 150;
            costo3 = 300;
        }
        if (numeroF == 2) {
            costo1 = 300;
            costo2 = 450;
            costo3 = 300;
        }

        if (numeroF == 3) {
            costo1 = 350;
            costo2 = 150;
            costo3 = 500;
        }
        this.unidades = new ArrayList<>();
    }

    public String isHabilitada() {
        if (this.habilitada) {
            return "Construida";
        } else {
            return "En construccion...";
        }
    }

    @Override
    public void Entrenar(int fase, Jugador j) {
        if (j.getR1() >= costo1 && j.getR1() >= costo2 && j.getR1() >= costo3) {
            Unidad unidad = new Unidad(this.tipo + "_" + (unidades.size() + 1), "Entrenando", this.vidaUnidad, this.ataqueUnidad, this.faseUnidad + fase, this.trayectoUnidad);
            unidades.add(unidad);
        } else {
            System.out.println("No tienes los suficientes recursos.");
        }

    }

    @Override
    public void mostrarUnidades() {
        if (unidades.isEmpty()) {
            System.out.println("No hay torres de fuerzas");
        } else {
            System.out.println("-----Unidades de Combate-----");
            System.out.println("  Tipo:      |  Vida:  |   Ataque:  | Estado:");
            unidades.forEach((e) -> {

                System.out.println(unidades.indexOf(e) + 1 + "." + e.toString());

            });

        }
    }

    @Override
    public boolean getHabilitada() {
        return this.habilitada;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }

    public ArrayList<Unidad> getUnidades() {
        return unidades;
    }

    @Override
    public int getFaseHabilitada() {
        return FaseHabilitada;
    }

    @Override
    public void Habilitar() {
        this.habilitada = true;
    }

    @Override
    public void HabilitarU(int fase) {
        if (unidades.isEmpty()) {
            System.out.println("No hay unidades");
        } else {
            unidades.forEach((e) -> {
                if (fase == e.getFaseHabilitada()) {
                    e.Habilitar();
                }
                if (fase == e.getFaseAtaque()) {
                    e.setEstado("Atacando");
                }
                if (e.getEstado().equals("Atacando")) {
                    if (e.getAtacandoT() != null) {
                        e.AtacarT();
                    }
                    if (e.getAtacandoM() != null) {
                        e.AtacarM();
                    }
                    if (e.getAtacandoJ() != null) {
                        e.AtacarJ();
                    }
                }
                if (e.getEstado().equals("Defendiendo")) {
                    e.AtacarU();
                }

            });

        }
    }

    @Override
    public String toString() {
        return "Torre" + " " + tipo + "       " + vida + "      " + this.isHabilitada();
    }

    @Override
    public Unidad ElegirUnidad() {
        int numero = -1;
        boolean opt = true;
        Unidad temp = null;

        Scanner L = new Scanner(System.in);
        while (opt) {
            try {
                System.out.println("Elija el numero del escuadron:");
                numero = Integer.parseInt(L.nextLine()) - 1;
                opt = false;

                temp = unidades.get(numero);
                if (temp.isHabilitada().equals("Esperando ordenes")) {
                    System.out.println("Obtuve tempU");

                } else {

                    System.out.println("La unidad esta entrenando.. desea regresar al menu de Unidades o elegir otra unidad? " + "\n" + "1.Atras 2.Elegir otra Unidad");
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

            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("No esta ese tipo de Torre");
                System.out.println("");
                L.nextLine();
                opt = true;
            }

        }
        System.out.println("Retorne Unidad");
        return temp;

    }

    @Override
    public void setAtacadaPor(Unidad unidad) {
        this.atacando = unidad;
    }

    @Override
    public Unidad GetAtacadaPor() {
        return this.atacando;
    }

    @Override
    public int getCosto1() {
        return this.costo1;
    }

    @Override
    public int getCosto2() {
        return this.costo2;
    }

    @Override
    public int getCosto3() {
        return this.costo3;
    }

    /*
    Esta es la clase estatica builder que se encargara de crear el objeto fuerza G segun los parametros dados, esto diferenciara una torre de otra.
    
     */
    public static class FuerzaBuilder {

        private final String tipo;
        private final int FaseHabilitada;

        private boolean habilitada;
        private int vida;
        private int ataqueUnidad;
        private int vidaUnidad;
        private int faseUnidad;
        private int trayectoUnidad;
        private int numeroF;

        public FuerzaBuilder(String tipo, int vida, int FaseHabilitada, int vidaUnidad, int ataqueUnidad, int faseU, int trayectoUnidad, int numeroF) {

            this.FaseHabilitada = FaseHabilitada;
            this.tipo = tipo;
            this.vida = vida;
            this.habilitada = false;
            this.ataqueUnidad = ataqueUnidad;
            this.vidaUnidad = vidaUnidad;
            this.faseUnidad = faseU;
            this.trayectoUnidad = trayectoUnidad;
            this.numeroF = numeroF;
        }

        public Fuerza build() {
            return new Fuerza(this);
        }
    }
}
