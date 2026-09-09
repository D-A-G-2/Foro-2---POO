/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foro2;

/**
 *
 * @author diego
 */
public class Automovil extends Vehiculo {
    private int cantidadPuertas;
    private String tipoCombustible;

    public Automovil(String codigo, String marca, String modelo, int anio, double precio,
                     int cantidadPuertas, String tipoCombustible) {
        super(codigo, marca, modelo, anio, precio); // Reutiliza el constructor del padre
        this.cantidadPuertas = cantidadPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    public int getCantidadPuertas() { return cantidadPuertas; }
    public void setCantidadPuertas(int c) { this.cantidadPuertas = c; }
    public String getTipoCombustible() { return tipoCombustible; }
    public void setTipoCombustible(String t) { this.tipoCombustible = t; }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos()
             + "\nTipo: AUTOMÓVIL"
             + "\nCantidad de puertas: " + cantidadPuertas
             + "\nTipo de combustible: " + tipoCombustible;
    }
}
