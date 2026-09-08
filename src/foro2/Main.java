/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package foro2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Automovil> listaAutomoviles = new ArrayList<>();
        int opcion = 0;

        do {
            String menu = "=== GESTIÓN DE AUTOMÓVILES ===\n"
                        + "1. Registrar automóvil\n"
                        + "2. Consultar por código\n"
                        + "3. Mostrar todos\n"
                        + "4. Eliminar por código\n"
                        + "5. Salir\n\n"
                        + "Seleccione una opción:";

            String entrada = JOptionPane.showInputDialog(null, menu);
            if (entrada == null) break;

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    String codigo = JOptionPane.showInputDialog("Código:");
                    String marca = JOptionPane.showInputDialog("Marca:");
                    String modelo = JOptionPane.showInputDialog("Modelo:");
                    int anio = Integer.parseInt(JOptionPane.showInputDialog("Año:"));
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
                    int puertas = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de puertas:"));
                    String combustible = JOptionPane.showInputDialog("Tipo de combustible:");

                    listaAutomoviles.add(new Automovil(codigo, marca, modelo, anio, precio, puertas, combustible));
                    JOptionPane.showMessageDialog(null, "¡Automóvil ingresado exitosamente!");
                }

                case 2 -> {
                    String codBuscar = JOptionPane.showInputDialog("Ingrese código a buscar:");
                    boolean encontrado = false;
                    for (Automovil auto : listaAutomoviles) {
                        if (auto.getCodigo().equalsIgnoreCase(codBuscar)) {
                            JOptionPane.showMessageDialog(null, auto.mostrarDatos(), "Detalle", JOptionPane.INFORMATION_MESSAGE);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) JOptionPane.showMessageDialog(null, "Alumno/Automóvil no encontrado, no se puede Mostrar");
                }

                case 3 -> {
                    if (listaAutomoviles.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay automóviles registrados.");
                    } else {
                        StringBuilder sb = new StringBuilder("=== LISTA DE AUTOMÓVILES ===\n\n");
                        for (Automovil auto : listaAutomoviles) {
                            sb.append(auto.mostrarDatos()).append("\n-------------------\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                }

                case 4 -> {
                    String codEliminar = JOptionPane.showInputDialog("Ingrese código a eliminar:");
                    boolean eliminado = false;
                    for (int i = 0; i < listaAutomoviles.size(); i++) {
                        if (listaAutomoviles.get(i).getCodigo().equalsIgnoreCase(codEliminar)) {
                            listaAutomoviles.remove(i);
                            JOptionPane.showMessageDialog(null, "Eliminado exitosamente.");
                            eliminado = true;
                            break;
                        }
                    }
                    if (!eliminado) JOptionPane.showMessageDialog(null, "Automóvil no encontrado, No se puede Eliminar");
                }

                case 5 -> JOptionPane.showMessageDialog(null, "Saliendo...");
            }

        } while (opcion != 5);
    }
}
