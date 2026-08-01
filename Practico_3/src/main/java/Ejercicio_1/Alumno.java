package Ejercicio_1;

/*
* Usando ArayList escriba un programa que permita hacer altas, bajas, búsqueda y recorridos
 a) en una lista de enteros
 b) en una lista de objetos Alumno (cree la clase)
* */

public class Alumno {

    private int legajo;
    private String nombre;
    private double promedio;

    public Alumno() {
    }

    public Alumno(int legajo, String nombre, double promedio) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                " legajo: " + legajo +
                ", nombre: '" + nombre + '\'' +
                ", promedio: " + promedio +
                '}';
    }
}
