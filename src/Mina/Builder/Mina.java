/*
Esta clase es la que representa las minas que seran creadas por medio del patron de disenio builder.

Esta clase implementa la interfaz minaG y hereda dichos metodos que tiene esa interfaz.

 */
package Mina.Builder;

import Fuerza.Unidad.Unidad;
import Mina.Factory.MinaG;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Mina implements MinaG {

    private final String tipo;
    private final int FaseHabilitada;

    private boolean habilitada;
    private int vida;

    private int numeroR;

    private int capacidad;

    private int recurso;

    private int generar;

    private Unidad atacando = null;

    public Mina(MinaBuilder builder) {
        this.tipo = builder.tipo;
        this.FaseHabilitada = builder.FaseHabilitada;
        this.habilitada = builder.habilitada;
        this.vida = builder.vida;
        this.capacidad = builder.capacidad;
        this.generar = builder.generar;
        this.numeroR = builder.numeroR;

    }

    public String isHabilitada() {
        if (this.habilitada) {
            return "Construida";
        } else {
            return "En construccion...";
        }
    }

    @Override
    public void Habilitar() {
        this.habilitada = true;
    }

    @Override
    public boolean getHabilitada() {
        return this.habilitada;
    }

    @Override
    public int getFaseHabilitada() {
        return this.FaseHabilitada;
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
    public int getVida() {
        return this.vida;
    }

    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Mina" + " " + tipo + "       " + vida + "      " + this.isHabilitada();
    }

    @Override
    public int getRecurso() {
        return this.recurso;
    }

    @Override
    public int getCapacidad() {
        return this.capacidad;
    }

    @Override
    public void setRecurso(int r) {
        this.recurso = r;
    }

    @Override
    public int getGenerar() {
        return this.generar;
    }

    @Override
    public int getNumeroR() {
        return this.numeroR;
    }

    /*
    Esta es la clase estatica builder que es la que se encargara de crear los objetos tipo mina segun los parametros dados.
    */
    public static class MinaBuilder {

        private final String tipo;
        private final int FaseHabilitada;

        private boolean habilitada;
        private int vida;

        private int numeroR;

        private int recurso;

        private int capacidad;

        private int generar;

        public MinaBuilder(String tipo, int vida, int FaseHabilitada, int numeroR) {

            this.FaseHabilitada = FaseHabilitada;
            this.tipo = tipo;
            this.vida = vida;
            this.habilitada = false;
            this.numeroR = numeroR;

        }

        public MinaBuilder capacidad(int capacidad) {
            this.capacidad = capacidad;
            return this;
        }

        public MinaBuilder generar(int generar) {
            this.generar = generar;
            return this;
        }

        public Mina build() {
            return new Mina(this);
        }
    }

}
