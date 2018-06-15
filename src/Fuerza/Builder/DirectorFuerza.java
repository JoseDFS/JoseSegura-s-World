/*
 Esta clase es la que instancia el objeto fuerza, retornara y le dara dicha instancia a la factory
 */
package Fuerza.Builder;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class DirectorFuerza {

    public Fuerza getFuerza(String t, int v, int f,int vU,int aU,int fU,int tU,int nF) {
        return new
            Fuerza.FuerzaBuilder(t,v,f,vU,aU,fU,tU,nF).build();
    }

}
