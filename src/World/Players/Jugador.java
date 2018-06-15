/*
Esta clase es la que representa al objeto jugador y que en el porgrama tambien sera el centro de mando. A este objeto le pertenecen como atributos la lista de objetos de tipo MinaG y FuerzaG.
Segun la raza que se haya elegido se van a setear datos y parametros que usaran las listas y los objetos y factorias que contienen esas listas para poder instanciar el objeto que se quiere.
 */
package World.Players;

import Fuerza.Unidad.Unidad;
import Lista.Jugador.ListaFuerza;
import Lista.Jugador.ListaMina;
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

    private int capacidad1;
    private int capacidad2;
    private int capacidad3;

    private String[] minas1 = {"Lithium", "Mana", "Spiritus"};
    private String[] minas2 = {"Obsidiana", "Hierro", "Armonium"};
    private String[] minas3 = {"Beltium", "Cranium", "Solium"};

    private String mina1;
    private String mina2;
    private String mina3;

    private int g1;
    private int g2;
    
    private int mejora;
    
    private Unidad atacadaPor;

    public ListaFuerza Fuerzas = new ListaFuerza();

    public ListaMina Minas = new ListaMina();

    public String getMina1() {
        return mina1;
    }

    public String getMina2() {
        return mina2;
    }

    public String getMina3() {
        return mina3;
    }
    
    

    public Raza getRaza() {
        return raza;
    }

    public int getNumeroRaza() {
        return this.raza.getNumeroRaza();
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Jugador(String nick, Raza raza) {
        this.nick = nick;
        this.raza = raza;
        this.faseTorres = raza.getFaseTorres();
        this.faseSoldados = raza.getFaseSoldado();
        this.faseV1 = raza.getFaseV1();
        this.faseV2 = raza.getFaseV2();
        
        this.mejora = 1;

        this.capacidad1 = 10000;
        this.capacidad2 = 5000;
        this.capacidad3 = 3000;

        if (raza.getNumeroRaza() == 1) {
            this.mina1 = minas1[0];
            this.mina2 = minas1[1];
            this.mina3 = minas1[2];

        }
        if (raza.getNumeroRaza() == 2) {
            this.mina1 = minas2[0];
            this.mina2 = minas2[1];
            this.mina3 = minas2[2];

        }
        if (raza.getNumeroRaza() == 3) {
            this.mina1 = minas3[0];
            this.mina2 = minas3[1];
            this.mina3 = minas3[2];
        }

        this.r1 = 1000;
        this.r2 = 750;
        this.r3 = 100;

    }

    public ListaFuerza getFuerzas() {
        return Fuerzas;
    }
    
    public ListaMina getMinas() {
        return Minas;
    }

    public int getMejora() {
        return mejora;
    }

    public void setMejora(int mejora) {
        this.mejora = mejora;
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

    public int getCapacidad1() {
        return capacidad1;
    }

    public void setCapacidad1(int capacidad1) {
        this.capacidad1 = capacidad1;
    }

    public int getCapacidad2() {
        return capacidad2;
    }

    public void setCapacidad2(int capacidad2) {
        this.capacidad2 = capacidad2;
    }

    public int getCapacidad3() {
        return capacidad3;
    }

    public void setCapacidad3(int capacidad3) {
        this.capacidad3 = capacidad3;
    }

    public int getR1() {
        return r1;
    }

    public void setR1(int r1) {
        this.r1 = r1;
    }

    public int getR2() {
        return r2;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }

    public int getR3() {
        return r3;
    }

    public void setR3(int r3) {
        this.r3 = r3;
    }

    public Unidad getAtacadaPor() {
        return atacadaPor;
    }

    public void setAtacadaPor(Unidad atacadaPor) {
        this.atacadaPor = atacadaPor;
    }
    
    

    @Override
    public String toString() {
        return raza.getNombre() + "\n" + "vida=" + vida + "\n" + mina1 + ":" + r1 + "," + mina2 + ":" + r2 + ", " + mina3 + ":" + r3;
    }

}
