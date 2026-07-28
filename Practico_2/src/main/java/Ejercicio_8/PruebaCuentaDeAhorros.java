package Ejercicio_8;

public class PruebaCuentaDeAhorros {
    public static void main(String[] args) {

        CuentaDeAhorros ahorrador_1 = new CuentaDeAhorros(20000);
        CuentaDeAhorros ahorrador_2 = new CuentaDeAhorros(30000);

        CuentaDeAhorros.modificarTasaInteres(0.04);
        System.out.println("\nTasa anual: 4%\n\n");

        for (int mes = 1; mes <= 12; mes++){
            ahorrador_1.calcularInteresMensual();
            ahorrador_2.calcularInteresMensual();

            System.out.printf("Mes: %2d\n", mes);
            System.out.printf("Ahorrador 1: $%.2f\n", ahorrador_1.getSaldoAhorros());
            System.out.printf("Ahorrador 2: $%.2f\n", ahorrador_2.getSaldoAhorros());
        }

        CuentaDeAhorros.modificarTasaInteres(0.05);
        ahorrador_1.calcularInteresMensual();
        ahorrador_2.calcularInteresMensual();

        System.out.println("\nDespues de aumentar la tasa anual al 5%\n\n");
        System.out.printf("Ahorrador 1: $%.2f\n", ahorrador_1.getSaldoAhorros());
        System.out.printf("Ahorrador 2: $%.2f\n", ahorrador_2.getSaldoAhorros());
    }
}
