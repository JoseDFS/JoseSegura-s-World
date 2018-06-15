/*
 Esta clase es el director del builder de los objetos tipo mina y es la que retornara y le dara la instancia de dicho objeto a la factory.
 */
package Mina.Builder;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class DirectorMina {
    public Mina getMina(String t, int v, int f,int c,int g,int n) {
        return new
            Mina.MinaBuilder(t,v,f,n).capacidad(c).generar(g).build();
    }
    
     public Mina getMinaG(String t, int v, int f,int g,int n) {
        return new
            Mina.MinaBuilder(t,v,f,n).generar(g).build();
    }
}
