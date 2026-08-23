package Ejercicio_6;

import java.util.ArrayList;

public class Novela extends Libro{

    private String tipo;

    public Novela(String titulo, ArrayList<String> autores, String editorial,
                  int anioEdicion, String formato, String isbn, ArrayList<String> capitulos,
                  int stock, String tipo) throws Exception {

        super(titulo, autores, editorial, anioEdicion, formato, isbn, capitulos, stock);

        setTipo(tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) throws Exception{

        if (tipo == null || tipo.trim().isEmpty())
            throw new Exception("Error. Tipo de novela no puede estar vacío");

        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de novela: " + tipo;
    }
}
