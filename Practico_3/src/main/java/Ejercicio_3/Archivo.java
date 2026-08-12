package Ejercicio_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
* Escribir un programa que ingrese un string y la ruta correspondiente
* a un archivo de texto y emita un mensaje indicando si dicho string
* está o no en el archivo. Por ejemplo en el archivo se encuentra el
* texto “Hoy es viernes y esta soleado”, el usuario ingresa el texto
* “viernes” y la respuesta del programa debe ser que se encuentra el
* texto en el archivo.
* */

public class Archivo {

    public boolean buscarTexto(String ruta, String texto) throws Exception{
        if (ruta == null || ruta.isEmpty())
            throw new Exception("La ruta no puede estar vacía.");

        if (texto == null || texto.isEmpty())
            throw new Exception("El texto no puede estar vacío");

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));

            String linea;

            while ((linea = lector.readLine()) != null){
                if (linea.contains(texto)){
                    lector.close();
                    return true;
                }
            }
            lector.close();
            return false;
        }catch (IOException e){
            throw new Exception("No se pudo abrir o leer el archivo.");
        }
    }
}
