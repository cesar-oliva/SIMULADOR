/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Juampy
 */
public class Proceso {
    private String tipoProceso;
    private int nroLotes;
    private int peso;
    private double humedad;
    private String estado;
    private int Exposicion;

    public Proceso(String tipoProceso, int nroLotes, int peso, double humedad) {
        this.tipoProceso = tipoProceso;
        this.nroLotes = nroLotes;
        this.peso = peso;
        this.humedad = humedad;
    }

    public Proceso(String tipoProceso, int nroLotes, int peso) {
        this.tipoProceso = tipoProceso;
        this.nroLotes = nroLotes;
        this.peso = peso;
    }

    public Proceso(String tipoProceso, int nroLotes, double humedad, String estado, int Exposicion) {
        this.tipoProceso = tipoProceso;
        this.nroLotes = nroLotes;
        this.humedad = humedad;
        this.estado = estado;
        this.Exposicion = Exposicion;
    }
    
    

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    public int getNroLotes() {
        return nroLotes;
    }

    public void setNroLotes(int nroLotes) {
        this.nroLotes = nroLotes;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getExposicion() {
        return Exposicion;
    }

    public void setExposicion(int Exposicion) {
        this.Exposicion = Exposicion;
    }
    
    
    
    
}