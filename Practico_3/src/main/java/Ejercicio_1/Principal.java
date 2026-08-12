package Ejercicio_1;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        try {

            // LISTA DE ENTEROS

            ArrayList<Integer> numeros = new ArrayList<>();
            Enteros enteros = new Enteros();

            enteros.altaEntero(numeros, 10);
            enteros.altaEntero(numeros, 20);
            enteros.altaEntero(numeros, 30);

            System.out.println("LISTA DE ENTEROS:");
            enteros.recorrerNumeros(numeros);

            System.out.println("\nBUSQUEDA:");
            System.out.println(enteros.buscarNumero(numeros, 20));

            enteros.bajaNumero(numeros, 20);

            System.out.println("\nDESPUES DE LA BAJA:");
            enteros.recorrerNumeros(numeros);


            // LISTA DE ALUMNOS

            ArrayList<Alumno> alumnos = new ArrayList<>();

            Alumno alumno = new Alumno(1, "Juan", 8.5f);

            alumno.altaAlumno(alumnos);
            new Alumno(2, "Pedro", 7.2f).altaAlumno(alumnos);
            new Alumno(3, "Maria", 9.1f).altaAlumno(alumnos);

            System.out.println("\nLISTA DE ALUMNOS:");
            alumno.recorrer(alumnos);

            System.out.println("\nBUSQUEDA:");
            Alumno encontrado = alumno.buscarAlumno(alumnos, 2);

            if (encontrado != null)
                System.out.println(encontrado);

            alumno.bajaAlumno(alumnos, 2);

            System.out.println("\nDESPUES DE LA BAJA:");
            alumno.recorrer(alumnos);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
