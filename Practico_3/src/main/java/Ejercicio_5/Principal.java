package Ejercicio_5;

/*
* Se desea diseñar un programa para registrar y persistir en archivos la información
* de las reservas de una empresa dedicada al alquiler de automóviles, teniendo en cuenta que:

De cada cliente se desean almacenar su DNI, nombre y apellido, dirección y teléfono.
* Además dos clientes se diferencian por un código único.

Un determinado cliente puede tener en un momento dado hechas varias reservas.

Una reserva la realiza un único cliente pero puede involucrar varios autos.

Es importante registrar la fecha de inicio y final de la reserva, el precio del alquiler de
* cada uno de los autos, el precio total de la reserva y un indicador de si el auto o los
* autos han sido entregados.

De cada auto se requiere la matricula, la marca, el modelo, el color y las plazas
* (cantidad de personas que puede transportar).
* */

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    private static final String ARCHIVO_CLIENTES = "clientes.dat";
    private static final String ARCHIVO_AUTOS = "autos.dat";
    private static final String ARCHIVO_RESERVAS = "reservas.dat";

    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Vehiculo> autos = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        cargarDatos();

        int opcion = 0;

        while (opcion != 7){

            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(
                                """
                                ===== ALQUILER DE AUTOMÓVILES =====

                                1. Registrar cliente
                                2. Registrar auto
                                3. Registrar reserva
                                4. Mostrar clientes
                                5. Mostrar autos
                                6. Mostrar reservas
                                7. Salir

                                Seleccione una opción:
                                """
                        )
                );

                switch (opcion){
                    case 1:
                        altaCliente();
                        break;

                    case 2:
                        altaAuto();
                        break;

                    case 3:
                        altaReserva();
                        break;

                    case 4:
                        mostrarClientes();
                        break;

                    case 5:
                        mostrarAutos();
                        break;

                    case 6:
                        mostrarReservas();
                        break;

                    case 7:
                        guardarDatos();
                        JOptionPane.showMessageDialog(null, "Programa finalizado.");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void altaCliente() throws Exception{

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del cliente: "));

        if (buscarCliente(codigo) != null)
            throw new Exception("Ya existe un cliente con ese código.");

        int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI: "));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido: ");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección: ");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono: ");

        Cliente cliente = new Cliente(codigo, dni, nombre, apellido, direccion, telefono);

        clientes.add(cliente);

        JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");
    }

    private static void altaAuto() throws Exception{

        String matricula = JOptionPane.showInputDialog("Ingrese la matricula del auto: ");

        if (buscarAuto(matricula) != null)
            throw new Exception("Ya existe un auto con esa matricula.");

        String marca = JOptionPane.showInputDialog("Ingrese la marca: ");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo: ");
        String color = JOptionPane.showInputDialog("Ingrese el color: ");
        int plazas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de plazas: "));

        Vehiculo auto = new Vehiculo(matricula, marca, modelo, color, plazas);

        autos.add(auto);

        JOptionPane.showMessageDialog(null,"Auto registrado correctamente.");
    }

    private static void altaReserva() throws Exception{

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del cliente: "));

        Cliente cliente = buscarCliente(codigo);

        if (cliente == null)
            throw new Exception("No existe un cliente con ese código");

        LocalDate fechaInicio = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de inicio (AAAA-MM-DD): "));
        LocalDate fechaFin = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de fin (AAAA-MM-DD): "));

        Reserva reserva = new Reserva(cliente, fechaInicio, fechaFin);

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de autos: "));

        if (cantidad <= 0)
            throw new Exception("La reserva debe tener al menos un auto.");

        for (int i = 0; i < cantidad; i++) {

            String matricula = JOptionPane.showInputDialog("Ingrese la matricula del auto " + (i + 1) + ": ");

            Vehiculo auto = buscarAuto(matricula);

            if (auto == null)
                throw new Exception("No existe un auto con esa matricula.");

            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del alquiler del auto: "));


            DetalleReserva detalle = new DetalleReserva(auto, precio);
            reserva.agregarDetalle(detalle);
        }

        reservas.add(reserva);

        JOptionPane.showMessageDialog(null, "Reserva registrada correctamente.\n" +
                "Precio total: $" + reserva.calcularPrecioTotal());
    }

    private static Cliente buscarCliente(int codigo) {

        for (Cliente cliente : clientes) {

            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }

        return null;
    }

    private static Vehiculo buscarAuto(String matricula) {

        for (Vehiculo auto : autos) {

            if (auto.getMatricula().equalsIgnoreCase(matricula)) {
                return auto;
            }
        }

        return null;
    }

    private static void mostrarClientes() {

        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");

        } else {
            StringBuilder texto = new StringBuilder();

            for (Cliente cliente : clientes) {
                texto.append(cliente).append("\n\n");
            }

            JOptionPane.showMessageDialog(null, texto.toString(),
                    "Clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void mostrarAutos() {

        if (autos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay autos registrados.");

        } else {
            StringBuilder texto = new StringBuilder();

            for (Vehiculo auto : autos)
                texto.append(auto).append("\n\n");

            JOptionPane.showMessageDialog(null, texto.toString(),
                    "Autos", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void mostrarReservas() {

        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reservas registradas.");

        } else {
            StringBuilder texto = new StringBuilder();

            for (Reserva reserva : reservas) {
                texto.append(reserva).append("\n");

                for (DetalleReserva detalle : reserva.getDetalles()) {
                    texto.append("   ").append(detalle).append("\n");
                }

                texto.append("\n");
            }

            JOptionPane.showMessageDialog(null, texto.toString(),
                    "Reservas", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void guardarDatos() {

        try {
            ObjectOutputStream salidaClientes = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES));

            salidaClientes.writeObject(clientes);
            salidaClientes.close();

            ObjectOutputStream salidaAutos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_AUTOS));

            salidaAutos.writeObject(autos);
            salidaAutos.close();

            ObjectOutputStream salidaReservas = new ObjectOutputStream(new FileOutputStream(ARCHIVO_RESERVAS));

            salidaReservas.writeObject(reservas);
            salidaReservas.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: "
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private static void cargarDatos() {

        try {
            ObjectInputStream entradaClientes = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES));

            clientes = (ArrayList<Cliente>) entradaClientes.readObject();

            entradaClientes.close();

        } catch (Exception e) {
            clientes = new ArrayList<>();
        }

        try {
            ObjectInputStream entradaAutos = new ObjectInputStream(new FileInputStream(ARCHIVO_AUTOS));

            autos = (ArrayList<Vehiculo>) entradaAutos.readObject();

            entradaAutos.close();

        } catch (Exception e) {
            autos = new ArrayList<>();
        }

        try {
            ObjectInputStream entradaReservas = new ObjectInputStream(new FileInputStream(ARCHIVO_RESERVAS));

            reservas = (ArrayList<Reserva>) entradaReservas.readObject();

            entradaReservas.close();

        } catch (Exception e) {
            reservas = new ArrayList<>();
        }
    }
}