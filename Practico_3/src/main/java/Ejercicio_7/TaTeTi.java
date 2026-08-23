package Ejercicio_7;

/*
* Definir una clase llamada TaTeTi que le permita escribir un programa
* completo para que dos jugadores puedan jugar al TaTeTi. La clase debe
* contener una matriz de enteros de 3 filas y 3 columnas que representa
* el tablero. El constructor debe inicializar el tablero vacío con ceros.
* Siempre que el primer jugador coloque una marca, se llenará con 1 la
* casilla especificada y con 5 si juega el jugador 2. Se puede marcar solo
* aquellas casillas que están vacías. Después de cada jugada hay que determinar
* si hay algún jugador ganador o hay empate.

Opcional: Incluir en el programa la posibilidad de que el jugador pueda jugar
* con la computadora.
* */

import javax.swing.*;
import java.util.Random;

public class TaTeTi {

    private static int FILAS = 3;
    private static int COLUMNAS = 3;
    private static int[][] tablero = new int[FILAS][COLUMNAS];

    public static void main(String[] args){

        int opcion;

        do {
            opcion = Integer.parseInt((JOptionPane.showInputDialog("TA-TE-TI\n\n" +
                    "1. Jugador vs Jugador\n" + "2. Jugador vs Computadora\n" +
                    "3. Salir\n\n" + "Ingrese una opción:")));

            if (opcion == 1)
                jugarDosJugadores();
            else if (opcion == 2)
                jugarContraComputadora();
            else if (opcion != 3)
                JOptionPane.showMessageDialog(null, "Opción inválida.");
        } while (opcion != 3);
    }

    public static void inicializarTablero() {
        for (int fila = 0; fila < FILAS; fila++){
            for (int columna = 0; columna < COLUMNAS; columna++){
                tablero[fila][columna] = 0;
            }
        }
    }

    public static String mostrarTablero(){

        // No quise desperdiciar la oportunidad de mostrar el tablero más interactivo y en
        // vez de mostrarlo con (1 y 5) lo muestro con (X y O).

        StringBuilder tableroTexto = new StringBuilder();

        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {

                if (tablero[fila][columna] == 0) {
                    tableroTexto.append("   ");
                } else if (tablero[fila][columna] == 1) {
                    tableroTexto.append(" X ");
                } else {
                    tableroTexto.append(" O ");
                }

                if (columna < 2) {
                    tableroTexto.append("|");
                }
            }

            if (fila < 2) {
                tableroTexto.append("\n---+---+---\n");
            }
        }

