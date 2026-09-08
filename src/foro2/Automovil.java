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
    private final int cantidadPuertas;
    private final String tipoCombustible;

    public Automovil(String codigo, String marca, String modelo, int anio, double precio, 
                     int cantidadPuertas, String tipoCombustible) {
        super(codigo, marca, modelo, anio, precio); // Llama al constructor de Vehiculo
        this.cantidadPuertas = cantidadPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "\nPuertas: " + cantidadPuertas + "\nCombustible: " + tipoCombustible;
    }
}
