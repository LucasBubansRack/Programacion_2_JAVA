package Ejercicio_1;

import java.util.ArrayList;

public class ListaAlumnos {

    private final ArrayList<Alumno> lista;

    public ListaAlumnos() {
        lista = new ArrayList<>();
    }

    public void altaAlumno(Alumno alumno) throws Exception{
        if (buscarInterno(alumno.getLegajo()) != null)
            throw new Exception("Ya existe un alumno con ese legajo");

        lista.add(alumno);
    }

    public void bajaAlumno(int legajo) throws Exception{
        Alumno alumno = buscarInterno(legajo);

        if (alumno == null)
            throw new Exception("Alumno inexistente");

        lista.remove(alumno);
    }

    public Alumno buscarAlumno(int legajo) throws Exception{
        Alumno alumno = buscarInterno(legajo);

        if (alumno == null)
            throw new Exception("Alumno inexistente");

        return alumno;   // Muestra el toString de Alumno.
    }

    private Alumno buscarInterno(int legajo) throws Exception{
        for (Alumno alumno : lista){
            if (alumno.getLegajo() == legajo)
                return alumno;
        }
        return null;
    }

    public void recorrerAlumnos() throws Exception{
        if (lista.isEmpty())
            throw new Exception("No hay alumnos cargados.");  // Si la lista está vacía

        for (Alumno alumno : lista)
            System.out.println(alumno);
    }
}
