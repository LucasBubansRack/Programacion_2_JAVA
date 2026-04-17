package EJ_6;

/*
    Escribe un programa que calcule la suma de todos los números múltiplos de 5 comprendidos entre
    dos enteros positivos leídos por teclado
* */

import java.util.Scanner;

public class principal_6 {

    public static void main(){

        Scanner sc = new Scanner(System.in);
        int num1, num2;
        double suma = 0;

        System.out.print("Ingrese un numero: ");
        num1 = sc.nextInt();
        System.out.print("Ingrese un segundo numero: ");
        num2 = sc.nextInt();

        for (int i = num1; i <= num2; i++) {
            if (i % 5 == 0) {
                suma += i;
            }
        }
        System.out.println("La suma de todos los multiplos de 5 da: " + suma);
    }
}
