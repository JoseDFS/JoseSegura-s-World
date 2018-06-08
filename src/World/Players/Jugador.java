/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Players;

import Lista.Jugador.ListaFuerza;
import Worlds.Raza.Raza;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Jugador {
    private int vida = 100;
    private int r1=0;
    private int r2=0;
    private int r3=0;
    private String nick;
    private Raza raza;

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }
    
    private ListaFuerza Fuerzas= new ListaFuerza();

    public Jugador() {
   
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return  "vida=" + vida + "\n" + "r1=" + r1 + ", r2=" + r2 + ", r3=" + r3;
    }
    
    
    
}
