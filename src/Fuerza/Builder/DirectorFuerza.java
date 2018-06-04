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
public class DirectorFuerza {
    private FuerzaBuilder fuerzaBuilder;
 
    public void setFuerzaBuilder(FuerzaBuilder fuerza) { 
        fuerzaBuilder = fuerza; 
    }
    
    public Fuerza getPizza() { 
        return fuerzaBuilder.getFuerza(); 
    }
 
    public void construirPizza() {
       fuerzaBuilder.crearNuevaFuerza();
       fuerzaBuilder.buildTipo();
       fuerzaBuilder.buildVida();
       fuerzaBuilder.buildFaseHabilitada();
    }
}
