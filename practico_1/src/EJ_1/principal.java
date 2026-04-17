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
        int[] numero = new int[num];
        double suma = 0;

        System.out.println("INGRESO DE NUMEROS");
        for (int i = 0; i < 3; i++) {
            System.out.print("[" + (i+1) + "]_Ingrese un numero: ");
            numero[i] = sc.nextInt();

            suma += numero[i];
        }

        int numDiferent = 0;
        for (int i = 1; i < numero.length; i++) {
            if (numero[0] != numero[i]) {
                numDiferent++;
            }
        }

        int numMayor = numero[0], numMenor = numero[0];
        for (int i = 0; i < 3; i++) {
            if (numMayor < numero[i]) {
                numMayor = numero[i];
            } else if (numMenor > numero[i]) {
                numMenor = numero[i];
            }
        }

        System.out.println("Numeros diferentes ingresados: " + numDiferent);
        System.out.println("Promedio: " + suma/num);
        System.out.println("Suma: " + suma);
        System.out.println("El numero mayor ingresado es: " + numMayor);
        System.out.println("El numero menor ingresado es: " + numMenor);
        double producto = numMayor * numMenor;
        System.out.println("Producto entre el mayor y el menor: " + producto);

        if (producto % 3 == 0) {
            System.out.println("El producto del Mayor por el Menor si es divisible por 3");
        }

    }
}
