package Ejercicio_6;

import java.util.ArrayList;

public class Tecnico extends Libro{

    private String tipo;
    private ArrayList<String> materias;

    public Tecnico(String titulo, ArrayList<String> autores, String editorial, int anioEdicion,
                   String formato, String isbn, ArrayList<String> capitulos,
                   int stock, String tipo, ArrayList<String> materias) throws Exception {

        super(titulo, autores, editorial, anioEdicion, formato, isbn, capitulos, stock);

        setTipo(tipo);
        setMaterias(materias);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) throws Exception{

        if (tipo == null || tipo.trim().isEmpty())
            throw new Exception("Error. El tipo de libro Técnico no puede estar vacío");

        this.tipo = tipo;
    }

    public ArrayList<String> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<String> materias) throws Exception{

        if (materias == null || materias.isEmpty())
            throw new Exception("Error. Las materias en Técnico no puede estar vacío");

        this.materias = materias;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de libro técnico: " + tipo +
                "\nMaterias: " + materias;
    }
}
