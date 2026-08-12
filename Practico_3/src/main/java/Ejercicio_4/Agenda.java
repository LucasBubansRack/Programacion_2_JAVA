package Ejercicio_4;

/*
* Se desea diseñar un programa que permita manipular una agenda mediante
* serialización-deserialización. Cada registro de la agenda cuenta con
* nombre, apellido, teléfono de linea, teléfono móvil, teléfono del trabajo,
* email y un campo que indique de donde conozco a la persona (trabajo,
* universidad, boliche…). Deberá contar con un menú para registrar, eliminar,
* buscar un registro y para mostrar todos.
* */

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Agenda implements Serializable {

    private String nombre;
    private String apellido;
    private String telefonoLinea;
    private String telefonoMovil;
    private String telefonoTrabajo;
    private String email;
    private String conocidoPor;

    public Agenda() {
    }

    public Agenda(String nombre, String apellido, String telefonoLinea,
                  String telefonoMovil, String telefonoTrabajo, String email,
                  String conocidoPor) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.telefonoLinea = telefonoLinea;
        this.telefonoMovil = telefonoMovil;
        this.telefonoTrabajo = telefonoTrabajo;
        this.email = email;
        this.conocidoPor = conocidoPor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefonoLinea() {
        return telefonoLinea;
    }

    public void setTelefonoLinea(String telefonoLinea) {
        this.telefonoLinea = telefonoLinea;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConocidoPor() {
        return conocidoPor;
    }

    public void setConocidoPor(String conocidoPor) {
        this.conocidoPor = conocidoPor;
    }

    public  void alta(ArrayList<Agenda> agenda) throws Exception{
        if (buscar(agenda, nombre, apellido) != null)
            throw new Exception("El contacto ya existe");

        agenda.add(this);
    }

    public Agenda buscar(ArrayList<Agenda> agenda, String nombre, String apellido){
        Iterator<Agenda> iterator = agenda.iterator();

        while (iterator.hasNext()){
            Agenda contacto = iterator.next();

            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido))
                return contacto;
        }

        return null;
    }

    public void baja(ArrayList<Agenda> agenda, String nombre, String apellido) throws Exception{
        Iterator<Agenda> iterator = agenda.iterator();

        while (iterator.hasNext()){
            Agenda contacto = iterator.next();

            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido)){
                iterator.remove();
                return;
            }
        }

        throw new Exception("El contacto no existe");
    }

    public void recorrer(ArrayList<Agenda> agenda){
        Iterator<Agenda> iterator = agenda.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    // SERIALIZACIÓN
    public void serializar(ArrayList<Agenda> agenda, String ruta) throws Exception{

        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta));

            salida.writeObject(agenda);
            salida.close();
        }catch (IOException e){
            throw new Exception("No se pudo guardar la agenda");
        }
    }

    // DESERIALIZACIÓN
    @SuppressWarnings("unchecked")
    public ArrayList<Agenda> deserializar(String ruta) throws Exception{

        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta));

            ArrayList<Agenda> agenda = (ArrayList<Agenda>) entrada.readObject();

            entrada.close();
            return agenda;
        } catch (IOException | ClassNotFoundException e){
            throw new Exception("No se pudo cargar la agenda");
        }
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nTel. linea: " + telefonoLinea +
                "\nTel. móvil: " + telefonoMovil +
                "\nTel. trabajo: " + telefonoTrabajo +
                "\nEmail: " + email +
                "\nConocido por: " + conocidoPor;
    }
}