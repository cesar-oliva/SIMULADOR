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
    
    private static double temp_Secado=0;
    private static double temp_Actual=0;
    private static double perdida_Temp=0;
    private static double cant_Chip;
    private static double cant_Pellet;
    private static double cant_Briqueta;
    private static double cant_Leña;
    final static double kcal_Chip=4557;
    final static double kcal_Pellet=4593;
    final static double kcal_Briqueta=4700;
    private static double aux_tempSecado=0;
    private static int cont_Temp;

    public static double getCant_Chip() {
        return cant_Chip;
    }

    public static double getCant_Pellet() {
        return cant_Pellet;
    }

    public static double getCant_Briqueta() {
        return cant_Briqueta;
    }

    public static double getCant_Leña() {
        return cant_Leña;
    }

    public static double getAux_tempSecado() {
        return aux_tempSecado;
    }

    public static int getCont_Temp() {
        return cont_Temp;
    }
    
    //METODO PARA CALCULAR EL CALOR REQUERIDO PARA CALENTAR EL ESTABLECIMIENTO DE SECADO
    public static double calcularCalorRequerido(float largo_Secador, float ancho_Secador, float alto_Secador){
        //Controladores.ControladorMensajes.msjTemperaturaActual(temp_Actual);
        Controladores.ControladorMensajes.msjTemperaturaSecado(temp_Secado);
        final int densidad_Aire = 1118;
        final int calor_Aire = 240;
        float volumen_Secador = ancho_Secador*alto_Secador*largo_Secador;   
        float masa_Aire = volumen_Secador*densidad_Aire;
        double calor_requerido = (masa_Aire*calor_Aire*(temp_Secado-temp_Actual))/1000;
        return calor_requerido;
    }
    //METODO PARA CALCULAR LAS KILOCALORIAS QUE APORTA LA LEÑA
    public static double calcularCalorLeña(){
       double kcal_Leña = Controladores.ControladorProbabilidad.distribucionContinua(4548, 4678);
       return kcal_Leña;
    }
    //METODO PARA CALCULAR LA PERDIDA DE TEMPERATURA DEL SECADOR
    public static void perdidaTemperatura(){
       double semilla = Controladores.ControladorSemilla.metodoCuadrado(2);
       perdida_Temp = Controladores.ControladorProbabilidad.distribucionExponencial(20,1f);
       temp_Actual-=perdida_Temp;
       //Controladores.ControladorMensajes.msjTemperaturaPerdida(perdida_Temp);
    }
        //METODO PARA CALCULAR LOS PARAMETROS DE TEMPERATURA INICIALES DE LA MAQUINA DE SECADO (90-120)
    public static double calcularParametros(){
        temp_Secado=Controladores.ControladorProbabilidad.distribucionContinua(90, 120);
        if(temp_Secado<temp_Actual){
            temp_Secado=temp_Actual;
        }
        aux_tempSecado+=temp_Secado;
        cont_Temp++;
        return temp_Secado;
    }

    //METODO PARA LLEVAR A LA TEMPERATURA DESEADA A LA MAQUINA DE SECADO (90-120)
    public static void setupSecador(float largo_Secador, float ancho_Secador, float alto_Secador){
       double calor_Requerido=calcularCalorRequerido(largo_Secador,ancho_Secador,alto_Secador);
       //Controladores.ControladorMensajes.msjCalorRequerido(calor_Requerido);
       int tipo_Comb=1; 
       double kcal_Leña = calcularCalorLeña();
       while(tipo_Comb<=4){
           switch(tipo_Comb){
                case 1 : cant_Chip+=(calor_Requerido/kcal_Chip);
                break; 
                case 2 :cant_Pellet+=(calor_Requerido/kcal_Pellet);
                break; 
                case 3 :cant_Briqueta+=(calor_Requerido/kcal_Briqueta);
                break; 
                case 4 :cant_Leña+=(calor_Requerido/kcal_Leña);
                break; 
                default : 
                   // Declaraciones
            }
        tipo_Comb++;
       }
        temp_Actual = temp_Secado;
        perdidaTemperatura();
    }
}
