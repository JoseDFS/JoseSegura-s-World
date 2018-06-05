/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Torre.Factory;

import Mina.Factory.Mina;
import Fuerza.Factory.FuerzaG;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public interface TorreFactory {

    Mina getMina(String type);

    FuerzaG getFuerzaG(String type,int fase);
}
