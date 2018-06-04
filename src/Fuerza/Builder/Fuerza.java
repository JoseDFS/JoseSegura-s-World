/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuerza.Builder;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Fuerza {

    private final String tipo;
    private final int vida;
    private final int FaseHabilitada;

    private Fuerza(FuerzaBuilder builder) {
        this.FaseHabilitada = builder.FaseHabilitada;
        this.vida = builder.vida;
        this.tipo = builder.tipo;
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

    public static class FuerzaBuilder {

        private final String tipo;
        private final int vida;
        private final int FaseHabilitada;
        
        public FuerzaBuilder(String tipo, int vida, int FaseHabilitada){
            
            this.FaseHabilitada = FaseHabilitada;
            this.tipo = tipo;
            this.vida = vida;
        }
        
        public Fuerza build(){
            return new Fuerza(this);
        }
    }

}
