package Ejercicio_4;

/*
* Cree una clase llamada Rectángulo con los atributos longitud y anchura,
* cada uno con un valor predeterminado de 1. Debe tener métodos para calcular el perímetro
* y el área del rectángulo. Debe tener métodos get y set para longitud y anchura.
* Los métodos set deben verificar que longitud y anchura sean números de
* punto flotante mayores de 0.0, y menores de 20.0. Escriba un programa para probar la clase Rectángulo
*  y cada uno de sus métodos.
* */

public class Rectangulo {

    private float longitud;
    private float anchura;

    public Rectangulo() {
    }

    public Rectangulo(float longitud, float anchura) {
        setLongitud(longitud);  // Valída antes de guardar el valor
        setAnchura(anchura);
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        if (longitud > 0.0 && longitud < 20.0)
            this.longitud = longitud;
        else
            this.longitud = 1.0F;
    }

    public float getAnchura() {
        return anchura;
    }

    public void setAnchura(float anchura) {
        if (anchura > 0.0 && anchura < 20.0)
            this.anchura = anchura;
        else
            this.anchura = 1.0F;
    }

    public float calcularArea(){
        return longitud * anchura;
    }

    public float calcularPerimetro(){
        return 2 * (longitud + anchura);
    }

    public void mostrarDatos(){
        System.out.println("Longitud: " + longitud +
                "\nAnchura: " + anchura +
                "\nArea: " + calcularArea() +
                "\nPerimetro: " + calcularPerimetro());
    }
}
