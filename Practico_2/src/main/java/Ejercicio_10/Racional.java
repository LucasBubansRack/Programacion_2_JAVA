package Ejercicio_10;

/*
* Cree una clase llamada Racional para realizar operaciones aritméticas con fracciones.

Escriba un programa para probar su clase. Use variables enteras para representar las
* variables de instancia de la clase: el numerador y el denominador. Proporcione un
* constructor que permita inicializarse a un objeto de esta clase al ser declarado.
* El constructor debe almacenar la fracción en forma reducida. La fracción 2/4 es
* equivalente a 1/2 y debe guardarse en el objeto como 1 en el numerador y 2 en el
* denominador. Proporcione un constructor sin argumentos con valores predeterminados,
* en caso de que no se proporcionen inicializadores. Proporcione métodos public que
* realicen cada una de las siguientes operaciones:

a) Sumar dos números Racional: el resultado de la suma debe almacenarse en forma reducida.
* Implemente esto como un metodo static.

b) Restar dos números Racional: el resultado de la resta debe almacenarse en forma reducida.
* Implemente esto como un metodo static.

c) Multiplicar dos números Racional: el resultado de la multiplicación debe almacenarse en
* forma reducida. Implemente esto como un metodo static .

d) Dividir dos números Racional: el resultado de la división debe almacenarse en forma
* reducida. Implemente esto como un metodo static.

e) Devolver una representación String de un número Racional en la forma a/b,
* en donde a es el numerador y b es el denominador.

f) Devolver una representación String de un número Racional en formato de punto flotante.
* (Considere proporcionar capacidades de formato, que permitan al usuario de la clase especificar
* el número de dígitos de precisión a la derecha del punto decimal)
* */

public class Racional {


    private int numerador;
    private int denominador;

    public Racional() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Racional(int numerador, int denominador) {

        if (denominador == 0)
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        else{
            this.numerador = numerador;
            this.denominador = denominador;
        }
        simplificar();
    }

    // SUMA
    public static Racional sumar(Racional r1, Racional r2){
        int numerador = (r1.numerador * r2.denominador) + (r2.numerador * r1.denominador);
        int denominador = r1.denominador * r2.denominador;

        return new Racional(numerador, denominador);
    }

    // RESTA
    public static Racional restar(Racional r1, Racional r2){
        int numerador = (r1.numerador * r2.denominador) - (r2.numerador * r1.denominador);
        int denominador = r1.denominador * r2.denominador;

        return new Racional(numerador, denominador);
    }

    // MULTIPLICACIÓN
    public static Racional multiplicar(Racional r1, Racional r2){
        int numerador = r1.numerador * r2.numerador;
        int denominador = r1.denominador * r2.denominador;

        return new Racional(numerador, denominador);
    }

    // DIVISION
    public static Racional dividir(Racional r1, Racional r2){
        if (r2.numerador == 0)
            throw new ArithmeticException("No se puede dividir por cero.");

        int numerador = r1.numerador * r2.denominador;
        int denominador = r1.denominador * r2.numerador;

        return new Racional(numerador, denominador);
    }

    // Representación a/b
    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

    // Representación decimal
    public String toDecimal(){
        return String.valueOf((double) numerador / denominador);
    }

    // Representación decimal con precisión
    public String toDecimal(int decimales){
        return String.format("%." + decimales + "f", (double) numerador / denominador);
    }

    // Simplifica la fracción
    private void simplificar(){
        int mcd = calcularMCD(Math.abs(numerador), Math.abs(denominador));

        numerador /= mcd;
        denominador /= mcd;

        // Mantener el signo en el numerador
        if (denominador < 0){
            numerador *= -1;
            denominador *= -1;
        }
    }

    // Maximo común divisor
    private int calcularMCD(int a, int b){
        while (b != 0){
            int aux = b;
            b = a % b;
            a = aux;
        }
        return a;
    }
}