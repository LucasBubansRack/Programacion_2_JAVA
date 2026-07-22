package Ejercicio_4;

public class PruebaRectangulo {

    public static void main(String[] args) {

        Rectangulo rec_1 = new Rectangulo(5, 8);
        Rectangulo rec_2 = new Rectangulo(-3, -6);
        Rectangulo rec_3 = new Rectangulo(-2, 4);
        Rectangulo rec_4 = new Rectangulo(7, -17);

        // Con ambos valores positivos
        System.out.println("Con ambos valores positivos");
        rec_1.mostrarDatos();

        // Con ambos valores negativos
        System.out.println("\nCon ambos valores negativos");
        rec_2.mostrarDatos();

        // Con longitud negativa
        System.out.println("\nCon longitud negativa");
        rec_3.mostrarDatos();

        // Con anchura negativa
        System.out.println("\nCon anchura negativa");
        rec_4.mostrarDatos();
    }
}
