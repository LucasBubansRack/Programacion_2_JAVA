package Ejercicio_5;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva implements Serializable {

    private Cliente cliente;
    private ArrayList<DetalleReserva> detalles;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva() {
        detalles = new ArrayList<>();
    }

    public Reserva(Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin) throws Exception{

        setCliente(cliente);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);

        this.detalles = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) throws Exception{

        if (cliente == null)
            throw new Exception("Error. La reserva debe tener un cliente");

        this.cliente = cliente;
    }

    public ArrayList<DetalleReserva> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleReserva> detalles) throws Exception{

        if (detalles == null)
            throw new Exception("La lista de detalles no puede ser nula");

        this.detalles = detalles;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) throws Exception{

        if (fechaInicio == null)
            throw new Exception("La fecha de inicio no puede ser nula");

        this.fechaInicio = fechaInicio;

        if (fechaFin != null && fechaInicio.isAfter(fechaFin))
            throw new Exception("La fecha de inicio no puede ser posterior a la fecha de fin");
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) throws Exception{

        if (fechaFin == null)
            throw new Exception("La fecha de fin no puede ser nula");

        if (fechaInicio != null && fechaFin.isBefore(fechaInicio))
            throw new Exception("La fecha de fin no puede ser anterior a la fecha de inicio");

        this.fechaFin = fechaFin;
    }

    public void agregarDetalle(DetalleReserva detalle) throws Exception{

        if (detalle == null)
            throw new Exception("El detalle no puede ser nulo");

        detalles.add(detalle);
    }

    public double calcularPrecioTotal(){

        double total = 0;

        for (DetalleReserva detalle : detalles){
            total += detalle.getPrecioAlquiler();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNombre() +
                " " + cliente.getApellido() +
                " | Fecha inicio: " + fechaInicio +
                " | Fecha fin: " + fechaFin +
                " | Precio total: $" + calcularPrecioTotal();
    }
}
