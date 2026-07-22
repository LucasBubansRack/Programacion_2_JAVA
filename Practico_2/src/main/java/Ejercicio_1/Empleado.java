package Ejercicio_1;

/*
Cree una clase llamada Empleado, que incluya tres variables de instancia: el nombre (String),
un apellido (String) y un salario mensual (double). Su clase debe tener un constructor que inicialice
 las tres variables de instancia. Proporcione los métodos get y set para cada variable de instancia.
 Si el salario mensual no es positivo, no establezca su valor. Escriba una aplicación de prueba llamada PruebaEmpleado,
 que demuestre las capacidades de la clase Empleado. Cree dos objetos Empleado y muestre el salario anual de cada objeto.
  Después, proporcione a cada Empleado un aumento del 10% y muestre el salario anual de cada Empleado otra vez.
*/

public class Empleado {

    private String nombre;
    private String apellido;
    private double salarioMensual;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, double salarioMensual) {
        this.nombre = nombre;
        this.apellido = apellido;

        if (salarioMensual > 0)
            this.salarioMensual = salarioMensual;
        else
            salarioMensual = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        if (salarioMensual > 0)
            this.salarioMensual = salarioMensual;
    }
}
