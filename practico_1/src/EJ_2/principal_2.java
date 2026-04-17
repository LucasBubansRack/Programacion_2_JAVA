package EJ_2;

/*
    Escribe un programa que tome un año introducido por el usuario y diga si es bisiesto o no. Recuerda
    que los años múltiplos de 4 son bisiestos, excepto aquellos que son múltiplos de 100 y no lo son de
    400. Es decir el año 2000 si es bisiesto, pero no lo son el 1990 ni el 2100.
* */

import java.util.Scanner;

public class principal_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int anio;

        System.out.print("Ingrese un año: ");
        anio = sc.nextInt();

        if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
            System.out.println("El año " + anio + " ingresado es bisiesto");
        }else {
            System.out.println("El año " + anio + " ingresado no es bisiesto");
        }
    }
}
