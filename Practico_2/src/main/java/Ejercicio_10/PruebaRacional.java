package Ejercicio_10;

public class PruebaRacional {
    public static void main() {

        Racional r1 = new Racional(2, 4);
        Racional r2 = new Racional(3, 8);

        System.out.println("Primer racional: " + r1);
        System.out.println("Segundo racional: " + r2);

        Racional suma = Racional.sumar(r1, r2);
        Racional resta = Racional.restar(r1, r2);
        Racional multiplicacion = Racional.multiplicar(r1, r2);
        Racional division = Racional.dividir(r1, r2);

        System.out.println("\nSuma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("Division: " + division);

        System.out.println("\nForma decimal:");
        System.out.println(r1 + " = " + r1.toDecimal());
        System.out.println(r2 + " = " + r2.toDecimal());

        System.out.println("\nCon 4 decimales:");
        System.out.println(r1 + " = " + r1.toDecimal(4));
        System.out.println(r2 + " = " + r2.toDecimal(4));
    }
}
