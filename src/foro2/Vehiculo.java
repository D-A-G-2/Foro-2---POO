/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foro2;

/**
 *
 * @author diego
 * David
 * 
 */
public class Vehiculo {

    /**
     *
     */
    private String codigo;
    private String marca;
    private String modelo;
    private int anio;
    private double precio;

    public Vehiculo(String codigo, String marca, String modelo, int anio, double precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }

    // Getters y Setters para cada atributo
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Método para mostrar información común
    public String mostrarDatos() {
        return "Código: " + codigo + "\nMarca: " + marca + "\nModelo: " + modelo +
               "\nAño: " + anio + "\nPrecio: $" + precio;
    }
}
