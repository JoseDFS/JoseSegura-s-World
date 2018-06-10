/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuerza.Factory;

import Fuerza.Unidad.Unidad;
import java.util.ArrayList;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public interface FuerzaG {

    void Habilitar();

    int getFaseHabilitada();

    void HabilitarU(int fase);

    void Entrenar(int Fase);

    

}
