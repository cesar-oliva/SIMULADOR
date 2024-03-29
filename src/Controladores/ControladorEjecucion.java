/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Modelo.DataBase;
import Vista.VentanaInicial;
import javax.swing.table.DefaultTableModel;
import Modelo.Proceso;
import Vista.VentanaProceso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;
/**
 *
 * @author Juampy
 */
public class ControladorEjecucion {
    private static VentanaInicial vi = new VentanaInicial();
    private static VentanaProceso vp = new VentanaProceso();
    static ActionListener al;
    static Timer t; 
    static int valor;
    static int i;
    static proceso p = proceso.ACTIVADO;
    //// VARIABLES GLOBALES DEL CONTROLADOR
    private static double cant_carga;
    public static enum proceso{ACTIVADO,DESACTIVADO}
    /// GETER AND SETTER     
    public static double getCant_carga() {
        return cant_carga;
    }
    public static void setCant_carga(double cant_carga) {
        ControladorEjecucion.cant_carga = cant_carga;
    }
    public static proceso getP() {
        return p;
    }
    public static void setP(proceso p) {
        ControladorEjecucion.p = p;
    }

    public static VentanaInicial getVi() {
        return vi;
    }

    public static void setVi(VentanaInicial vi) {
        ControladorEjecucion.vi = vi;
    }

    public static VentanaProceso getVp() {
        return vp;
    }

    public static void setVp(VentanaProceso vp) {
        ControladorEjecucion.vp = vp;
    }
    
    // INICIO DE SIMULADOR    
    public static void iniciar()
    {
        vi.setLocationRelativeTo(null);
        vi.setVisible(true);
        vp.setVisible(true);
        //setTablas();
 
        
    }
        
