/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

/**
 *
 * @author Cesar
 */
public class ControladorEnergetico {  
    //METODO PARA LLEVAR A LA TEMPERATURA DESEADA A LA MAQUINA DE SECADO (90-120)
    public static double setupSecado(float temp_Secado,float temp_Actual){
       Controladores.ControladorCalor.calcularCalorRequerido(30, 4, 7, temp_Secado,temp_Actual);
       int tipo_Comb=1; 
       while(tipo_Comb<=4){
       }
       
       
       
        return temp_Secado;
    }
}
