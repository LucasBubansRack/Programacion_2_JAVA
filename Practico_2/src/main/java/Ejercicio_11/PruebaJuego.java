package Ejercicio_11;

import java.util.Random;
import java.util.Scanner;

public class PruebaJuego {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Craps craps = new Craps();

        int saldoBanco = 1000;
        int apuesta;
        int suma;
        int resultado;
        int punto;

        System.out.println("=================================");
        System.out.println("          JUEGO DE CRAPS");
        System.out.println("=================================");

        System.out.println("Saldo disponible: $ " + saldoBanco);

        do {

            System.out.print("Ingrese su apuesta: $");
            apuesta = entrada.nextInt();

            if (apuesta <= 0 || apuesta > saldoBanco) {
                System.out.println("Apuesta invalida.");
                System.out.println("La apuesta debe ser mayor que 0 y menor o igual al saldo.");
            }

        } while (apuesta <= 0 || apuesta > saldoBanco);


        // RONDA 1
        System.out.println("\n========== RONDA 1 ==========");

        suma = craps.tirarDados();

        resultado = craps.primerTiro(suma);


        if (resultado == 1) {

            saldoBanco += apuesta;

            System.out.println("¡Ganaste!");
            System.out.println("Nuevo saldo: $ " + saldoBanco);

            charla();

        }

        else if (resultado == 2) {

            saldoBanco -= apuesta;

            System.out.println("Perdiste.");
            System.out.println("Nuevo saldo: $ " + saldoBanco);

            if (saldoBanco == 0) {
                System.out.println("Lo siento. Se quedo sin fondos!");
            }

            else {
                charla();
            }

        }

        else {

            // RONDA 2
            punto = suma;

            System.out.println("\n========== RONDA 2 ==========");
            System.out.println("El punto es: " + punto);
            System.out.println("Debe volver a salir " + punto + " antes de sacar un 7.");

            boolean gano = craps.jugarPunto(punto);


            if (gano) {

                saldoBanco += apuesta;

                System.out.println("¡Ganaste!");
                System.out.println("Nuevo saldo: $ " + saldoBanco);

                charla();

            }

            else {

                saldoBanco -= apuesta;

                System.out.println("Perdiste.");
                System.out.println("Nuevo saldo: $ " + saldoBanco);

                if (saldoBanco == 0) {
                    System.out.println("Lo siento. Se quedo sin fondos!");
                }

                else {
                    charla();
                }
            }
        }

        entrada.close();
    }


    public static void charla() {

        Random random = new Random();

        String[] mensajes = {
                "Oh, se esta yendo a la quiebra, verdad?",
                "Oh, vamos, arriesguese!",
                "La hizo en grande. Ahora es tiempo de cambiar sus fichas por efectivo!"
        };

        int indice = random.nextInt(mensajes.length);

        System.out.println(mensajes[indice]);
    }
}