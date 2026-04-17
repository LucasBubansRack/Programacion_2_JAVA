package EJ_7;

/*
    Escribe el programa para un juego que consista en averiguar un número. El programa nos indicará
    cada vez si el número introducido es mayor o menor que la constante almacenada que tendremos
    que averiguar. Cuando se descubre el numero mostrara un mensaje de felicitación.
* */

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class principal_7 {

    public static void main(){

        Scanner sc = new Scanner(System.in);
        int numJarcordiado = ThreadLocalRandom.current().nextInt(1, 101);;
        int numUsuario;
        int intentos = 10;

        System.out.println("\t\tBIEN VENIDO AL JUEGO");
        System.out.println("Tienes que ir tirando numeros a tu eleccion");
        System.out.println("hasta adivinar el numero que eligio la maquina");
        do {
            System.out.print("Ingrese un numero: ");
            numUsuario = sc.nextInt();

            if (numUsuario < numJarcordiado) {
                System.out.println("El numero que ingresaste es menor al que tenes que adivinar");
            }else if (numUsuario > numJarcordiado){
                System.out.println("El numero que ingresaste es mayor al que tenes que adivinar");
            }
            intentos--;
        }while ((numUsuario != numJarcordiado) && intentos != 0);

        if (intentos == 0) {
            System.out.println("Que mal te has quedado sin intentos :(");
            System.out.println("El numero era: " + numJarcordiado);
        }else {
            System.out.println("Que bien adivinaste el numero selecto por la maquina, numero = " + numJarcordiado);
        }
    }
}
