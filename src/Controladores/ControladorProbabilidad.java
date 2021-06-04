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
public class ControladorProbabilidad {
    public static double distribucionContinua(float valor_1, float valor_2){
        double aleatorio = ControladorSemilla.metodoCuadrado(2);
        return valor_1+((valor_2-valor_1)*aleatorio);
    }
     public static double distribucionExponencial(float valor_medio,float horas){
        double aleatorio = ControladorSemilla.metodoCuadrado(2);
        double valor_result=(valor_medio/horas);
        return (-valor_result*Math.log10(aleatorio));
    }
}
