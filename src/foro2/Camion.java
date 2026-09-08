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
    private final double capacidadCarga; // en toneladas
    private final int cantidadEjes;

    public Camion(String codigo, String marca, String modelo, int anio, double precio, 
                  double capacidadCarga, int cantidadEjes) {
        super(codigo, marca, modelo, anio, precio);
        this.capacidadCarga = capacidadCarga;
        this.cantidadEjes = cantidadEjes;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "\nCapacidad Carga: " + capacidadCarga + " Ton\nEjes: " + cantidadEjes;
    }
}