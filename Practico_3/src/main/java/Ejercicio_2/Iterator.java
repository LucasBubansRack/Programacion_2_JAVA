package Ejercicio_2;

/*
* ¿Qué es un iterador? (iterator). Muestre cómo se usa,
* haciendo altas, bajas, recorridos y búsquedas en listas
* implementadas con ArrayList.
* */

import java.util.ArrayList;

public class Iterator {

    private int legajo;
    private String nombre;
    private float promedio;

    public Iterator() {
    }

    public Iterator(int legajo, String nombre, float promedio) throws Exception{
        if (legajo <= 0)
            throw new Exception("El legajo debe ser mayor a 0");

        if (promedio < 0 || promedio > 10)
            throw new Exception("Promedio invalido");

        this.legajo = legajo;
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) throws Exception{
        if (legajo <= 0)
            throw new Exception("EL legajo debe ser mayor a 0");

        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) throws Exception{
        if (promedio < 0 || promedio > 10)
            throw new Exception("Promedio invalido");

        this.promedio = promedio;
    }

    public void alta(ArrayList<Iterator> alumnos) throws Exception{
        if (buscar(alumnos, legajo) != null)
            throw new Exception("Ya existe un alumno con ese legajo.");
        alumnos.add(this);
    }

    public void baja(ArrayList<Iterator> alumnos) throws Exception{
        java.util.Iterator<Iterator> iterator = alumnos.iterator();

        while (iterator.hasNext()){
            Iterator alumno = iterator.next();

            if (alumno.getLegajo() == legajo){
                iterator.remove();
                return;
            }
        }
        throw new Exception("No existe un alumno con ese legajo.");
    }

    public Iterator buscar(ArrayList<Iterator> alumnos, int legajo) {
        java.util.Iterator<Iterator> iterator = alumnos.iterator();

        while (iterator.hasNext()){
            Iterator alumno = iterator.next();

            if (alumno.getLegajo() == legajo)
                return alumno;
        }
        return null;
    }

    public void recorrer(ArrayList<Iterator> alumnos) {
        java.util.Iterator<Iterator> iterator = alumnos.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public String toString() {
        return "Alumno { " +
                "legajo: " + legajo +
                ", nombre: '" + nombre + '\'' +
                ", promedio: " + promedio +
                '}';
    }
}
