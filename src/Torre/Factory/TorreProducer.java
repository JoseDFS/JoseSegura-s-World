/*
Esta es la clase que se encarga de crear las factorias concretas ya sean de tipo minaG o fuerzaG.
 */
package Torre.Factory;

import Fuerza.Factory.FuerzaFactory;
import Mina.Factory.MinaFactory;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class TorreProducer {
    public static TorreFactory getFactory(String type){
        switch (type){
            case "Fuerza":
                return  new FuerzaFactory();
            case "Mina":
                return new MinaFactory();
        }
        return null;
    }
}
