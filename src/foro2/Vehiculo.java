/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foro2;

/**
 *
 * @author diego
 */
public class Vehiculo {

    /**
     *
     */
    protected String codigo;
    protected String marca;
    protected String modelo;
    protected int anio;
    protected double precio;

    public Vehiculo(String codigo, String marca, String modelo, int anio, double precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }

    // Getters y Setters para cada atributo
    public String getCodigo() { return codigo; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnio() { return anio; }
    public double getPrecio() { return precio; }

    // Método para mostrar información común
    public String mostrarDatos() {
        return "Código: " + codigo + "\nMarca: " + marca + "\nModelo: " + modelo +
               "\nAño: " + anio + "\nPrecio: $" + precio;
    }
}
