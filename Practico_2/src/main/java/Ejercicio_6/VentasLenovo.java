package Ejercicio_6;

/*
* El sector de ventas online de notebooks Lenovo paga a sus vendedores mediante comisiones.
* Los vendedores reciben $2000 por semana, más el 6% de sus ventas brutas durante esa semana.
*  Por ejemplo, un vendedor que vende $50000 de mercancía en una semana, recibe $2000 más el 6% de $50000,
*  o un total de $5000. Usted acaba de recibir una lista de los artículos vendidos por cada vendedor.
* Los valores de estos artículos son los siguientes:

    Articulo           Valor
       1               $ 7239.99
       2              $ 9129.75
       3              $ 6899.95
       4             $ 13150.89

Desarrolle una aplicación en JAVA que reciba como entrada los artículos vendidos por un vendedor
* durante cada día de la última semana, y que calcule y muestre los ingresos de ese vendedor.
* No hay límite en cuanto al número de artículos que un representante puede vender.
* */

import java.util.Scanner;

public class VentasLenovo {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Precios de los artículos
        double[] precios = {
                7239.99,
                9129.75,
                6899.95,
                13150.89
        };

        double totalVentas = 0;

        for (int dia = 1; dia <= 7; dia++) {

            System.out.println("\nDía " + dia);

            System.out.print("¿Cuántos artículos vendió?: ");
            int cantidad = entrada.nextInt();

            for (int i = 1; i <= cantidad; i++) {

                int articulo;

                do {
                    System.out.print("Ingrese el número del artículo (1-4): ");
                    articulo = entrada.nextInt();

                    if (articulo < 1 || articulo > 4) {
                        System.out.println("Artículo inválido.");
                    }

                } while (articulo < 1 || articulo > 4);

                totalVentas += precios[articulo - 1];
            }
        }

        double sueldoBase = 2000;
        double comision = totalVentas * 0.06;
        double sueldoTotal = sueldoBase + comision;

        System.out.println("\n========== RESUMEN ==========");
        System.out.printf("Ventas totales: $%.2f", totalVentas);
        System.out.printf("\nComisión (6%%): $%.2f", comision);
        System.out.printf("\nSueldo base: $%.2f", sueldoBase);
        System.out.printf("\nSueldo total: $%.2f", sueldoTotal);

        entrada.close();
    }
}
