/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casodeestudio2;

/**
 *
 * @author mtorr
 */
public class Participante {
    private String nombre;
    private double presupuesto;

    public Participante(String nombre, double presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void reducirPresupuesto(double cantidad) {
        presupuesto -= cantidad;
    }
}


