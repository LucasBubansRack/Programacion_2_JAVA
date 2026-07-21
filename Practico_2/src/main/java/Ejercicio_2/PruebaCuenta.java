package Ejercicio_2;

public class PruebaCuenta {
    public static void main(String[] args) {

        Cuenta cuenta1 = new Cuenta(10, 100000);

        System.out.println("Saldo actual: $" + cuenta1.getSaldo());

        // Ingresar dinero
        cuenta1.ingresarDinero(20000);
        System.out.println("Saldo despues del ingeso: $" + cuenta1.getSaldo());

        // Retirar dinero
        cuenta1.retirarDinero(10000);
        System.out.println("Saldo despues del retiro: $" + cuenta1.getSaldo());

        // Retiro invalido
        cuenta1.retirarDinero(120000);
        System.out.println("Cuenta despues del intento de retiro: $" + cuenta1.getSaldo());

        // Abonar intereses
        cuenta1.abonarInteres();
        System.out.println("Cuenta despues de aplicar intereses: $" + cuenta1.getSaldo());
    }
}
