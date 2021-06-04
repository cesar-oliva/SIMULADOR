/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Cesar
 */
public class Recurso {
    String descripcion;
    double Kcal;
    double costo;

    public Recurso(String descripcion, double Kcal, double costo) {
        this.descripcion = descripcion;
        this.Kcal = Kcal;
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getKcal() {
        return Kcal;
    }

    public void setKcal(double Kcal) {
        this.Kcal = Kcal;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    
    
}
