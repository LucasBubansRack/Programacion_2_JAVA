package EJ_3;

import java.util.Scanner;

/*
    Escribe un programa que calcule el factorial de n donde n es un número entero mayor o igual que
    cero dado por el usuario.
* */
public class principal_3 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n;
        int factorial = 1;

        do {
            System.out.print("Ingrese un numero mayor o igual a 0: ");
            n = sc.nextInt();
        }while (n < 0);


        for (int i = 1; i <= n ; i++) {
            factorial *= i;
        }

        System.out.println("El factorial de " + n + " es " + factorial);
    }
}
