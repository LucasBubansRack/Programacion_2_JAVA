package Ejercicio_5;

public class PruebaFecha {
    public static void main(String[] args) {

        Fecha fecha1 = new Fecha(5, 21, 2010);
        Fecha fecha2 = new Fecha("Junio", 14, 2012);
        Fecha fecha3 = new Fecha(20, "Agosto", 2011);

        System.out.println("Fecha 1:");
        fecha1.mostrarFecha();

        System.out.println("\nFecha 2:");
        fecha2.mostrarFecha();

        System.out.println("\nFecha 3:");
        fecha3.mostrarFecha();
    }
}
