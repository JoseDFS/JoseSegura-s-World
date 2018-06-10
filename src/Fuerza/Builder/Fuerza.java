/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuerza.Builder;

import Fuerza.Factory.FuerzaG;
import Fuerza.Unidad.Unidad;
import java.util.ArrayList;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Fuerza implements FuerzaG {

    private final String tipo;
    private final int FaseHabilitada;

    private boolean habilitada;
    private int vida;

    private int vidaUnidad;
    private int ataqueUnidad;
    private int faseUnidad;

    private ArrayList<Unidad> unidades;

    private Fuerza(FuerzaBuilder builder) {
        this.FaseHabilitada = builder.FaseHabilitada;
        this.vida = builder.vida;
        this.tipo = builder.tipo;
        this.habilitada = builder.habilitada;
        this.ataqueUnidad = builder.ataqueUnidad;
        this.vidaUnidad = builder.vidaUnidad;
        this.faseUnidad = builder.faseUnidad;
    }

    public String isHabilitada() {
        if (this.habilitada) {
            return "Construida";
        } else {
            return "En construccion...";
        }
    }

    @Override
    public void Entrenar(int fase) {

        Unidad unidad = new Unidad(this.tipo + (unidades.size() + 1), "Entrenando", this.vidaUnidad, this.ataqueUnidad, this.faseUnidad + fase);
        unidades.add(unidad);
    }

    public void mostrarUnidad() {
        if (unidades.isEmpty()) {
            System.out.println("No hay torres de fuerzas");
        } else {
            System.out.println("-----Unidades de Combate-----");
            System.out.println("  Tipo:       |  Vida:  |   Ataque:  | Estado:");
            unidades.forEach((e) -> {
                int cont = 1;
                System.out.println(cont + "." + e.toString());
                cont++;
            });

        }
    }

    public String getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
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
                if(fase == e.getFaseHabilitada())
                    e.Habilitar();
            });

        }
    }

    @Override
    public String toString() {
        return "Torre" + " " + tipo + "       " + vida + "      " + this.isHabilitada();
    }

    public static class FuerzaBuilder {

        private final String tipo;
        private final int FaseHabilitada;

        private boolean habilitada;
        private int vida;
        private int ataqueUnidad;
        private int vidaUnidad;
        private int faseUnidad;

        public FuerzaBuilder(String tipo, int vida, int FaseHabilitada, int vidaUnidad, int ataqueUnidad, int faseU) {

            this.FaseHabilitada = FaseHabilitada;
            this.tipo = tipo;
            this.vida = vida;
            this.habilitada = false;
            this.ataqueUnidad = ataqueUnidad;
            this.vidaUnidad = vidaUnidad;
            this.faseUnidad = faseU;
        }

        public Fuerza build() {
            return new Fuerza(this);
        }
    }

}
