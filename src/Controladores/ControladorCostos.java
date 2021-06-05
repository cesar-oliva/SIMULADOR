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
public class ControladorCostos {
    
    //METODO PARA CALCLAR EL COSTO DEL RECURSO
    public static double calcularCosto(float valor_1,float valor_2){
        double costo_Recurso= Controladores.ControladorProbabilidad.distribucionNormal(valor_1, valor_2);
        return costo_Recurso;
    }    
}
