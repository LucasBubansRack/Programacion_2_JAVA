package Ejercicio_5;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    public int codigo;
    private int dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Cliente() {
    }

    public Cliente(int codigo, int dni, String nombre, String apellido,
                   String direccion, String telefono) throws Exception{

        setCodigo(codigo);
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
        setDireccion(direccion);
        setTelefono(telefono);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception{

        if (codigo <= 0)
            throw new Exception("El código de cliente debe ser mayor que 0");

        this.codigo = codigo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) throws Exception{

        if (dni <= 0)
            throw new Exception("El DNI del cliente no puede ser menor o igual que 0");

        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception{

        if (nombre == null || nombre.trim().isEmpty())
            throw new Exception("El nombre no puede estar vacío");

        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws Exception{

        if (apellido == null || apellido.trim().isEmpty())
            throw new Exception("El apellido no puede estar vacío");

        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) throws Exception{

        if (direccion == null || direccion.trim().isEmpty())
            throw new Exception("La dirección no puede estar vacía");

        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws Exception{

        if (telefono == null || telefono.trim().isEmpty())
            throw new Exception("El teléfono no puede estar vacío");

        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "\nCliente{" +
                "\nCódigo: " + codigo +
                "\nDNI: " + dni +
                "\nNombre: '" + nombre + " " + apellido +
                "\nDirección: '" + direccion +
                "\nTeléfono: " + telefono +
                '}';
    }
}