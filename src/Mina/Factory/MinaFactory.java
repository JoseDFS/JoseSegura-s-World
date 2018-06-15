/*
Esta clase es la factoria concreta que se encarga de llamar al builder para obtener un objeto de tipo mina, esta preparada para enviar los parametros segun la raza que tiene el objeto jugador.
 */
package Mina.Factory;

import Fuerza.Factory.FuerzaG;
import Mina.Builder.DirectorMina;
import Torre.Factory.TorreFactory;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class MinaFactory implements TorreFactory {

    DirectorMina builder = new DirectorMina();
    private String[] minas1 = {"Lithium", "Mana", "Spiritus"};
    private String[] minas2 = {"Obsidiana", "Hierro", "Armonium"};
    private String[] minas3 = {"Beltium", "Cranium", "Solium"};

    @Override
    public MinaG getMinaG(String type, int fase, int numeroRaza) {
        switch (numeroRaza) {
            case 1:
                if (type.equals(minas1[0])) {
                    return builder.getMina(type, 60, fase, 3000,1000,1);
                }
                if (type.equals(minas1[1])) {
                    return builder.getMina(type, 60, fase, 3000,1000,2);
                }
                if (type.equals(minas1[2])) {
                    return builder.getMinaG(type, 60, fase,500,3);
                }
            case 2:
                if (type.equals(minas2[0])) {
                    return builder.getMina(type, 60, fase, 1500,750,1);
                }
                if (type.equals(minas2[1])) {
                    return builder.getMina(type, 60, fase,300,750,2);
                }
                if (type.equals(minas2[2])) {
                    return builder.getMinaG(type, 60, fase, 300,3);
                }
            case 3:
                if (type.equals(minas3[0])) {
                    return builder.getMina(type, 60, fase, 1500,500,1);
                }
                if (type.equals(minas3[1])) {
                    return builder.getMina(type, 60, fase, 1500,500,2);
                }
                if (type.equals(minas3[2])) {
                    return builder.getMinaG(type, 60, fase, 100,3);
                }
        }
        return null;
    }

    @Override
    public FuerzaG getFuerzaG(String type, int fase, int numeroRaza
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
