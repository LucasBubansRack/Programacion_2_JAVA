package Ejercicio_1;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner num = new Scanner(System.in);

        ListaAlumnos alumnos = new ListaAlumnos();
        ListaEnteros enteros = new ListaEnteros();

        int opcion;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1- Alta entero");
            System.out.println("2- Baja entero");
            System.out.println("3- Buscar entero");
            System.out.println("4- Recorrer enteros");
            System.out.println("5- Alta alumno");
            System.out.println("6- Baja alumno");
            System.out.println("7- Buscar alumno");
            System.out.println("8- Recorrer alumnos");
            System.out.println("0- Salir");
            System.out.print("\nOpcion: ");

            opcion = num.nextInt();

            if (opcion < 0 || opcion > 8)
                System.out.println("Error.Entrada invalida.");

            try{
                switch (opcion){
                    case 1:
                        System.out.print("Número: ");
                        enteros.altaEntero(num.nextInt());
                        break;

                    case 2:
                        System.out.print("Número: ");
                        enteros.bajaNumero(num.nextInt());
                        break;

                    case 3:
                        System.out.print("Numero: ");
                        System.out.println("Posicion: " + enteros.buscarNumero(num.nextInt()));
                        break;

                    case 4:
                        enteros.recorrerNumeros();
                        break;

                    case 5:
                        System.out.print("Legajo: ");
                        int legajo = num.nextInt();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Promedio: ");
                        double prom = num.nextDouble();

                        alumnos.altaAlumno(new Alumno(legajo, nombre, prom));
                        break;

                    case 6:
                        System.out.print("Legajo: ");
                        alumnos.bajaAlumno(sc.nextInt());
                        break;

                    case 7:
                        System.out.print("Legajo: ");
                        System.out.println(alumnos.buscarAlumno(num.nextInt()));
                        break;

                    case 8:
                        alumnos.recorrerAlumnos();
                        break;

                    case 0:
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println("Opción incorrecta.");
                }

            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }while (opcion != 0);

        num.close();
    }
}
