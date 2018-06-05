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

    @Override
    public Mina getMina(String type) {
      return null;
    }

    @Override
    public FuerzaG getFuerzaG(String type,int fase) {
        switch (type) {
            case "Arqueros":
                return builder.getFuerza(type, 75, fase);
            case "Fenix":
                return builder.getFuerza(type, 75, fase);
            case "Quimera":
                return builder.getFuerza(type, 75, fase);
        }
        return null;
    }
  

    
   }
