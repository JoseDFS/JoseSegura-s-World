/*
Esta es la interfaz del que los objetos tipo mina heredaran los metodos.
 */
package Mina.Factory;

import Fuerza.Unidad.Unidad;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public interface MinaG {

    void Habilitar();

    boolean getHabilitada();

    int getFaseHabilitada();

    public void setAtacadaPor(Unidad unidad);

    public Unidad GetAtacadaPor();
    
    public int getVida();

    public void setVida(int vida);
    
    public int getRecurso();
    
    public int getCapacidad();
    
    public void setRecurso(int r);

    public int getGenerar();
    
    public int getNumeroR();

}
