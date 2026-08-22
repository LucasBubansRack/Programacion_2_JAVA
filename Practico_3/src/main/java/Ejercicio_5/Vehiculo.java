package Ejercicio_5;

import java.io.Serializable;

public class Vehiculo implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private int plazas;   // Cantidad de personas que puede transportar.

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String marca, String modelo, String color, int plazas) throws Exception{

        setMatricula(matricula);
        setMarca(marca);
        setModelo(modelo);
        setColor(color);
        setPlazas(plazas);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws Exception{

        if (matricula == null || matricula.trim().isEmpty())
            throw new Exception("La matricula no puede estar vacía");

        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws Exception{

        if (marca == null || marca.trim().isEmpty())
            throw new Exception("La marco no puede estar vacía");

        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) throws Exception{

        if (modelo == null || modelo.trim().isEmpty())
            throw new Exception("El modelo no puede estar vacío");

        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws Exception{

        if (color == null || color.trim().isEmpty())
            throw new Exception("El color no puede estar vacío");

        this.color = color;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) throws Exception{

        if (plazas <= 0)
            throw new Exception("La cantidad de plazas debe ser mayor a 0");

        this.plazas = plazas;
    }

    @Override
    public String toString() {
        return "\nVehiculo {" +
                "\nMatricula: '" + matricula + '\'' +
                "\nMarca: " + marca + '\'' +
                "\nModelo: " + modelo + '\'' +
                "\nColor: " + color + '\'' +
                "\nPlazas: " + plazas +
                '}';
    }
}
