/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foro2;

/**
 *
 * @author diego
 */
public class Motocicleta extends Vehiculo {
    private final int cilindraje;
    private final String tipoMotocicleta;

    public Motocicleta(String codigo, String marca, String modelo, int anio, double precio, 
                       int cilindraje, String tipoMotocicleta) {
        super(codigo, marca, modelo, anio, precio);
        this.cilindraje = cilindraje;
        this.tipoMotocicleta = tipoMotocicleta;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "\nCilindraje: " + cilindraje + " cc\nTipo: " + tipoMotocicleta;
    }
}
