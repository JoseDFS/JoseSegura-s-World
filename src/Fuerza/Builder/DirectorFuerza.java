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

    public Fuerza getFuerza(String t, int v, int f,int vU,int aU,int fU) {
        return new
            Fuerza.FuerzaBuilder(t,v,f,vU,aU,fU).build();
    }

}
