package EJ_9;

/*
    Escribe una aplicación que reciba del usuario el radio de un círculo como un entero, y que imprima
    el diámetro de la circunferencia y el área del círculo mediante el uso del valor de punto flotante
    3.14159 para PI. También puede utilizar la constante predefinida Math.PI para el valor. Esta
    constante es más precisa que el valor 3.14159. La clase Math se define en el paquete java.lang. Las
    clases en este paquete se importan de manera automática, por lo que no necesita importar la clase
    Math mediante la instrucción import para usarla. Use las siguientes fórmulas (r es el radio):
    diámetro = 2 r
    circunferencia = 2 * PI * r
    área = PI * r2
* */


import java.util.Scanner;
//import static java.lang.Math.PI;

public class principal_9 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int radio;
        float area;
        double pvalor_PI = Math.PI;

        do {
            System.out.print("Ingrese el radio(numero entero positivo) del circulo: ");
            radio = sc.nextInt();
        }while (radio <= 0);

        System.out.println("El diametro de la circulo es: " + (2 * radio));
        System.out.println("La circunferencia es: " + (2 * pvalor_PI * radio));
        System.out.println("El area es: " + (pvalor_PI * Math.pow(radio, 2) ));

    }
}
