/*
Esta es la facroria abstracta que se encarga de obtener un objeto ya sea de tipo minaG o fuerzaG segun los parametros dados.
 */
package Torre.Factory;

import Fuerza.Factory.FuerzaG;
import Mina.Factory.MinaG;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public interface TorreFactory {

    MinaG getMinaG(String type,int fase, int numeroRaza);

    FuerzaG getFuerzaG(String type,int fase,int numeroRaza);
}
