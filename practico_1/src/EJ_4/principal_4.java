package EJ_4;

/*
    Escribe un programa que escriba todos los divisores de un número n entero positivo introducido por
    el usuario.
* */

import java.util.Scanner;

public class principal_4 {

    public static void main(){

        Scanner sc = new Scanner(System.in);
        int num;

        do {
            System.out.print("Ingrese un numero entero positivo: ");
            num = sc.nextInt();
        }while (num <= 0);

        System.out.println("Los divisores de " + num + " son:");
        for (int i = num; i > 0; i--) {
            if (num % i == 0) {
                System.out.println("" + i);
            }
        }
    }
}
