package Ejercicio_2;

import java.util.ArrayList;

public class PruebaIterator {
    public static void main(String[] args) {

        try {
            ArrayList<Alumno> alumnos = new ArrayList<>();

            Alumno alumno = new Alumno(1, "Juan", 8.5f);

            alumno.alta(alumnos);
            new Alumno(2, "Pedro", 7.2f).alta(alumnos);
            new Alumno(3, "Maria", 9.1f).alta(alumnos);

            System.out.println("RECORRIDO:");
            alumno.recorrer(alumnos);

            System.out.println("\nBUSQUEDA:");
            Alumno encontrado = alumno.buscar(alumnos, 2);

            if (encontrado != null)
                System.out.println(encontrado);

            System.out.println("\nBAJA:");
            alumno.baja(alumnos, 2);

            alumno.recorrer(alumnos);

        } catch (Exception e){
                System.out.println(e.getMessage());
            }
    }
}
