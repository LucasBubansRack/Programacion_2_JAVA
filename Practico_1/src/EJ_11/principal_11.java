package EJ_11;

/*
    Escribe una aplicación que reciba como entrada un entero que contenga sólo dígitos 0 y 1 (es decir,
    un entero binario), y que imprima su equivalente decimal. [Sugerencia: use los operadores residuo y
    división para elegir los dígitos del número binario uno a la vez, de derecha a izquierda. En el
    sistema numérico binario, el dígito más a la derecha tiene un valor posicional de 1, el siguiente
    dígito a la izquierda tiene un valor posicional de 2, luego 4, luego 8, etcétera. El equivalente
    decimal del número binario 1101 es 1 * 1 + 0 * 2 + 1 * 4 + 1 * 8 = 13].
* */

import java.util.Scanner;

public class principal_11 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int numBinario;
        int numDecimal = 0;
        int potencia = 0;

        System.out.print("Ingrese un numero entero binario: ");
        numBinario = sc.nextInt();

        if (!String.valueOf(numBinario).matches("[01]+")) {
            System.out.println("Error: solo se permiten 0 y 1");
        }else {
            while (numBinario > 0){
                int digito = numBinario % 10; // Ultimo digito

                numDecimal += digito * (int)Math.pow(2, potencia);

                numBinario = numBinario / 10;  // Elimino el ultimo digito
                potencia++;
            }

            System.out.println(" ");
            System.out.println("El binario a decimal es: " + numDecimal);
        }
    }
}
