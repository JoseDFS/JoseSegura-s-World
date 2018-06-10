/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuerza.Factory;

import Mina.Factory.Mina;
import Torre.Factory.TorreFactory;
import Fuerza.Builder.DirectorFuerza;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class FuerzaFactory implements TorreFactory {

    DirectorFuerza builder = new DirectorFuerza();
    private String[] torres1 = {"Arqueros", "Quimera", "Fenix"};
    private String[] torres2 = {"Guerreros", "Tanque", "Dirigible"};
    private String[] torres3 = {"Scouts", "LossenTank", "WingForm"};
    private int vidaTorre;

    public FuerzaFactory() {

    }

    /*if (numeroRaza == 1) {
            torres[0] = "Arqueros";
            torres[1] = "Quimeras";
            torres[2] = "Fenix";
        }
        if (numeroRaza == 2) {
            torres[0] = "Guerreros";
            torres[1] = "Tanques";
            torres[2] = "Dirigibles";
        }
        if (numeroRaza == 3) {
            torres[0] = "Scouts";
            torres[1] = "LossenTanks";
            torres[2] = "WingForms";
        }*/
    @Override
    public Mina getMina(String type) {
        return null;
    }

    @Override
    public FuerzaG getFuerzaG(String type, int fase, int numeroRaza) {
        switch (numeroRaza) {
            case 1:
                if (type.equals(torres1[0])) {
                    return builder.getFuerza(type, 65, fase,30,15,2);
                }
                if (type.equals(torres1[1])) {
                    return builder.getFuerza(type, 75, fase,40,25,2);
                }
                if (type.equals(torres1[2])) {
                    return builder.getFuerza(type, 80, fase,50,35,2);
                }
            case 2:
                if (type.equals(torres2[0])) {
                    return builder.getFuerza(type, 70, fase,25,30,1);
                }
                if (type.equals(torres2[1])) {
                    return builder.getFuerza(type, 80, fase,35,30,2);
                }
                if (type.equals(torres2[2])) {
                    return builder.getFuerza(type, 90, fase,40,30,2);
                }
            case 3:
                if (type.equals(torres3[0])) {
                    return builder.getFuerza(type, 70, fase,25,30,1);
                }
                if (type.equals(torres3[1])) {
                    return builder.getFuerza(type, 80, fase,35,30,2);
                }
                if (type.equals(torres3[2])) {
                    return builder.getFuerza(type, 90, fase,40,30,2);
                }
        }
        return null;
    }

}
