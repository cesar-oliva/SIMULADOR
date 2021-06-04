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
public class ControladorProceso {
    
    //ESTADOS EN LOS QUE SE PUEDE ENCONTRAR EL PROCESO
    public enum proceso{ACTIVADO,DESACTIVADO}
        
    //METODO PARA ESTABLECER LA CARGA DE HOJAS AL SECADOR (3000 A 3500)
    public static double establecerCarga(double cant_Hoja){
        double semilla = Controladores.ControladorSemilla.metodoCuadrado(2);
        double carga_Hoja = 3000+(500*semilla);
        if(cant_Hoja<=carga_Hoja){
            carga_Hoja=cant_Hoja;
        }
        return carga_Hoja;
    }
    
    //METODO PARA EL TIEMPO DE TRABAJO DE LA MAQUINA DE SECADO (8,12,16)
    public static double tiempoProceso(){
        float semilla = (float)Controladores.ControladorSemilla.metodoCuadrado(2);
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
