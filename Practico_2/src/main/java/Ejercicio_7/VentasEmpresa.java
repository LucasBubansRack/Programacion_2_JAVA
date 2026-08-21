package Ejercicio_7;

/*
* Una compañía tiene cuatro vendedores que venden cinco productos distintos.
* Al finalizar la jornada laboral, cada vendedor pasa una nota por cada tipo de
* producto vendido. Cada nota contiene lo siguiente:
a) El número del vendedor
b) El número del producto
c) El valor total de ese producto vendido en ese día
Así, cada vendedor pasa entre 0 y 5 notas de venta por día. Suponga que está
*  disponible la información sobre todas las notas del mes pasado. Escriba una
*  aplicación que lea toda esta información para las ventas del último mes y que
*  resuma las ventas totales por vendedor, y por producto. Todos los totales deben
*  guardarse en el vector bidimensional ventas.

Después de procesar toda la información del mes pasado, muestre los resultados en
* formato tabular, en donde cada columna represente a un vendedor específico y cada
* fila simboliza un producto. Saque el total de cada fila para obtener las ventas totales
* de cada producto durante el último mes. Calcule el total de cada columna para sacar las
* ventas totales de cada vendedor durante el último mes. Su impresión tabular debe incluir
* estos totales cruzados a la derecha de las filas totalizadas, y en la parte inferior de las
* columnas totalizadas.
* */

import java.util.Scanner;

public class VentasEmpresa {

    public static void main(String[] args) {

        int vendedor;
        int producto;
        double importe;

        Scanner entrada = new Scanner(System.in);
        double[][] ventas = new double[5][4];

        System.out.println("\nIngrese las notas de venta.");
        System.out.println("Para finalizar ingrese 0 como numero de vendedor.");

        while (true) {
            System.out.print("\nNumero de vendedor (1-4, 0 para finalizar): ");
            vendedor = entrada.nextInt();

            if (vendedor < 0 || vendedor > 4) {
                try {
                    throw new Exception("Numero de vendedor erróneo.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            if (vendedor == 0)
                break;

            System.out.print("Numero de producto: ");
            producto = entrada.nextInt();

            if (producto < 1 || producto > 5) {
                try {
                    throw new Exception("Numero de producto erroneo. solo se admite de (1 a 5).");
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }

            System.out.print("Importe vendido: ");
            importe = entrada.nextDouble();

            ventas[producto - 1][vendedor - 1] += importe;
        }

        imprimirTabla(ventas);
        entrada.close();
    }

    public static void imprimirTabla(double[][] ventas){
        System.out.println("\n======= RESUMEN DE VENTAS ==========\n");

        System.out.printf("%12s", "");

        for (int v = 0; v < 4; v++) {
            System.out.printf("%12s", "Vend " + (v + 1));
        }

        System.out.printf("%12s%n", "Total");

        double totalGeneral = 0;

        for (int p = 0; p < 5; p++) {

            double totalProducto = 0;

            System.out.printf("%12s", "Prod " + (p + 1));

            for (int v = 0; v < 4; v++) {
                System.out.printf("%12.2f", ventas[p][v]);
                totalProducto += ventas[p][v];
            }

            System.out.printf("%12.2f%n", totalProducto);

            totalGeneral += totalProducto;
        }

        System.out.printf("%12s", "Total");

        for (int v = 0; v < 4; v++) {

            double totalVendedor = 0;

            for (int p = 0; p < 5; p++) {
                totalVendedor += ventas[p][v];
            }

            System.out.printf("%12.2f", totalVendedor);
        }

        System.out.printf("%12.2f%n", totalGeneral);
    }
}
