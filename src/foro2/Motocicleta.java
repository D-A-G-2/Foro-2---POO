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
    private int cilindraje;
    private String tipoMotocicleta;

    public Motocicleta(String codigo, String marca, String modelo, int anio, double precio,
                       int cilindraje, String tipoMotocicleta) {
        super(codigo, marca, modelo, anio, precio);
        this.cilindraje = cilindraje;
        this.tipoMotocicleta = tipoMotocicleta;
    }

    public int getCilindraje() { return cilindraje; }
    public void setCilindraje(int c) { this.cilindraje = c; }
    public String getTipoMotocicleta() { return tipoMotocicleta; }
    public void setTipoMotocicleta(String t) { this.tipoMotocicleta = t; }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos()
             + "\nTipo: MOTOCICLETA"
             + "\nCilindraje: " + cilindraje + " cc"
             + "\nTipo de motocicleta: " + tipoMotocicleta;
    }
}
