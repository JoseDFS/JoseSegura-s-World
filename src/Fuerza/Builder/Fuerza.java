/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuerza.Builder;

import Fuerza.Factory.FuerzaG;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Fuerza implements FuerzaG{

    private final String tipo;
    private final int FaseHabilitada;
    
    private boolean habilitada;
    private  int vida;

    private Fuerza(FuerzaBuilder builder) {
        this.FaseHabilitada = builder.FaseHabilitada;
        this.vida = builder.vida;
        this.tipo = builder.tipo;
        this.habilitada = builder.habilitada;
    }

    public boolean isHabilitada() {
        
        return habilitada;
    }

    
    public String getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }

    public int getFaseHabilitada() {
        return FaseHabilitada;
    }

    @Override
    public void Habilitar() {
        System.out.println("Se habilito" + " " + this.tipo);
        this.habilitada = true;
    }

    public static class FuerzaBuilder {

        private final String tipo;
        private final int FaseHabilitada;
        
        private boolean habilitada;
        private  int vida;
        
        public FuerzaBuilder(String tipo, int vida, int FaseHabilitada){
            
            this.FaseHabilitada = FaseHabilitada;
            this.tipo = tipo;
            this.vida = vida;
            this.habilitada = false;
        }
        
        public Fuerza build(){
            return new Fuerza(this);
        }
    }

}
