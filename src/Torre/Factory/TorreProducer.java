/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Torre.Factory;

import Fuerza.Factory.FuerzaFactory;

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
                return null;
        }
        return null;
    }
}
