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
public abstract class FuerzaBuilder {

    private Fuerza fuerza;

    public Fuerza getFuerza() {
        return this.fuerza;
    }

    void crearNuevaFuerza() {
        fuerza = new Fuerza();
    }

    public abstract void buildTipo();
    public abstract void buildVida();
    public abstract void buildFaseHabilitada();

}
