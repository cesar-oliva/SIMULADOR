package Controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cesar
 */
public class ControladorCalor {
       //METODO PARA CALCULAR EL CALOR REQUERIDO PARA CALENTAR EL ESTABLECIMIENTO DE SECADO
    public static double calcularCalorRequerido(float largo_Secador, float ancho_Secador, float alto_Secador,float temp_Secado, float temp_Actual){
        final int densidad_Aire = 1118;
        final int calor_Aire = 240;
        float volumen_Secador = ancho_Secador*alto_Secador*largo_Secador;   
        float masa_Aire = volumen_Secador*densidad_Aire;
        double calor_requerido = (masa_Aire*calor_Aire*(temp_Secado-temp_Actual))/1000;
        return calor_requerido;
    }
    //METODO PARA CALCULAR LAS KILOCALORIAS QUE APORTA LA LEÑA
    public static double calcularCalorLeña(){
       double semilla = Controladores.ControladorSemilla.metodoCuadrado(2);
       double kcal_Leña = 4548+(130*semilla);
       return kcal_Leña;
    }
    //METODO PARA CALCULAR LA PERDIDA DE TEMPERATURA DEL SECADOR
    public static double perdidaTemperatura(){
       double semilla = Controladores.ControladorSemilla.metodoCuadrado(2);
       double perdida_Temp = -20*Math.log10(semilla);
       return perdida_Temp;
    }
        //METODO PARA CALCULAR LOS PARAMETROS DE TEMPERATURA INICIALES DE LA MAQUINA DE SECADO (90-120)
    public static double tiempoProceso(){
        float semilla = (float)Controladores.ControladorSemilla.metodoCuadrado(2);
        System.out.println(semilla);
        int tiempo =0;
        if(semilla<=0.50f){
            tiempo=8;
        }else{
            if(semilla<=0.90f){
            tiempo=12;
            }else{
               tiempo=16;   
            }   
        }
        return tiempo;
    }
}
