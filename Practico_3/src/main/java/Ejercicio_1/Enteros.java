package Ejercicio_1;

import java.util.ArrayList;
import java.util.Iterator;

public class Enteros {

    public void altaEntero(ArrayList<Integer> numeros, int numero) throws Exception{
        if (buscarNumero(numeros, numero) != null)
            throw new Exception("El numero " + numero + " ya existe.");

        numeros.add(numero);
    }

    public Integer buscarNumero(ArrayList<Integer> numeros , int numero) {
        Iterator<Integer> iterator = numeros.iterator();

        while (iterator.hasNext()){
            Integer actual = iterator.next();

            if (actual == numero)
                return actual;
        }
        return null;
    }

    public void bajaNumero(ArrayList<Integer> numeros , int numero) throws Exception{
        Iterator<Integer> iterator = numeros.iterator();

        while (iterator.hasNext()){
            Integer actual = iterator.next();

            if (actual == numero){
                iterator.remove();
                return;
            }
        }

        throw new Exception("El numero no existe");
    }

    public void recorrerNumeros(ArrayList<Integer> numeros) {
        Iterator<Integer> iterator = numeros.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
