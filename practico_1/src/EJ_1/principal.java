package EJ_1;

import java.util.Scanner;

/*
   Escribe un programa que tome 3 números enteros introducidos por el usuario mediante el teclado y
    determine cuántos de dichos números son diferentes, el promedio, la suma de todos, el producto del
    mayor por el menor y si el número restante es divisible por 3.
 */
public class principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = 3;
        int numero[] = new int[num];
        double suma = 0;

        System.out.println("INGRESO DE NUMEROS");
        for (int i = 0; i < 3; i++) {
            System.out.print("[" + (i+1) + "]_Ingrese un numero: ");
            numero[i] = sc.nextInt();

            suma += numero[i];
        }

        int numDiferent = 0;
        for (int i = 0; i < 2; i++) {
            if (numero[2] != numero[i]) {
                numDiferent += 1;
            }
        }

        System.out.println("Numeros diferentes ingresados: " + numDiferent);
        System.out.println("Promedio: " + suma/num);
        System.out.println("Suma: " + suma);


    }
}
