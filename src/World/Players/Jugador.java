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
    private int r1;
    private int r2;
    private int r3;
    private String nick;
    private Raza raza;
    private int faseTorres;
    private int faseSoldados;
    private int faseV1;
    private int faseV2;

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    private ListaFuerza Fuerzas ;

    public Jugador( String nick, Raza raza) {
        this.nick = nick;
        this.raza = raza;
        this.faseTorres = raza.getFaseTorres();
        this.faseSoldados = raza.getFaseSoldado();
        this.faseV1 = raza.getFaseV1();
        this.faseV2 = raza.getFaseV2();
        this.Fuerzas = new ListaFuerza(this.faseTorres);
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
        return "vida=" + vida + "\n" + "r1=" + r1 + ", r2=" + r2 + ", r3=" + r3;
    }

}
