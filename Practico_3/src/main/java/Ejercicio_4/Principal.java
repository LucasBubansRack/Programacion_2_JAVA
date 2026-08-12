package Ejercicio_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Agenda> agenda = new ArrayList<>();

        Agenda contacto = new Agenda();

        String ruta = "agenda.dat";

        int opcion = 0;

        try {

            // CARGAR AGENDA
            try {

                agenda = contacto.deserializar(ruta);
                System.out.println("Agenda cargada correctamente.");

            } catch (Exception e) {
                System.out.println("No existe una agenda guardada. " + "Se creara una nueva.");
            }

            while (opcion != 5) {

                System.out.println("\n===== AGENDA =====");
                System.out.println("1. Registrar contacto");
                System.out.println("2. Eliminar contacto");
                System.out.println("3. Buscar contacto");
                System.out.println("4. Mostrar todos");
                System.out.println("5. Salir");

                System.out.print("Ingrese una opcion: ");

                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre: ");
                        String nombre = teclado.nextLine();

                        System.out.print("Apellido: ");
                        String apellido = teclado.nextLine();

                        System.out.print("Telefono de linea: ");
                        String telefonoLinea = teclado.nextLine();

                        System.out.print("Telefono movil: ");
                        String telefonoMovil = teclado.nextLine();

                        System.out.print("Telefono del trabajo: ");
                        String telefonoTrabajo = teclado.nextLine();

                        System.out.print("Email: ");
                        String email = teclado.nextLine();

                        System.out.print("¿De donde conoce a la persona?: ");
                        String conocidoPor = teclado.nextLine();

                        Agenda nuevoContacto = new Agenda(nombre, apellido, telefonoLinea, telefonoMovil,
                                telefonoTrabajo, email, conocidoPor);

                        nuevoContacto.alta(agenda);
                        System.out.println("Contacto registrado correctamente.");

                        break;

                    case 2:
                        System.out.print("Nombre: ");
                        nombre = teclado.nextLine();

                        System.out.print("Apellido: ");
                        apellido = teclado.nextLine();

                        contacto.baja(agenda, nombre, apellido);

                        System.out.println("Contacto eliminado correctamente.");

                        break;

                    case 3:
                        System.out.print("Nombre: ");
                        nombre = teclado.nextLine();

                        System.out.print("Apellido: ");
                        apellido = teclado.nextLine();

                        Agenda encontrado = contacto.buscar(agenda, nombre, apellido);

                        if (encontrado != null)
                            System.out.println(encontrado);
                        else
                            System.out.println("El contacto no existe.");

                        break;

                    case 4:
                        if (agenda.isEmpty())
                            System.out.println("La agenda esta vacia.");
                        else
                            contacto.recorrer(agenda);

                        break;

                    case 5:
                        contacto.serializar(agenda, ruta);

                        System.out.println("Agenda guardada correctamente.");
                        System.out.println("Programa finalizado.");

                        break;

                    default:

                        System.out.println("Opcion invalida.");
                }
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        teclado.close();
    }
}