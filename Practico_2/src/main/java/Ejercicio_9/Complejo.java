package Ejercicio_9;

/*
* Cree una clase llamada Complejo para realizar operaciones aritméticas con
* números complejos. Estos números tienen la forma

parte Real + parte imaginaria * i

Escriba un programa para probar su clase. Use variables de punto flotante
* para representar los datos private de la clase.

Proporcione un constructor que permita que un objeto de esta clase se
* inicialice al declararse. Proporcione un constructor sin argumentos con valores predeterminados,
* en caso de que no se proporcionen inicializadores. Ofrezca métodos public que realicen las siguientes
* operaciones:

a) Sumar dos números Complejos: las partes reales se suman entre sí y las partes imaginarias también.

b) Restar dos números Complejos: la parte real del operando derecho se resta de la
* parte real del operando izquierdo, y la parte imaginaria del operando derecho se
* resta de la parte imaginaria del operando izquierdo.

c) Imprimir números Complejos en la forma (parte Real, parte imaginaria) .
* */

public class Complejo {

    private float parteReal;
    private float parteImaginaria;

    public Complejo() {
        this.parteReal = 0;
        this.parteImaginaria = 0;
    }

    public Complejo(float parteReal, float parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public float getParteReal() {
        return parteReal;
    }

    public void setParteReal(float parteReal) {
        this.parteReal = parteReal;
    }

    public float getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteImaginaria(float parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    // SUMAR
    public Complejo sumar(Complejo otro){
        return new Complejo(this.parteReal + otro.parteReal,
                this.parteImaginaria + otro.parteImaginaria);
    }

    // RESTA
    public Complejo resta(Complejo otro){
        return new Complejo(this.parteReal - otro.parteReal,
                this.parteImaginaria - otro.parteImaginaria);
    }

    // Mostrar
    public void imprimir(){
        System.out.printf("(%.2f; %.2fi)%n", parteReal, parteImaginaria);
    }
}