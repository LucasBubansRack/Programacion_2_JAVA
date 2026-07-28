package Ejercicio_9;

public class PruebaComplejo {
    public static void main(String[] args) {

    Complejo complejo_1 = new Complejo(5, 3);
    Complejo complejo_2 = new Complejo(2, -4);

        System.out.println("Numero 1: ");
        complejo_1.imprimir();

        System.out.println("Numero 2: ");
        complejo_2.imprimir();

        Complejo suma = complejo_1.sumar(complejo_2);
        System.out.println("Suma: ");
        suma.imprimir();

        Complejo resta = complejo_1.resta(complejo_2);
        System.out.println("Resta: ");
        resta.imprimir();
    }
}
