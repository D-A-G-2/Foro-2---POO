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

    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    static final String MENU =
            " AUTOMUNDO S.A. DE C.V. \n"
          + "Sistema de Gestión de Vehículos\n\n"
          + "1. Registrar vehículo\n"
          + "2. Consultar vehículo por código\n"
          + "3. Mostrar todos los vehículos\n"
          + "4. Eliminar vehículo\n"
          + "5. Salir\n\n"
          + "Digite el número de la opción:";

    public static void main(String[] args) {
        int opcion;
        do {
            Integer seleccion = pedirEntero(MENU, 1, 5);
            opcion = (seleccion == null) ? 5 : seleccion; // Cancelar = salir

            switch (opcion) {
                case 1: registrarVehiculo(); break;
                case 2: consultarVehiculo(); break;
                case 3: mostrarVehiculos();  break;
                case 4: eliminarVehiculo();  break;
                case 5: JOptionPane.showMessageDialog(null,
                          "¡Gracias por usar el sistema AutoMundo!",
                          "Salida", JOptionPane.INFORMATION_MESSAGE);
                          break;
            }
        } while (opcion != 5);
    }

    // Metodos del sistema

    static void registrarVehiculo() {
        // 1) Elegir tipo de vehículo
        String[] tipos = {"Automóvil", "Motocicleta", "Camión"};
        String tipo = (String) JOptionPane.showInputDialog(null,
                "Seleccione el tipo de vehículo a registrar:", "Registro de Vehículos",
                JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        if (tipo == null) return;

        String codigo = pedirTexto("Código del vehículo:");
        if (codigo == null) return;

        if (buscarVehiculo(codigo) != null) {
            JOptionPane.showMessageDialog(null, "️ El código \"" + codigo
                    + "\" ya existe.\nNo se permiten duplicados.",
                    "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String marca  = pedirTexto("Marca:");  if (marca  == null) return;
        String modelo = pedirTexto("Modelo:"); if (modelo == null) return;
        Integer anio  = pedirEntero("Año del vehículo:", 1940, 2026);
        if (anio == null) return;
        Double precio = pedirDecimal("Precio del vehículo en $ (mayor a 0):");
        if (precio == null) return;

        // Datos de cada subclase.
        if (tipo.equals("Automóvil")) {
            Integer puertas = pedirEntero("Cantidad de puertas (2 - 6):", 2, 6);
            if (puertas == null) return;
            String[] combustibles = {"Gasolina", "Diésel", "Eléctrico", "Híbrido", "Biodiesel"};
            String combustible = (String) JOptionPane.showInputDialog(null,
                    "Tipo de combustible:", "Registro de Automóvil",
                    JOptionPane.QUESTION_MESSAGE, null, combustibles, combustibles[0]);
            if (combustible == null) return;
            vehiculos.add(new Automovil(codigo, marca, modelo, anio, precio, puertas, combustible));

        } else if (tipo.equals("Motocicleta")) {
            Integer cilindraje = pedirEntero("Cilindraje en cc (40 - 2500):", 40, 2500);
            if (cilindraje == null) return;
            String[] tiposMoto = {"Deportiva", "Urbana", "Touring", "Todoterreno"};
            String tipoMoto = (String) JOptionPane.showInputDialog(null,
                    "Tipo de motocicleta:", "Registro de Motocicleta",
                    JOptionPane.QUESTION_MESSAGE, null, tiposMoto, tiposMoto[0]);
            if (tipoMoto == null) return;
            vehiculos.add(new Motocicleta(codigo, marca, modelo, anio, precio, cilindraje, tipoMoto));

        } else { // Camión
            Double capacidad = pedirDecimal("Capacidad de carga en toneladas (mayor a 0):");
            if (capacidad == null) return;
            Integer ejes = pedirEntero("Cantidad de ejes (2 - 6):", 2, 6);
            if (ejes == null) return;
            vehiculos.add(new Camion(codigo, marca, modelo, anio, precio, capacidad, ejes));
        }

        JOptionPane.showMessageDialog(null, " Vehículo registrado exitosamente.",
                "Registro", JOptionPane.INFORMATION_MESSAGE);
    }

    static void consultarVehiculo() {
        if (listaVacia()) return;
        String codigo = pedirTexto("Ingrese el código del vehículo a consultar:");
        if (codigo == null) return;

        Vehiculo v = buscarVehiculo(codigo);
        if (v != null) {
            JOptionPane.showMessageDialog(null, " VEHÍCULO ENCONTRADO:\n\n" + v.mostrarDatos(),
                    "Consulta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.",
                    "Consulta", JOptionPane.WARNING_MESSAGE);
        }
    }

    static void mostrarVehiculos() {
        if (listaVacia()) return;

        String[] filtros = {"Todos", "Automóviles", "Motocicletas", "Camiones"};
        String filtro = (String) JOptionPane.showInputDialog(null,
                "¿Qué vehículos desea mostrar?", "Listado de Vehículos",
                JOptionPane.QUESTION_MESSAGE, null, filtros, filtros[0]);
        if (filtro == null) return;

        String listado = " LISTADO DE VEHÍCULOS REGISTRADOS\n\n";
        int contador = 0;
        for (Vehiculo v : vehiculos) {
            boolean mostrar = filtro.equals("Todos")
                    || (filtro.equals("Automóviles")  && v instanceof Automovil)
                    || (filtro.equals("Motocicletas") && v instanceof Motocicleta)
                    || (filtro.equals("Camiones")     && v instanceof Camion);
            if (mostrar) {
                listado += v.mostrarDatos() + "\n──────────────────────────\n";
                contador++;
            }
        }
        if (contador == 0) listado += "No hay vehículos registrados de este tipo.";
        JOptionPane.showMessageDialog(null, listado, "Listado", JOptionPane.INFORMATION_MESSAGE);
    }

    static void eliminarVehiculo() {
        if (listaVacia()) return;
        String codigo = pedirTexto("Ingrese el código del vehículo a eliminar:");
        if (codigo == null) return;

        Vehiculo v = buscarVehiculo(codigo);
        if (v == null) {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado. No se puede eliminar.",
                    "Eliminar", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Seguro que desea eliminar el vehículo con código " + v.getCodigo() + "?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            vehiculos.remove(v);
            JOptionPane.showMessageDialog(null, "🗑️ Vehículo eliminado exitosamente.",
                    "Eliminar", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // metodos de apoyo

    static boolean listaVacia() {
        if (vehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados todavía.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    static Vehiculo buscarVehiculo(String codigo) {
        for (Vehiculo v : vehiculos) {
            if (v.getCodigo().equalsIgnoreCase(codigo)) return v;
        }
        return null;
    }

    // Pide texto y no permite campos vacíos
    static String pedirTexto(String mensaje) {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, mensaje,
                    "Datos del Vehículo", JOptionPane.QUESTION_MESSAGE);
            if (texto == null) return null; // El usuario presionó Cancelar
            texto = texto.trim();
            if (!texto.isEmpty()) return texto;
            JOptionPane.showMessageDialog(null, "️ El campo no puede estar vacío.",
                    "Validación", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Pide un número entero dentro de un rango (maneja la excepción si escriben letras)
    static Integer pedirEntero(String mensaje, int minimo, int maximo) {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, mensaje,
                    "Datos del Vehículo", JOptionPane.QUESTION_MESSAGE);
            if (texto == null) return null;
            try {
                int valor = Integer.parseInt(texto.trim());
                if (valor >= minimo && valor <= maximo) return valor;
                JOptionPane.showMessageDialog(null, "⚠️ El valor debe estar entre "
                        + minimo + " y " + maximo + ".", "Validación", JOptionPane.WARNING_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "⚠️ Debe ingresar un número entero válido.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // Pide un número decimal mayor a cero (usa PUNTO para decimales, ej: 15500.50)
    static Double pedirDecimal(String mensaje) {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, mensaje,
                    "Datos del Vehículo", JOptionPane.QUESTION_MESSAGE);
            if (texto == null) return null;
            try {
                double valor = Double.parseDouble(texto.trim());
                if (valor > 0) return valor;
                JOptionPane.showMessageDialog(null, "⚠️ El valor debe ser mayor a cero.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "⚠️ Debe ingresar un número válido (use punto para decimales).",
                        "Validación", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}