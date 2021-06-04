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
public class ControladorHumedad {
      //METODO PARA CALCLAR LA HUMEDAD DE LA HOJA POST SAPECADO (ENTRE 30% Y 34%)
    public static double humedadHoja(double carga_Hoja){
        double semilla = Controladores.ControladorSemilla.metodoCuadrado(2);
        double humedad_Hoja = 30+(4*semilla);
        double agua_Hoja = carga_Hoja*(humedad_Hoja/100);
        carga_Hoja+=agua_Hoja;       
        return carga_Hoja;
    }
     ///METODO PARA CALCLAR LA HUMEDAD DE LA HOJA ANTES DEL SECADO (ENTRE 30% Y 34%)
    public static double iniciarSapecado(double digitos, double carga_Hoja){
        double semilla = Controladores.ControladorSemilla.metodoCuadrado(2);
        double humedad_Hoja = 60+(10*semilla);
        double agua_Hoja = carga_Hoja*(humedad_Hoja/100);
        carga_Hoja+=agua_Hoja;       
        return carga_Hoja;
    }  
      ///METODO PARA CALCLAR LA HUMEDAD DE LA HOJA CUANDO SALE DEL SECADO (ENTRE 3% Y 4%)
    public static double estandarHoja(){
        double semilla = Controladores.ControladorSemilla.metodoCuadrado(2);
        double humedad_Hoja = 3+(1*semilla);   
        return humedad_Hoja;
    }  
    
    
}
