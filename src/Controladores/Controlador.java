/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Modelo.DataBase;
import Vista.Ventana;
import javax.swing.table.DefaultTableModel;
import Modelo.Proceso;
import Vista.VentanaProceso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author Juampy
 */
public class Controlador {
    static Ventana v = new Ventana();
    static VentanaProceso vp = new VentanaProceso();
    static ActionListener al;
    static Timer t; 
    static int valor;
    static int i;
    public static boolean proceso=false;

    
    public static void iniciar()
    {
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        setTablas();
        
        ///PROBANDO FUNCIONES NUEVAS
        System.out.println(Controladores.ControladorHumedad.humedadHoja(3500.0D));
        System.out.println(Controladores.ControladorCalor.calcularCalorRequerido(30, 4, 7, 90, 0));
        System.out.println(Controladores.ControladorCalor.calcularCalorLeña());
        System.out.println(Controladores.ControladorCalor.perdidaTemperatura());
        System.out.println(Controladores.ControladorHumedad.estandarHoja());
        System.out.println(Controladores.ControladorProceso.establecerCarga(750000));
        System.out.println(Controladores.ControladorProceso.tiempoProceso());
        System.out.println(Controladores.ControladorProbabilidad.distribucionNormal(850, 150));
        
    }
    public static void setTablas()
    {
        Object[] lista = {"N° Lote", "Peso (T)","Humedad","Metodo"};
        DefaultTableModel modelo = new DefaultTableModel(null,lista);
        v.getTablaProceso().setModel(modelo);
        
        Object[] lista2 = {"N° Lote", "Humedad","Metodo","Estado","Exposicion"};
        DefaultTableModel modelo2 = new DefaultTableModel(null,lista2);
        vp.getTablaProceso2().setModel(modelo2);
    }
    
    public static void cargarTablaProceso2()
    {
        DefaultTableModel modelo2 = (DefaultTableModel) vp.getTablaProceso2().getModel();
        for(Proceso pro: DataBase.getProceso())
        {
            modelo2.addRow(new Object[]{pro.getNroLotes(),
                                       pro.getHumedad(),pro.getTipoProceso(),"En Espera","6 horas"});
        }
        vp.getTablaProceso2().setModel(modelo2);
    }
    
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
    
    public static void iniciarProceso()
    {
        
        Calendar calendario = new GregorianCalendar();
        v.dispose();
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
        cargarTablaProceso2();
        int cantidadFilas;
        cantidadFilas = vp.getTablaProceso2().getRowCount();
        System.out.println(cantidadFilas);
        valor = 100/cantidadFilas;
        i=0;
        System.out.println(valor);
        vp.getjLabel7().setText(vp.getTablaProceso2().getValueAt(i, 0).toString());
        vp.getjLabel6().setText(vp.getTablaProceso2().getValueAt(i, 2).toString());
        vp.getjLabel8().setText(vp.getTablaProceso2().getValueAt(i, 1).toString());
        vp.getjLabel10().setText(String.valueOf(calendario.get(Calendar.HOUR_OF_DAY)));
        vp.getjLabel18().setText(String.valueOf(calendario.get(Calendar.MINUTE)));
        vp.getjLabel19().setText(String.valueOf(calendario.get(Calendar.SECOND)));
        
        al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(vp.getjProgressBar1().getValue() < 100)
                {
                    
                    if(vp.getjLabel6().getText().equals("Vapor"))
                    {
                        vp.getjProgressBar1().setValue(vp.getjProgressBar1().getValue()+2);
                    }
                    else
                    {
                        vp.getjProgressBar1().setValue(vp.getjProgressBar1().getValue()+1);
                    }
                    
                    if(vp.getjProgressBar1().getValue() >= ((100/cantidadFilas) * (i+1)) && 
                       vp.getjProgressBar1().getValue() < (valor + (100/cantidadFilas) * (i+1)) && 
                      (cantidadFilas>1) )
                    {
                        vp.getTablaProceso2().setValueAt("Terminado", i, 3);
                        i++;
                        if(i<cantidadFilas)
                        {
                            vp.getjLabel7().setText(vp.getTablaProceso2().getValueAt(i, 0).toString());
                            vp.getjLabel6().setText(vp.getTablaProceso2().getValueAt(i, 2).toString());
                            vp.getjLabel8().setText(vp.getTablaProceso2().getValueAt(i, 1).toString());
                        }
                                           
                        
                    }
                    
                }
                else
                {
                    System.out.println(i);
                    vp.getjButton1().setEnabled(true);
                    vp.getjLabel15().setText("El Proceso ha concluido satisfactoriamente");
                    if(cantidadFilas==1)
                    {
                        i++;
                    }
                    vp.getTablaProceso2().setValueAt("Terminado", i-1, 3);
                    t.stop();
                     
                        
                }
                              
                vp.getjLabel12().setText(String.valueOf(Math.floor(Math.random()*(100-96+1) + 96)));
                vp.getjLabel14().setText(String.valueOf(Math.floor(Math.random()*(20-10+1) + 10)));
                
            }
        };
        t = new Timer(150,al);
        t.start();
        
    }
    
    
    
}
