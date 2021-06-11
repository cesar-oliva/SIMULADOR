/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Cesar
 */
public class ControladorMensajes {
    private static int i = 0;
    
    public static void msjTemperaturaSecado(double temp_Secado){
        //tmr.start();
        inicioProceso();
        Controladores.ControladorEjecucion.getVp().getjTextArea1().append("Calculando temperatura de secado...\n");
        Controladores.ControladorEjecucion.getVp().getjTextArea1().append(String.format("Temperatura Secado: %.3f [ºC]\n", temp_Secado));

    }
    public static void msjTemperaturaActual(double temp_Actual){
        Controladores.ControladorEjecucion.getVp().getjTextArea1().append("Temperatura Actual: "+temp_Actual+"\n");
    }
    public static void msjTemperaturaPerdida(double perdida_Temp){
        Controladores.ControladorEjecucion.getVp().getjTextArea1().append("Calculando perdida de temperatura en secado...\n");
        Controladores.ControladorEjecucion.getVp().getjTextArea1().append("Perdida de Temperatura: "+perdida_Temp+"\n");

    }
    public static void msjCalorRequerido(double calor_Requerido){
        Controladores.ControladorEjecucion.getVp().getjTextArea1().append("Calculando calor Requerido...\n");

        Controladores.ControladorEjecucion.getVp().getjTextArea1().append("Calor Requerido: "+calor_Requerido+"\n");
    } 

    
             //Método que llamaremos desde nuestro botón
        private static void inicioProceso(){
        //Creamos un Thread para mejorar el ejemplo
        final Thread t;
        //Inicializamos
        t = new Thread(new Runnable() {
            //Implementamos el método run()
            
            @Override
            public void run() {
                //Permite mostrar el valor del progreso
                Controladores.ControladorEjecucion.getVp().getjProgressBar1().setVisible(true);
                Controladores.ControladorEjecucion.getVp().getjProgressBar1().setStringPainted(true);
                int x = 0;
                //t a=buscarmayor();
                //Utilizamos un while para emular el valor mínimo y máximo
                //En este caso 0 - 100
                while(x <=100){
                    //Asignamos valor a nuestro JProgressBar por cada siclo del bucle
                    Controladores.ControladorEjecucion.getVp().getjProgressBar1().setValue(x);
                    //Valor que se mostrará en el JTextArea
                    if(x==0)
                    Controladores.ControladorEjecucion.getVp().getjTextArea1().append("Progresando solicitud...\n");
                    if(x==10)
                    Controladores.ControladorEjecucion.getVp().getjTextArea1().append("Nivel de gravedad\n");
                    if(x==20)
                    Controladores.ControladorEjecucion.getVp().getjTextArea1().append("Verificando disponibilidad de recurso...\n");
                    if(x==40)
                    Controladores.ControladorEjecucion.getVp().getjTextArea1().append("Recurso encontrado...\n");
                    if(x==90)
                    Controladores.ControladorEjecucion.getVp().getjTextArea1().append("Mostrando resultado...\n");
                    //Hacemos una parada de medio segundo por cada siclo while
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }
                    //Se incrementa el valor de x
                    x++;
                }
            }
      
        });
        //Se ejecuta el Thread
        t.start();
  }        
    
}
