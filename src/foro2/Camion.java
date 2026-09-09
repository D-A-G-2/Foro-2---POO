/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foro2;

/**
 *
 * @author diego
 */
public class Camion extends Vehiculo {
    private double capacidadCarga;
    private int cantidadEjes;

    public Camion(String codigo, String marca, String modelo, int anio, double precio,
                  double capacidadCarga, int cantidadEjes) {
        super(codigo, marca, modelo, anio, precio);
        this.capacidadCarga = capacidadCarga;
        this.cantidadEjes = cantidadEjes;
    }

    public double getCapacidadCarga() { return capacidadCarga; }
    public void setCapacidadCarga(double c) { this.capacidadCarga = c; }
    public int getCantidadEjes() { return cantidadEjes; }
    public void setCantidadEjes(int c) { this.cantidadEjes = c; }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos()
             + "\nTipo: CAMIÓN"
             + "\nCapacidad de carga: " + capacidadCarga + " toneladas"
             + "\nCantidad de ejes: " + cantidadEjes;
    }
}