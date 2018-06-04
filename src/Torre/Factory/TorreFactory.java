/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Torre.Factory;

import Fuerza.Factory.Fuerza;
import Mina.Factory.Mina;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public interface TorreFactory {

    Mina getMina(String type);

    Fuerza getFuerza(String type);
}
