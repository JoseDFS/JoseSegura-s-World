/*
Este es el objeto abstracto y la interfaz que van a utilizar los objetos de la clase fuerza y que estara administrado por la factory
 */
package Fuerza.Factory;

import Fuerza.Unidad.Unidad;
import World.Players.Jugador;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public interface FuerzaG {

    void Habilitar();

    boolean getHabilitada();

    int getFaseHabilitada();

    void HabilitarU(int fase);

    void Entrenar(int Fase, Jugador j);

    void mostrarUnidades();

    public Unidad ElegirUnidad();

    public void setAtacadaPor(Unidad unidad);

    public Unidad GetAtacadaPor();

    public int getVida();

    public void setVida(int vida);

    public int getCosto1();

    public int getCosto2();

    public int getCosto3();

}
