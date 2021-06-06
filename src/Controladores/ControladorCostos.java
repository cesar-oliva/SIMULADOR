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
    //VARIABLES GLOBALES
    private static double costo_Chip;
    private static double costo_Pellet;
    private static double costo_Briqueta;
    private static double costo_Leña;
    private static double costo_Transporte;
    private static double dist_Promedio = 40.25;
    private static float costo_Km = 25.56f;
    private static float desv_Km = 3f;

    
    //METODO PARA CALCLAR EL COSTO DEL RECURSO + TRANSPORTE
    public static void calcularCosto(){
        int tipo_Comb=1;
        costo_Transporte = (Controladores.ControladorProbabilidad.distribucionNormal(costo_Km,desv_Km)*dist_Promedio)/1000; 
        while(tipo_Comb<=4){
           switch(tipo_Comb){
                case 1 : 
                    costo_Chip = Controladores.ControladorProbabilidad.distribucionNormal(771.01f,105.74f);
                    costo_Chip+=costo_Transporte*Controladores.ControladorEnergetico.getCant_Chip();
                break; 
                case 2 :
                    costo_Pellet = Controladores.ControladorProbabilidad.distribucionNormal(948f,150f);
                    costo_Pellet+=costo_Transporte*Controladores.ControladorEnergetico.getCant_Pellet();
                break; 
                case 3 :
                    costo_Briqueta = Controladores.ControladorProbabilidad.distribucionNormal(1125f,95.50f);
                    costo_Briqueta+=costo_Transporte*Controladores.ControladorEnergetico.getCant_Briqueta();
                break; 
                case 4 :
                    costo_Leña = Controladores.ControladorProbabilidad.distribucionNormal(797.94f, 178.27f);
                    costo_Leña+=costo_Transporte*Controladores.ControladorEnergetico.getCant_Leña();
                break; 
                default : 
                   // Declaraciones
            }
        tipo_Comb++;
       }      
    }
    
}
