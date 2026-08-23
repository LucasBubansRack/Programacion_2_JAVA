package Ejercicio_6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Libreria implements Serializable {

    private final ArrayList<Libro> libros;
    private final ArrayList<String> proveedores;
    private final ArrayList<String> encargos;

    public Libreria() {
        libros = new ArrayList<>();
        proveedores = new ArrayList<>();
        encargos = new ArrayList<>();
    }

    // LIBROS
    public void agregarLibro(Libro libro) throws Exception {

        if (libro == null) {
            throw new Exception("El libro no puede ser nulo.");
        }

        if (libro.getTitulo() == null || libro.getTitulo().trim().isEmpty()) {
            throw new Exception("El título no puede estar vacío.");
        }

        if (libro.getAutores() == null || libro.getAutores().isEmpty()) {
            throw new Exception("El libro debe tener al menos un autor.");
        }

        if (libro.getEditorial() == null || libro.getEditorial().trim().isEmpty()) {
            throw new Exception("La editorial no puede estar vacía.");
        }

        if (libro.getAnioEdicion() <= 0) {
            throw new Exception("El año de edición debe ser mayor que cero.");
        }

        if (libro.getFormato() == null || libro.getFormato().trim().isEmpty()) {
            throw new Exception("El formato no puede estar vacío.");
        }

        if (libro.getIsbn() == null || libro.getIsbn().trim().isEmpty()) {
            throw new Exception("El ISBN no puede estar vacío.");
        }

        if (libro.getCapitulos() == null || libro.getCapitulos().isEmpty()) {
            throw new Exception("El libro debe tener al menos un capítulo.");
        }

        if (libro.getStock() < 0) {
            throw new Exception("El stock no puede ser negativo.");
        }

        if (buscarLibro(libro.getIsbn()) != null) {
            throw new Exception("Ya existe un libro con ese ISBN.");
        }

        libros.add(libro);
    }

    // BUSCAR LIBRO
    public Libro buscarLibro(String isbn) {

        Iterator<Libro> iterador = libros.iterator();

        while (iterador.hasNext()) {

            Libro libro = iterador.next();

            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }

        return null;
    }

    // BUSCAR LIBRO CON EXCEPCIÓN
    private Libro obtenerLibro(String isbn) throws Exception {

        Libro libro = buscarLibro(isbn);

        if (libro == null) {
            throw new Exception("No se encontró un libro con el ISBN: " + isbn);
        }

        return libro;
    }

    // MOSTRAR TODOS LOS LIBROS
    public String mostrarLibros() {

        if (libros.isEmpty()) {
            return "No hay libros registrados.";
        }

        String resultado = "";
        Iterator<Libro> iterador = libros.iterator();

        while (iterador.hasNext()) {

            Libro libro = iterador.next();

            resultado += libro.toString();
            resultado += "\n";
            resultado += "--------------------------------";
            resultado += "\n";
        }

        return resultado;
    }

    // VENDER LIBRO
    public void venderLibro(String isbn) throws Exception {

        Libro libro = obtenerLibro(isbn);

        libro.vender();
    }

    // CONSULTAR STOCK
    public int consultarStock(String isbn) throws Exception {

        Libro libro = obtenerLibro(isbn);

        return libro.getStock();
    }

    // AGREGAR PROVEEDOR
    public void agregarProveedor(String proveedor) throws Exception {

        if (proveedor == null || proveedor.trim().isEmpty()) {
            throw new Exception(
                    "El proveedor no puede estar vacío.");
        }

        proveedores.add(proveedor);
    }

    // MOSTRAR PROVEEDORES
    public String mostrarProveedores() {
        if (proveedores.isEmpty()) {
            return "No hay proveedores registrados.";
        }

        String resultado = "";
        Iterator<String> iterador = proveedores.iterator();

        while (iterador.hasNext()) {
            resultado += iterador.next();
            resultado += "\n";
        }

        return resultado;
    }

    // REALIZAR ENCARGO
    public void realizarEncargo(String isbn, String cliente) throws Exception {
        Libro libro = obtenerLibro(isbn);

        if (libro.getStock() > 0) {

            throw new Exception("El libro tiene stock disponible. "
                    + "No es necesario realizar un encargo.");
        }

        if (cliente == null ||
                cliente.trim().isEmpty()) {

            throw new Exception(
                    "El nombre del cliente no puede estar vacío."
            );
        }

        String encargo = "Cliente: " + cliente
                        + "\nLibro: " + libro.getTitulo()
                        + "\nISBN: " + libro.getIsbn()
                        + "\nEditorial: " + libro.getEditorial()
                        + "\nProveedor solicitado: "
                        + buscarProveedor(libro.getEditorial());

        encargos.add(encargo);
    }

    // BUSCAR PROVEEDOR
    private String buscarProveedor(String editorial) {

        Iterator<String> iterador = proveedores.iterator();

        if (iterador.hasNext()) {
            return iterador.next();
        }

        return "No hay proveedor registrado.";
    }

    // MOSTRAR ENCARGOS
    public String mostrarEncargos() {
        if (encargos.isEmpty()) {
            return "No hay encargos registrados.";
        }

        String resultado = "";
        Iterator<String> iterador = encargos.iterator();

        while (iterador.hasNext()) {

            resultado += iterador.next();
            resultado += "\n";
            resultado += "--------------------------------";
            resultado += "\n";
        }

        return resultado;
    }

    // SERIALIZACIÓN
    public void guardar() throws IOException {
        ObjectOutputStream salida = null;

        try {
            salida = new ObjectOutputStream(new FileOutputStream("libreria.dat"));

            salida.writeObject(this);

        } finally {
            if (salida != null) {
                salida.close();
            }
        }
    }

    // DESERIALIZACIÓN
    public static Libreria cargar() throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = null;

        try {
            entrada = new ObjectInputStream(new FileInputStream("libreria.dat"));

            return (Libreria) entrada.readObject();

        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }
}