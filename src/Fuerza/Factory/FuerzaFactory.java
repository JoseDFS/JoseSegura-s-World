/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuerza.Factory;

import Torre.Factory.TorreFactory;
import Fuerza.Builder.DirectorFuerza;
import Mina.Factory.MinaG;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class FuerzaFactory implements TorreFactory {

    DirectorFuerza builder = new DirectorFuerza();
    private String[] torres1 = {"Arqueros", "Quimera", "Fenix"};
    private String[] torres2 = {"Guerreros", "Tanque", "Dirigible"};
    private String[] torres3 = {"Scouts", "LossenTank", "WingForm"};
    

    public FuerzaFactory() {

    }


    @Override
    public FuerzaG getFuerzaG(String type, int fase, int numeroRaza) {
        switch (numeroRaza) {
            case 1:
                if (type.equals(torres1[0])) {
                    return builder.getFuerza(type, 65, fase,30,15,2,3,1);
                }
                if (type.equals(torres1[1])) {
                    return builder.getFuerza(type, 75, fase,40,25,2,2,2);
                }
                if (type.equals(torres1[2])) {
                    return builder.getFuerza(type, 80, fase,50,35,2,1,3);
                }
            case 2:
                if (type.equals(torres2[0])) {
                    return builder.getFuerza(type, 70, fase,25,30,1,2,1);
                }
                if (type.equals(torres2[1])) {
                    return builder.getFuerza(type, 80, fase,35,30,2,3,2);
                }
                if (type.equals(torres2[2])) {
                    return builder.getFuerza(type, 90, fase,40,30,2,3,3);
                }
            case 3:
                if (type.equals(torres3[0])) {
                    return builder.getFuerza(type, 70, fase,25,30,1,2,1);
                }
                if (type.equals(torres3[1])) {
                    return builder.getFuerza(type, 80, fase,35,30,2,2,2);
                }
                if (type.equals(torres3[2])) {
                    return builder.getFuerza(type, 90, fase,40,30,2,2,3);
                }
        }
        return null;
    }

    @Override
    public MinaG getMinaG(String type, int fase, int numeroRaza) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
