package EJ_8;

/*
    Escribe un programa que ingrese un número entero positivo N y luego N números enteros e
    imprima la suma de los números que se encuentran entre el mayor de los N números leídos y el
    menor de los N números leídos.
* */

import java.util.Scanner;

public class principal_8 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int numN;

        do {
            System.out.print("Ingrese un numero entero positivo: ");
            numN = sc.nextInt();
        }while (numN <= 0);

        int[] nNumerosIngr = new int[numN];

        for (int i = 0; i < numN; i++) {
            System.out.print("[" + (numN-i) + "]_" + "Ingrese un numero entero: ");
            nNumerosIngr[i] = sc.nextInt();
        }

        int mayor = nNumerosIngr[0], menor = nNumerosIngr[0];
        int posMenor = 0, posMayor = 0;
        for (int i = 0; i < numN; i++) {
            if (mayor < nNumerosIngr[i]) {
                mayor = nNumerosIngr[i];
                posMayor = i;
            }if (menor > nNumerosIngr[i]) {
                menor = nNumerosIngr[i];
                posMenor = i;
            }
        }

        int suma = 0;
        int inicio = Math.min(posMenor, posMayor);
        int fin = Math.max(posMenor, posMayor);
        for (int i = inicio + 1; i < fin; i++) {
            suma += nNumerosIngr[i];
        }

        System.out.println(" ");
        if (fin - inicio <= 1) {
            System.out.println("No se registraron numeros entre el mayor y el menor");
        }else {
            System.out.println("La suma de los numeros entre el menor y el mayor da: " + suma);
        }
    }
}
