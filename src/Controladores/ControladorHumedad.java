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
    //VARIABLES PROPIAS DEL PROCESO
    private static double humedad_Hoja;
    private static double agua_Hoja;
        
     ///METODO PARA CALCLAR LA HUMEDAD DE LA HOJA ANTES DEL SECADO (ENTRE 60% Y 70%)
    public static double iniciarSapecado(double carga_Hoja){
        humedad_Hoja = Controladores.ControladorProbabilidad.distribucionContinua(40, 60);
        agua_Hoja = carga_Hoja*(humedad_Hoja/100);
        carga_Hoja-=agua_Hoja; 
        return carga_Hoja;
    }  
        //METODO PARA CALCLAR LA HUMEDAD DE LA HOJA POST SAPECADO (ENTRE 30% Y 34%)
    public static double humedadHoja(double carga_Hoja){
        humedad_Hoja = Controladores.ControladorProbabilidad.distribucionContinua(30, 34);
        agua_Hoja = carga_Hoja*(humedad_Hoja/100);
        carga_Hoja-=agua_Hoja;  
        return carga_Hoja;
    }
      ///METODO PARA CALCLAR LA HUMEDAD DE LA HOJA CUANDO SALE DEL SECADO (ENTRE 3% Y 4%)
    public static double estandarHoja(){
        humedad_Hoja = Controladores.ControladorProbabilidad.distribucionContinua(3, 4); 
        return humedad_Hoja;
    }  
    
    
}
