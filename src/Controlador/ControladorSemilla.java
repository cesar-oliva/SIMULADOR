/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Cesar
 */
public class ControladorSemilla {
    ///metodo para generar semilla    
    public static double metodoCuadrado(int digitos){
        int semilla = generarSemilla();
        double newSemilla=0;
        float auxiliar=0;
        int valor=semilla*semilla;
        if((contarDigitos(valor)-digitos)%2==0){
            auxiliar = extraerDigitos(valor,digitos);
            newSemilla = auxiliar/(Math.pow(10, digitos));
        }else{
            valor=valor*10;
            auxiliar = extraerDigitos(valor,digitos);
            newSemilla = auxiliar/(Math.pow(10, digitos));
        }
        return newSemilla;
    }
    ///metodo que cuenta el numero de digitos
     public static int contarDigitos(int numero){
        int cantidad = 0;
        int temp = numero;
        while(temp>0){
            temp = temp/10;
            cantidad++;
        }
        return cantidad;      
    }
    ///metodo que extrae digitos
    public static int extraerDigitos(int numero, int cantidad){
       String cadena = String.valueOf(numero);
       char[] cadena_div = cadena.toCharArray();
       String valor ="";
       int i = (cadena.length()-cantidad)/2;        
       while(valor.length()<cantidad){;
           valor+=cadena_div[i];
           i++;
       }
       return Integer.parseInt(valor);
    }
    
    public static int generarSemilla(){
       return (int)(100000 * Math.random());
    }
}
