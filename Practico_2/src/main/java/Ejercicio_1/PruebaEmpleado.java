package Ejercicio_1;

public class PruebaEmpleado {

    public static void main(String[] args) {

        Empleado empleado1 = new Empleado("Lucas", "Bubans", 1500);
        Empleado empleado2 = new Empleado("Noelia", "Porta", 2500);

        System.out.println("Salario anual antes del aumento");
        System.out.println(empleado1.getNombre() + " " + empleado1.getApellido() + ", Salario Anual: $" + empleado1.getSalarioMensual() * 12);
        System.out.println(empleado2.getNombre() + " " + empleado2.getApellido() + ", Salario Anual: $" + empleado2.getSalarioMensual() * 12);

        //// Aumento del 10%
        empleado1.setSalarioMensual(empleado1.getSalarioMensual() * 1.10);
        empleado2.setSalarioMensual(empleado2.getSalarioMensual() * 1.10);

        System.out.println("Salario anual despues del aumento del 10%");
        System.out.println(empleado1.getNombre() + " " + empleado1.getApellido() + ", Salario Anual: $" + empleado1.getSalarioMensual() * 12);
        System.out.println(empleado2.getNombre() + " " + empleado2.getApellido() + ", Salario Anual: $" + empleado2.getSalarioMensual() * 12);
    }
}