    public static void iniciarSimulacion()
    {
    vp.setVisible(true);
    int mes = 1;
    int dia = 1;
    int jornada = 1;
    int tipo_Comb=1;
    while(mes<=12){
        ControladorEjecucion.setCant_carga(0);
        ControladorEjecucion.setCant_carga(Controladores.ControladorProbabilidad.distribucionNormal(750000, 40000));
        while(dia<=30&&p.equals(p.ACTIVADO)){
            tipo_Comb=1;
            Controladores.ControladorProceso.tiempoProceso();
            while(jornada<=Controladores.ControladorProceso.getTiempo()&&p.equals(p.ACTIVADO)){
                Controladores.ControladorProceso.establecerCarga();
                Controladores.ControladorProceso.procesarHoja();  
                jornada++;
            }
        while(tipo_Comb<=4){
            switch(tipo_Comb){
                case 1 : 
                    System.out.println("Tipo Combustible: Chip");
                    System.out.printf("Cantidad de Recurso: %.3f [kg]\n",Controladores.ControladorEnergetico.getCant_Chip());
                    break; 
                case 2 :
                    System.out.println("Tipo Combustible: Pellet");
                    System.out.printf("Cantidad de Recurso: %.3f [kg]\n",Controladores.ControladorEnergetico.getCant_Pellet());
                    break; 
                case 3 :
                    System.out.println("Tipo Combustible: Briqueta");
                    System.out.printf("Cantidad de Recurso:%.3f [kg]\n",Controladores.ControladorEnergetico.getCant_Briqueta());
                    break; 
                case 4 :
                    System.out.println("Tipo Combustible: Leña");
                    System.out.printf("Cantidad de Recurso:%.3f [kg]\n",Controladores.ControladorEnergetico.getCant_Leña());
                    break; 
                default : 
                   // Declaraciones
            }
        tipo_Comb++;
        }
        System.out.printf("Cantidad de Hojas verdes Procesadas: %.3f [kg]\n",Controladores.ControladorProceso.getAux_Proceso());
        System.out.printf("Cantidad de Hojas Secas obtenidas: %.3f [kg]\n",Controladores.ControladorProceso.getHoja_Seca());
        System.out.printf("Porcentaje de Humedad de Hojas Procesadas: %.3f\n",Controladores.ControladorProceso.getEstandar_Hoja());
            System.out.println("CONT"+Controladores.ControladorEnergetico.getCont_Temp());
            System.out.println("TOTAL TEMP" + Controladores.ControladorEnergetico.getAux_tempSecado());
        System.out.printf("Temperatura Promedio de Secado: %.3f [ºC]\n",Controladores.ControladorEnergetico.getAux_tempSecado()/Controladores.ControladorEnergetico.getCont_Temp());
        Controladores.ControladorEjecucion.setP(proceso.DESACTIVADO);     
        dia++;
        }
    mes++;    
    }  
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public static void setTablas()
//    {
//        Object[] lista = {"N° Lote", "Peso (T)","Humedad","Metodo"};
//        DefaultTableModel modelo = new DefaultTableModel(null,lista);
//        v.getTablaProceso().setModel(modelo);
//        
//        Object[] lista2 = {"N° Lote", "Humedad","Metodo","Estado","Exposicion"};
//        DefaultTableModel modelo2 = new DefaultTableModel(null,lista2);
//        vp.getTablaProceso2().setModel(modelo2);
//    }
//    
//    public static void cargarTablaProceso2()
//    {
//        DefaultTableModel modelo2 = (DefaultTableModel) vp.getTablaProceso2().getModel();
//        for(Proceso pro: DataBase.getProceso())
//        {
//            modelo2.addRow(new Object[]{pro.getNroLotes(),
//                                       pro.getHumedad(),pro.getTipoProceso(),"En Espera","6 horas"});
//        }
//        vp.getTablaProceso2().setModel(modelo2);
//    }
    
//    public static void cargarProceso()
//    {
//        DefaultTableModel modelo = (DefaultTableModel) v.getTablaProceso().getModel();
//        if(v.getTextLotes().getText().isEmpty() || v.getTextHumedad().getText().isEmpty() ||
//                v.getTextToneladas().getText().isEmpty())
//        {
//            JOptionPane.showMessageDialog(null,"Los campos no pueden estar vacios","ATENCION",JOptionPane.WARNING_MESSAGE);
//        }
//        else
//            
//        {
//            v.getBotonSimular().setEnabled(true);
//            int lote = Integer.parseInt(v.getTextLotes().getText());
//            int peso = Integer.parseInt(v.getTextToneladas().getText());
//            double humedad = Double.parseDouble(v.getTextHumedad().getText());
//            String tipo = v.getCombo1().getSelectedItem().toString();
//            Proceso pro = new Proceso(tipo,lote,peso,humedad);
//            DataBase.agregarProceso(pro);
//            modelo.addRow(new Object[]{pro.getNroLotes(),pro.getPeso(),
//                                       pro.getHumedad(),pro.getTipoProceso()});
//            v.getTextHumedad().setText("");
//            v.getTextLotes().setText("");
//            v.getTextToneladas().setText("");
//        }
//    }
    
//    public static void iniciarProceso()
//    {
//        
//        Calendar calendario = new GregorianCalendar();
//        v.dispose();
//        vp.setLocationRelativeTo(null);
//        vp.setVisible(true);
//        cargarTablaProceso2();
//        int cantidadFilas;
//        cantidadFilas = vp.getTablaProceso2().getRowCount();
//        System.out.println(cantidadFilas);
//        valor = 100/cantidadFilas;
//        i=0;
//        System.out.println(valor);
//        vp.getjLabel7().setText(vp.getTablaProceso2().getValueAt(i, 0).toString());
//        vp.getjLabel6().setText(vp.getTablaProceso2().getValueAt(i, 2).toString());
//        vp.getjLabel8().setText(vp.getTablaProceso2().getValueAt(i, 1).toString());
//        vp.getjLabel10().setText(String.valueOf(calendario.get(Calendar.HOUR_OF_DAY)));
//        vp.getjLabel18().setText(String.valueOf(calendario.get(Calendar.MINUTE)));
//        vp.getjLabel19().setText(String.valueOf(calendario.get(Calendar.SECOND)));
//        
//        al = new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                if(vp.getjProgressBar1().getValue() < 100)
//                {
//                    
//                    if(vp.getjLabel6().getText().equals("Vapor"))
//                    {
//                        vp.getjProgressBar1().setValue(vp.getjProgressBar1().getValue()+2);
//                    }
//                    else
//                    {
//                        vp.getjProgressBar1().setValue(vp.getjProgressBar1().getValue()+1);
//                    }
//                    
//                    if(vp.getjProgressBar1().getValue() >= ((100/cantidadFilas) * (i+1)) && 
//                       vp.getjProgressBar1().getValue() < (valor + (100/cantidadFilas) * (i+1)) && 
//                      (cantidadFilas>1) )
//                    {
//                        vp.getTablaProceso2().setValueAt("Terminado", i, 3);
//                        i++;
//                        if(i<cantidadFilas)
//                        {
//                            vp.getjLabel7().setText(vp.getTablaProceso2().getValueAt(i, 0).toString());
//                            vp.getjLabel6().setText(vp.getTablaProceso2().getValueAt(i, 2).toString());
//                            vp.getjLabel8().setText(vp.getTablaProceso2().getValueAt(i, 1).toString());
//                        }
//                                           
//                        
//                    }
//                    
//                }
//                else
//                {
//                    System.out.println(i);
//                    vp.getjButton1().setEnabled(true);
//                    vp.getjLabel15().setText("El Proceso ha concluido satisfactoriamente");
//                    if(cantidadFilas==1)
//                    {
//                        i++;
//                    }
//                    vp.getTablaProceso2().setValueAt("Terminado", i-1, 3);
//                    t.stop();
//                     
//                        
//                }
//                              
//                vp.getjLabel12().setText(String.valueOf(Math.floor(Math.random()*(100-96+1) + 96)));
//                vp.getjLabel14().setText(String.valueOf(Math.floor(Math.random()*(20-10+1) + 10)));
//                
//            }
//        };
//        t = new Timer(150,al);
//        t.start();
//        
//    }
//    
//    
    
}
