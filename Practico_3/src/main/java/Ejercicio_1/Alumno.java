package Ejercicio_1;

/*
* Usando ArayList escriba un programa que permita hacer altas, bajas, búsqueda y recorridos
 a) en una lista de enteros
 b) en una lista de objetos Alumno (cree la clase)
* */

import java.util.ArrayList;
import java.util.Iterator;

public class Alumno {

    private int legajo;
    private String nombre;
    private float promedio;

    public Alumno() {
    }

    public Alumno(int legajo, String nombre, float promedio) throws Exception{
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
            throw new Exception("Legajo invalido");

        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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

    public void altaAlumno(ArrayList<Alumno> alumnos) throws Exception{
        if (buscarAlumno(alumnos, legajo) != null)
            throw new Exception("Ya existe un alumno con ese legajo");

        alumnos.add(this);
    }

    public Alumno buscarAlumno(ArrayList<Alumno> alumnos, int legajo) {
        Iterator<Alumno> iterator = alumnos.iterator();

        while (iterator.hasNext()){
            Alumno alumno = iterator.next();

            if (alumno.getLegajo() == legajo)
                return alumno;
        }

        return null;
    }

    public void bajaAlumno(ArrayList<Alumno> alumnos, int legajo) throws Exception{
        Iterator<Alumno> iterator = alumnos.iterator();

        while (iterator.hasNext()){
            Alumno alumno = iterator.next();

            if (alumno.getLegajo() == legajo) {
                iterator.remove();
                return;
            }
        }

        throw new Exception("No existe un alumno con ese legajo");
    }

    public void recorrer(ArrayList<Alumno> alumnos){
        Iterator<Alumno> iterator = alumnos.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Override
    public String toString() {
        return "Alumno {" +
                " legajo: " + legajo +
                ", nombre: '" + nombre + '\'' +
                ", promedio: " + promedio +
                '}';
    }
}
