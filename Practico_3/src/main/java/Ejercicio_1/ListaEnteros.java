package Ejercicio_1;

import java.util.ArrayList;

public class ListaEnteros {

    private ArrayList<Integer> lista;

    public ListaEnteros() {
        lista = new ArrayList<>();
    }

    public void altaEntero(int numero) throws Exception{
        if (lista.contains(numero))
            throw new Exception("El numero " + numero + " ya existe.");

        lista.add(numero);
    }

    public void bajaNumero(int numero) throws Exception{
        if (!lista.remove(Integer.valueOf(numero)))
            throw new Exception("El numero " + numero + " no existe.");
    }

    public int buscarNumero(int numero) throws Exception{

        int posicion = lista.indexOf(numero);

        if (posicion == -1)
            throw new Exception("El numero " + numero + " no se encuentra.");
        return posicion;
    }

    public void recorrerNumeros() throws Exception{
        if (lista.isEmpty())
            throw new Exception("La lista esta vacía.");

        for (Integer numero : lista)
            System.out.println(numero);
    }
}
