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
    //VARIABLES QUE SE MANEJARAN DESDE EL CONTROLADOR EN FORMA GLOBAL
    private static double carga_Hoja=0;
    private static int tiempo=0;
    private static double hoja_Seca=0;
    private static double estandar_Hoja=0;
    private static double aux_Secado=0;
    
    public static double getCarga_Hoja() {
        return carga_Hoja;
    }

    public static void setCarga_Hoja(double carga_Hoja) {
        ControladorProceso.carga_Hoja = carga_Hoja;
    }

    public static int getTiempo() {
        return tiempo;
    }
            
    //METODO PARA ESTABLECER LA CARGA DE HOJAS AL SECADOR (3000 A 3500)
    public static void establecerCarga(){
        carga_Hoja = 0;
        carga_Hoja=Controladores.ControladorProbabilidad.distribucionContinua(3000, 3500); 
        if(Controladores.ControladorEjecucion.getCant_carga()<=carga_Hoja){
            carga_Hoja=Controladores.ControladorEjecucion.getCant_carga();
            Controladores.ControladorEjecucion.setP(Controladores.ControladorEjecucion.proceso.DESACTIVADO);
        }
    }
    //METODO PARA EL TIEMPO DE TRABAJO DE LA MAQUINA DE SECADO (8,12,16)
    public static void tiempoProceso(){
        float semilla = (float)Controladores.ControladorSemilla.metodoCuadrado(2);
        tiempo =0;
        if(semilla<=0.50f){
            tiempo=8;
        }else{
            if(semilla<=0.90f){
            tiempo=12;
            }else{
               tiempo=16;   
            }   
        }
    }
    //INICIAR PROCESO DE SECADO A LA HOJA
     public static void procesarHoja(){
        int tipo_Comb=1; 
        carga_Hoja=Controladores.ControladorHumedad.iniciarSapecado(carga_Hoja);
        Controladores.ControladorEnergetico.calcularParametros();
        carga_Hoja=Controladores.ControladorHumedad.humedadHoja(carga_Hoja);
        Controladores.ControladorEjecucion.setCant_carga(Controladores.ControladorEjecucion.getCant_carga()-carga_Hoja);
        aux_Secado+=carga_Hoja;
        estandar_Hoja = Controladores.ControladorHumedad.estandarHoja();
        hoja_Seca+=(carga_Hoja*(1+(estandar_Hoja/100)));
        Controladores.ControladorEnergetico.perdidaTemperatura();
        Controladores.ControladorEnergetico.setupSecador(30, 7, 4);
    }
        
        
        
        
        
        
    
}
