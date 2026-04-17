package EJ_5;

/*
    Escribe un programa que escriba la tabla de multiplicar de cualquier número entero dado por el
    usuario, entre 1 y 10
* */

import java.util.Scanner;

public class principal_5 {

    public static void main(){

        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.print("Ingrese un numero entero: ");
        numero = sc.nextInt();

        System.out.println(" ");
        System.out.println("LA TABLA DE MULTIPLICAR DEl " + numero + " ES:");
        for (int i = 0; i < 10; i++) {
            System.out.println("\t\t\t" + numero + " * " + (i+1) + " = " + numero * (i+1));
        }
    }
}
