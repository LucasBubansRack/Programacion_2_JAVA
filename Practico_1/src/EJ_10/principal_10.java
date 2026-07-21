package EJ_10;

/*
    Escribe una aplicación que determine el sueldo bruto para cada uno de cinco empleados. La
    empresa paga la cuota normal en las primeras 40 horas de trabajo de cada empleado, y cuota y
    media en todas las horas trabajadas que excedan de 40. Usted recibe una lista de los empleados de
    la empresa, el número de horas que trabajó cada uno la semana pasada y la tarifa por horas de cada
    empleado. Su programa debe recibir como entrada esta información para cada empleado, debe
    determinar y mostrar el sueldo bruto de cada trabajador.
* */

import java.util.Scanner;

public class principal_10 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int empleados = 3;
        int[] horasTrabajadas = new int[empleados];
        int[] tarifaPorHora = new int[empleados];
        double[] sueldoBruto = new double[empleados];

        for (int i = 0; i < empleados; i++) {
            System.out.print("Horas trabajadas empleado " + (i+1) + ": ");
            horasTrabajadas[i] = sc.nextInt();
            System.out.print("Tarifa por hora de trabajo: ");
            tarifaPorHora[i] = sc.nextInt();
        }

        for (int i = 0; i < empleados; i++) {
            int horasExtra = horasTrabajadas[i] - 40;
            if (horasExtra > 0){
                sueldoBruto[i] = (horasExtra * (tarifaPorHora[i] * 1.5));
                sueldoBruto[i] += (horasTrabajadas[i] - horasExtra) * tarifaPorHora[i];
            } else if (horasExtra <= 0) {
                sueldoBruto[i] = horasTrabajadas[i] * tarifaPorHora[i];
            }
        }

        for (int i = 0; i < empleados; i++) {
            System.out.println("Empleado " + (i+1) + " sueldo bruto: $ " + sueldoBruto[i]);
        }
    }
}
