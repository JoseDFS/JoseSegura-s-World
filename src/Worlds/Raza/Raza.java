/*
Esta clase es la que representa el objeto raza que es la que servira para setear los parametros requeridos por el objeto jugador segun los atributos que esta clase tenga.
 */
package Worlds.Raza;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Raza {

    private String nombre;
    private String descripcion;
    private final int faseTorres;
    private final int faseSoldado;
    private final int faseV1;
    private final int faseV2;
    private final int numeroRaza;
    private final int faseMinas;

    public int getFaseMinas() {
        return faseMinas;
    }
    
    

    public String getDescripcion() {
        return descripcion;
    }

    public int getFaseTorres() {
        return faseTorres;
    }

    public int getFaseSoldado() {
        return faseSoldado;
    }

    public int getFaseV1() {
        return faseV1;
    }

    public int getFaseV2() {
        return faseV2;
    }

    public int getNumeroRaza() {
        return numeroRaza;
    }

    public Raza(String nombre, String descripcion, int faseTorres, int faseSoldado, int faseV1, int faseV2, int numeroRaza,int faseMinas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.faseTorres = faseTorres;
        this.faseSoldado = faseSoldado;
        this.faseV1 = faseV1;
        this.faseV2 = faseV2;
        this.numeroRaza = numeroRaza;
        this.faseMinas = faseMinas;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return numeroRaza + "." + nombre + "   " + descripcion;
    }

}
