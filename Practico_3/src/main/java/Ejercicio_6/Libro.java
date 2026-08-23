package Ejercicio_6;

/*
* Se desea diseñar un programa que registre, y persista en archivos, libros (técnicos y novelas)
* para una librería y permita buscarlos, venderlos y verificar su stock.

Las novelas se clasifican como de ciencia ficción, romance, misterio, juveniles y policiales.
* Los libros técnicos se clasifican como de ingeniería, ciencias naturales o ciencias sociales.

Cada libro tiene un título, uno o más autores, una editorial, un año de edición y formato
* (tapas duras o edición económica). Los libros tienen además un código ISBN y capítulos,
* los que tratan una o más materias (en los técnicos) o es una simple división (en las novelas).

La librería obtiene los libros por medio de proveedores que representan a una o más editoriales.
* De cada libro se tiene un stock (que puede ser cero). Al venderse un libro, el stock se actualiza.
* Si un cliente requiere un libro cuyo stock es cero, se puede realizar un encargo por parte del cliente.
* Esto significa que se pide el libro a un proveedor de la editorial del libro.
* */

import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable {

    private String titulo;
    private ArrayList<String> autores;
    private String editorial;
    private int anioEdicion;
    private String formato;
    private String isbn;
    private ArrayList<String> capitulos;
    private int stock;

    public Libro(String titulo, ArrayList<String> autores,
                 String editorial, int anioEdicion,
                 String formato, String isbn,
                 ArrayList<String> capitulos, int stock) throws Exception{

        setTitulo(titulo);
        setAutores(autores);
        setEditorial(editorial);
        setAnioEdicion(anioEdicion);
        setFormato(formato);
        setIsbn(isbn);
        setCapitulos(capitulos);
        setStock(stock);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws Exception{

        if (titulo == null || titulo.trim().isEmpty())
            throw new Exception("El titulo del libro no puede estar vacío");

        this.titulo = titulo;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) throws Exception {

        if (autores == null || autores.isEmpty())
            throw new Exception("Los autores no puede estar nulo");

        this.autores = autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) throws Exception{

        if (editorial == null || editorial.trim().isEmpty())
            throw new Exception("La editorial no puede estar vacía");

        this.editorial = editorial;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) throws Exception{

        if (anioEdicion <= 0)
            throw new Exception("Error. Tienes que especificar un año valido");

        this.anioEdicion = anioEdicion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) throws Exception{

        if (formato == null || formato.trim().isEmpty())
            throw new Exception("El formato no puede estar vacío");

        this.formato = formato;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws Exception{

        if (isbn == null || isbn.trim().isEmpty())
            throw new Exception("Error.El identificador de libro no puede estar vacío");

        this.isbn = isbn;
    }

    public ArrayList<String> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(ArrayList<String> capitulos) throws Exception{

        if (capitulos == null || capitulos.isEmpty())
            throw new Exception("Error en la implementación del capitulo del libro");

        this.capitulos = capitulos;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws Exception{

        if (stock < 0)
            throw new Exception("Error. No puedes tener menos tantos libros");

        this.stock = stock;
    }

    public void vender() throws Exception {

        if (stock <= 0) {
            throw new Exception("No hay stock disponible.");
        }

        stock--;
    }

    public boolean hayStock() {
        return stock > 0;
    }

    @Override
    public String toString() {

        return "ISBN: " + isbn
                + "\nTítulo: " + titulo
                + "\nAutores: " + autores
                + "\nEditorial: " + editorial
                + "\nAño de edición: " + anioEdicion
                + "\nFormato: " + formato
                + "\nCapítulos: " + capitulos
                + "\nStock: " + stock;
    }
}
