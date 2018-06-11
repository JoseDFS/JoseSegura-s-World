/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuerza.Unidad;

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
    private boolean habilitada = false;

    public Unidad(String nombre, String estado, int vida, int ataque, int fase) {
        this.nombre = nombre;
        this.estado = estado;
        this.vida = vida;
        this.ataque = ataque;
        this.faseHabilitada = fase;
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

}