        return tableroTexto.toString();
    }

    public static boolean marcar(int fila, int columna, int jugador) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
            return false;
        }

        if (tablero[fila][columna] != 0) {
            return false;
        }

        tablero[fila][columna] = jugador;

        return true;
    }

    public static int ganador() {

        int dimension = tablero.length;

        // Filas
        for (int fila = 0; fila < dimension; fila++) {
            int jugador = tablero[fila][0];

            if (jugador != 0) {
                boolean gana = true;

                for (int columna = 1; columna < dimension; columna++) {
                    if (tablero[fila][columna] != jugador) {
                        gana = false;
                    }
                }

                if (gana) {
                    return jugador;
                }
            }
        }

        // Columnas
        for (int columna = 0; columna < dimension; columna++) {
            int jugador = tablero[0][columna];

            if (jugador != 0) {
                boolean gana = true;

                for (int fila = 1; fila < dimension; fila++) {
                    if (tablero[fila][columna] != jugador) {
                        gana = false;
                    }
                }

                if (gana) {
                    return jugador;
                }
            }
        }

        // Diagonal principal
        int jugador = tablero[0][0];

        if (jugador != 0) {
            boolean gana = true;

            for (int i = 1; i < dimension; i++) {
                if (tablero[i][i] != jugador) {
                    gana = false;
                }
            }

            if (gana) {
                return jugador;
            }
        }

        // Diagonal secundaria
        jugador = tablero[0][dimension - 1];

        if (jugador != 0) {
            boolean gana = true;

            for (int i = 1; i < dimension; i++) {
                if (tablero[i][dimension - 1 - i] != jugador) {
                    gana = false;
                }
            }

            if (gana) {
                return jugador;
            }
        }

        return 0;
    }

    public static boolean tableroLleno(){
        for (int fila = 0; fila < FILAS; fila++){
            for (int columna = 0; columna < COLUMNAS; columna++){

                if (tablero[fila][columna] == 0)
                    return false;
            }
        }
        return true;
    }

    // Juego entre dos jugadores
    public static void jugarDosJugadores() {

        inicializarTablero();

        int jugador = 1;
        boolean terminado = false;

        while (!terminado) {

            String tableroActual = mostrarTablero();

            String entrada = JOptionPane.showInputDialog(tableroActual +
                            "\n\nJugador " + jugador + ", ingrese la fila (1-3): ");

            if (entrada == null) {
                return;
            }

            int fila = Integer.parseInt(entrada) - 1;

            entrada = JOptionPane.showInputDialog("Jugador " + jugador +
                            "\nIngrese la columna (1-3):");

            if (entrada == null) {
                return;
            }

            int columna = Integer.parseInt(entrada) - 1;

            if (marcar(fila, columna, jugador)) {

                int resultado = ganador();

                if (resultado == 1) {
                    JOptionPane.showMessageDialog(null, mostrarTablero() +
                                    "\n\n¡Ganó el jugador 1!");

                    terminado = true;

                } else if (resultado == 2) {

                    JOptionPane.showMessageDialog(null, mostrarTablero() +
                                    "\n\n¡Ganó el jugador 2!");

                    terminado = true;

                } else if (tableroLleno()) {
                    JOptionPane.showMessageDialog(null, mostrarTablero() +
                            "\n\n¡Empate!");

                    terminado = true;

                } else {
                    if (jugador == 1) {
                        jugador = 2;
                    } else {
                        jugador = 1;
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "La casilla seleccionada no es válida o ya está ocupada.");
            }
        }
    }

    // Juego contra la computadora
    public static void jugarContraComputadora(){

        inicializarTablero();

        int jugador = 1;
        boolean terminado = false;

        while (!terminado) {

            // Turno del jugador
            String entrada = JOptionPane.showInputDialog(
                    mostrarTablero() + "\n\nTu turno (X)" + "\nIngrese la fila (1-3):");

            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Error. La fila no es valida.");
            }

            int fila = Integer.parseInt(entrada) - 1;

            entrada = JOptionPane.showInputDialog("Tu turno (X)" + "\nIngrese la columna (1-3):");

            if (entrada == null) {
                return;
            }

            int columna = Integer.parseInt(entrada) - 1;

            if (marcar(fila, columna, 1)) {

                int resultado = ganador();

                if (resultado == 1) {

                    JOptionPane.showMessageDialog(null, mostrarTablero() +
                            "\n\n¡Ganaste!");

                    terminado = true;

                } else if (tableroLleno()) {
                    JOptionPane.showMessageDialog(null, mostrarTablero() +
                            "\n\n¡Empate!");

                    terminado = true;

                } else {

                    // Turno de la computadora
                    jugarComputadora();

                    resultado = ganador();

                    if (resultado == 2) {

                        JOptionPane.showMessageDialog(null, mostrarTablero() +
                                        "\n\n¡La computadora ganó!");

                        terminado = true;

                    } else if (tableroLleno()) {

                        JOptionPane.showMessageDialog(null, mostrarTablero() +
                                        "\n\n¡Empate!");

                        terminado = true;
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "La casilla seleccionada no es válida o ya está ocupada.");
            }
        }
    }

    // Realiza la jugada de la computadora
    public static void jugarComputadora() {

        Random random = new Random();

        int fila;
        int columna;
        boolean colocada = false;

        while (!colocada) {

            fila = random.nextInt(3);
            columna = random.nextInt(3);

            colocada = marcar(fila, columna, 2);
        }

        JOptionPane.showMessageDialog(null, mostrarTablero() +
                        "\n\nLa computadora realizó su jugada.");
    }
}