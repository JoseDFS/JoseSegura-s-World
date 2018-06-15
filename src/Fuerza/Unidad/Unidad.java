/*
Esta clase representa los objetos que almacenaran las torres, que estaran encargados de atacar y defender otros objetos del programa.
 */
package Fuerza.Unidad;

import Fuerza.Factory.FuerzaG;
import Mina.Factory.MinaG;
import World.Players.Jugador;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Unidad {

    private String nombre;
    private String estado;
    private int vida;
    private int ataque;
    private int faseHabilitada;
    private int trayecto;
    private int faseAtaque = 0;
    private boolean habilitada = false;
    private FuerzaG atacandoT = null;
    private Unidad atacandoU = null;
    private MinaG atacandoM = null;
    private Jugador atacandoJ = null;

    public Unidad(String nombre, String estado, int vida, int ataque, int fase, int trayecto) {
        this.nombre = nombre;
        this.estado = estado;
        this.vida = vida;
        this.ataque = ataque;
        this.faseHabilitada = fase;
        this.trayecto = trayecto;

    }

    public String isHabilitada() {
        if (this.habilitada) {
            return "Esperando ordenes";
        } else {
            return "Entrenando";
        }
    }

    public int getFaseHabilitada() {
        return faseHabilitada;
    }

    public void Habilitar() {
        this.habilitada = true;
    }

    @Override
    public String toString() {
        if (this.estado == "Atacando" || this.estado == "Defendiendo") {
            return nombre + "     " + vida + "        " + ataque + "       " + this.estado;
        } else {
            return nombre + "     " + vida + "        " + ataque + "       " + this.isHabilitada();
        }

    }

    public Jugador getAtacandoJ() {
        return atacandoJ;
    }

    public int getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(int trayecto) {
        this.trayecto = trayecto;
    }

    public int getFaseAtaque() {
        return faseAtaque;
    }

    public void setFaseAtaque(int faseAtaque) {
        this.faseAtaque = faseAtaque;
    }

    public FuerzaG getAtacandoT() {
        return atacandoT;
    }

    public void setAtacandoT(FuerzaG atacando) {
        this.atacandoT = atacando;
    }

    public Unidad getAtacandoU() {
        return atacandoU;
    }

    public void setAtacandoU(Unidad atacandoU) {
        this.atacandoU = atacandoU;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public MinaG getAtacandoM() {
        return atacandoM;
    }

    public void setAtacandoM(MinaG atacandoM) {
        this.atacandoM = atacandoM;
    }

    public void MAtacar(FuerzaG temp, int fase) {
        this.atacandoT = temp;
        this.faseAtaque = fase + this.trayecto;

    }

    public void MAtacarJ(Jugador temp, int fase) {
        this.atacandoJ = temp;
        this.faseAtaque = fase + this.trayecto;

    }

    public void MAtacarM(MinaG temp, int fase) {
        this.atacandoM = temp;
        this.faseAtaque = fase + this.trayecto;

    }

    public void AtacarT() {
        int vida = this.atacandoT.getVida();
        this.atacandoT.setVida(vida - this.ataque);
    }

    public void AtacarJ() {
        int vida = this.atacandoJ.getVida();
        this.atacandoJ.setVida(vida - this.ataque);
    }

    public void AtacarM() {
        int vida = this.atacandoM.getVida();
        this.atacandoT.setVida(vida - this.ataque);
    }

    public void MDefender(Unidad unidad2) {
        this.atacandoU = unidad2;
        this.estado = "Defendiendo";

    }

    public void AtacarU() {
        int vida = this.atacandoU.getVida();
        this.atacandoU.setVida(vida - this.ataque);
    }

}
