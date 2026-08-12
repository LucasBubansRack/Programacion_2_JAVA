package Ejercicio_3;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        try {
            System.out.println("Ingrese la ruta del archivo: ");
            String ruta = teclado.nextLine();

            System.out.println("Ingrese el texto a buscar: ");
            String texto = teclado.nextLine();

            Archivo archivo = new Archivo();

            if (archivo.buscarTexto(ruta, texto))
                System.out.println("El texto se encuentra en el archivo.");
            else
                System.out.println("El texto no se encuentra en el archivo.");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        teclado.close();
    }
}