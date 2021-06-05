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
    /// DISTRIBUCION CONTINUA
    public static double distribucionContinua(float valor_1, float valor_2){
        double aleatorio = ControladorSemilla.metodoCuadrado(2);
        return valor_1+((valor_2-valor_1)*aleatorio);
    }
    /// DISTRIBUCION EXPONENCIAL
     public static double distribucionExponencial(float valor_medio,float horas){
        double aleatorio = ControladorSemilla.metodoCuadrado(2);
        double valor_result=(valor_medio/horas);
        return (-valor_result*Math.log10(aleatorio));
    }
    // DISTRIBUCION NORMAL
    public static double distribucionNormal(float valor_medio,float valor_desviacion){
        float suma = 0;
        for(int i =0; i<12;i++){
            double aleatorio = ControladorSemilla.metodoCuadrado(2);
            System.out.println("semilla: "+aleatorio);
            suma+=aleatorio;
            System.out.println("suma"+suma);
        }
        return (valor_desviacion*(suma-6)+valor_medio);
    }
}
