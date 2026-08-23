package Ejercicio_6;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Libreria libreria = cargarLibreria();

        int opcion = -1;

        while (opcion != 0) {

            try {
                opcion = mostrarMenu();
                ejecutarOpcion(opcion, libreria);

            } catch (NumberFormatException e) {
                mostrarError("Debe ingresar un número válido.");

            } catch (Exception e) {
                mostrarError(e.getMessage());
            }
        }

        guardarLibreria(libreria);
        JOptionPane.showMessageDialog(null, "Programa finalizado.");
    }

    // MENÚ
    private static int mostrarMenu() {
        String menu = "LIBRERÍA\n\n"
                        + "1. Registrar novela\n"
                        + "2. Registrar libro técnico\n"
                        + "3. Buscar libro\n"
                        + "4. Mostrar libros\n"
                        + "5. Vender libro\n"
                        + "6. Consultar stock\n"
                        + "7. Realizar encargo\n"
                        + "8. Agregar proveedor\n"
                        + "9. Mostrar proveedores\n"
                        + "10. Mostrar encargos\n"
                        + "0. Salir";

        return Integer.parseInt(JOptionPane.showInputDialog(null, menu,
                        "Librería", JOptionPane.QUESTION_MESSAGE));
    }

    // =========================================================
    // EJECUTAR OPCIÓN
    // =========================================================

    private static void ejecutarOpcion(int opcion, Libreria libreria) throws Exception {

        switch (opcion) {

            case 1:
                registrarNovela(libreria);
                break;

            case 2:
                registrarTecnico(libreria);
                break;

            case 3:
                buscarLibro(libreria);
                break;

            case 4:
                mostrarLibros(libreria);
                break;

            case 5:
                venderLibro(libreria);
                break;

            case 6:
                consultarStock(libreria);
                break;

            case 7:
                realizarEncargo(libreria);
                break;

            case 8:
                agregarProveedor(libreria);
                break;

            case 9:
                mostrarProveedores(libreria);
                break;

            case 10:
                mostrarEncargos(libreria);
                break;

            case 0:
                break;

            default:
                throw new Exception("La opción seleccionada no existe.");
        }
    }

    // REGISTRAR NOVELA
    private static void registrarNovela(Libreria libreria) throws Exception {

        String titulo = pedirTexto("Ingrese el título:");

        ArrayList<String> autores = pedirLista("autor");

        String editorial = pedirTexto("Ingrese la editorial:");

        int anioEdicion = pedirEntero("Ingrese el año de edición:");

        String formato = pedirTexto("Ingrese el formato:");

        String isbn = pedirTexto("Ingrese el ISBN:");

        ArrayList<String> capitulos = pedirLista("capítulo");

        int stock = pedirEntero("Ingrese el stock:");

        String tipo = pedirTexto(
                "Ingrese el tipo de novela:\n"
                        + "Ciencia ficción\n"
                        + "Romance\n"
                        + "Misterio\n"
                        + "Juvenil\n"
                        + "Policial");

        Novela novela = new Novela(titulo, autores, editorial, anioEdicion, formato,
                isbn, capitulos, stock, tipo);

        libreria.agregarLibro(novela);

        JOptionPane.showMessageDialog(null, "Novela registrada correctamente.");
    }

    // REGISTRAR LIBRO TÉCNICO
    private static void registrarTecnico(Libreria libreria) throws Exception {

        String titulo = pedirTexto("Ingrese el título:");

        ArrayList<String> autores = pedirLista("autor");

        String editorial = pedirTexto("Ingrese la editorial:");

        int anioEdicion = pedirEntero("Ingrese el año de edición:");

        String formato = pedirTexto("Ingrese el formato:");

        String isbn = pedirTexto("Ingrese el ISBN:");

        ArrayList<String> capitulos = pedirLista("capítulo");

        int stock = pedirEntero("Ingrese el stock:");

        String tipo = pedirTexto("Ingrese el tipo de libro técnico:\n"
                        + "Ingeniería\n"
                        + "Ciencias naturales\n"
                        + "Ciencias sociales");

        ArrayList<String> materias = pedirLista("materia");

        Tecnico tecnico = new Tecnico(titulo, autores,editorial, anioEdicion, formato,
                isbn, capitulos, stock, tipo, materias);

        libreria.agregarLibro(tecnico);

        JOptionPane.showMessageDialog(null, "Libro técnico registrado correctamente.");
    }

    // BUSCAR LIBRO
    private static void buscarLibro(Libreria libreria) throws Exception {

        String isbn = pedirTexto("Ingrese el ISBN del libro:");

        Libro libro = libreria.buscarLibro(isbn);

        if (libro == null) {
            throw new Exception("No se encontró ningún libro con ese ISBN.");
        }

        JOptionPane.showMessageDialog(null, libro.toString(),
                "Libro encontrado", JOptionPane.INFORMATION_MESSAGE);
    }

    // MOSTRAR LIBROS
    private static void mostrarLibros(Libreria libreria) {

        JOptionPane.showMessageDialog(null, libreria.mostrarLibros(),
                "Libros registrados", JOptionPane.INFORMATION_MESSAGE);
    }

    // VENDER LIBRO
    private static void venderLibro(Libreria libreria) throws Exception {

        String isbn = pedirTexto("Ingrese el ISBN del libro:");

        libreria.venderLibro(isbn);

        JOptionPane.showMessageDialog(null, "Venta realizada correctamente.",
                "Venta", JOptionPane.INFORMATION_MESSAGE);
    }

    // CONSULTAR STOCK
    private static void consultarStock(Libreria libreria) throws Exception {

        String isbn = pedirTexto("Ingrese el ISBN del libro:");

        int stock = libreria.consultarStock(isbn);

        JOptionPane.showMessageDialog(null, "Stock disponible: " +
                stock, "Stock", JOptionPane.INFORMATION_MESSAGE);
    }

    // REALIZAR ENCARGO
    private static void realizarEncargo(Libreria libreria) throws Exception {

        String isbn = pedirTexto("Ingrese el ISBN del libro:");

        String cliente = pedirTexto("Ingrese el nombre del cliente:");

        libreria.realizarEncargo(isbn, cliente);

        JOptionPane.showMessageDialog(null, "Encargo registrado correctamente.",
                "Encargo", JOptionPane.INFORMATION_MESSAGE);
    }

    // AGREGAR PROVEEDOR
    private static void agregarProveedor(Libreria libreria) throws Exception {

        String proveedor = pedirTexto("Ingrese el nombre del proveedor:");

        libreria.agregarProveedor(proveedor);

        JOptionPane.showMessageDialog(null, "Proveedor registrado correctamente.",
                "Proveedor", JOptionPane.INFORMATION_MESSAGE);
    }

    // MOSTRAR PROVEEDORES
    private static void mostrarProveedores(Libreria libreria) {

        JOptionPane.showMessageDialog(null, libreria.mostrarProveedores(),
                "Proveedores", JOptionPane.INFORMATION_MESSAGE);
    }

    // MOSTRAR ENCARGOS
    private static void mostrarEncargos(Libreria libreria) {

        JOptionPane.showMessageDialog(null, libreria.mostrarEncargos(),
                "Encargos", JOptionPane.INFORMATION_MESSAGE);
    }

    // PEDIR TEXTO
    private static String pedirTexto(String mensaje) throws Exception {

        String texto = JOptionPane.showInputDialog(null, mensaje);

        if (texto == null) {
            throw new Exception("Operación cancelada.");
        }

        texto = texto.trim();

        if (texto.isEmpty()) {
            throw new Exception("El campo no puede estar vacío.");
        }

        return texto;
    }

    // PEDIR ENTERO
    private static int pedirEntero(String mensaje) {
        return Integer.parseInt(pedirTextoSinException(mensaje));
    }

    private static String pedirTextoSinException(String mensaje) {

        String texto = JOptionPane.showInputDialog(null, mensaje);

        if (texto == null) {
            throw new RuntimeException("Operación cancelada.");
        }

        texto = texto.trim();

        if (texto.isEmpty()) {
            throw new RuntimeException("El campo no puede estar vacío.");
        }

        return texto;
    }

    // PEDIR LISTA
    private static ArrayList<String> pedirLista(String nombre) throws Exception {

        ArrayList<String> lista = new ArrayList<>();

        int cantidad = pedirEntero("¿Cuántos " + nombre + " desea ingresar?");

        if (cantidad <= 0) {
            throw new Exception("Debe ingresar al menos un " + nombre + ".");
        }

        for (int i = 0; i < cantidad; i++) {

            String dato = pedirTexto("Ingrese " + nombre + " " + (i + 1) + ":");
            lista.add(dato);
        }

        return lista;
    }

    // CARGAR LIBRERÍA
    private static Libreria cargarLibreria() {
        try {
            return Libreria.cargar();

        } catch (IOException | ClassNotFoundException e) {

            return new Libreria();
        }
    }

    // GUARDAR LIBRERÍA
    private static void guardarLibreria(Libreria libreria) {
        try {
            libreria.guardar();

        } catch (IOException e) {
            mostrarError("No se pudo guardar la librería:\n" + e.getMessage());
        }
    }

    // MOSTRAR ERROR
    private static void mostrarError(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}