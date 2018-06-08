/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public Raza(String nombre, String descripcion, int faseTorres, int faseSoldado, int faseV1, int faseV2) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.faseTorres = faseTorres;
        this.faseSoldado = faseSoldado;
        this.faseV1 = faseV1;
        this.faseV2 = faseV2;
    }
    
    
    
}
