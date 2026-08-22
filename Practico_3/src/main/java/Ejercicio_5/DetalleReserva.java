package Ejercicio_5;

import java.io.Serializable;

public class DetalleReserva implements Serializable {

    private Vehiculo auto;
    private double precioAlquiler;
    private boolean entregado;

    public DetalleReserva() {
    }

    public DetalleReserva(Vehiculo auto, double precioAlquiler) throws Exception{

        setAuto(auto);
        setPrecioAlquiler(precioAlquiler);
        this.entregado = false;
    }

    public Vehiculo getAuto() {
        return auto;
    }

    public void setAuto(Vehiculo auto) throws Exception{

        if (auto == null)
            throw new Exception("El auto no puede ser nulo");

        this.auto = auto;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) throws Exception{

        if (precioAlquiler < 0)
            throw new Exception("Error.El precio del alquiler no puede ser negativo");

        this.precioAlquiler = precioAlquiler;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    @Override
    public String toString() {
        return "Auto: " + auto.getMatricula() +
                " | Precio: $" + precioAlquiler +
                " | Entregado: " + (entregado ? "Si" : "No");
    }
}
