package Ejercicio_3;

/*
Cree una clase llamada Factura, que una ferretería podría utilizar para representar
una factura para un artículo vendido en la tienda. Una Factura debe incluir un número de factura,
un número de articulo, la descripción del articulo, la cantidad de artículos de ese tipo que se
van a comprar y el precio por artículo. Su clase debe tener un constructor que inicialice
las variables de instancia. Proporcione los métodos get y set para cada variable de instancia.
Además, proporcione un metodo llamado obtenerMontoFactura, que calcule el monto de la factura
(es decir, que multiplique la cantidad por el precio por artículo) y después lo devuelva como
un valor double. Si la cantidad no es positiva, debe establecerse en 0. Si el precio por artículo
no es positivo, debe establecerse en 0.0. Escriba una aplicación de prueba llamada PruebaFactura,
que demuestre las capacidades de la clase Factura.
*/

public class Factura {

    private String numFactura;
    private String numArticulo;
    private String descArticulo;
    private int cantArticulo;
    private double precioArticulo;

    public Factura() {
    }

    public Factura(String numFactura, String numArticulo, String descArticulo, int cantArticulo, double precioArticulo) {
        this.numFactura = numFactura;
        this.numArticulo = numArticulo;
        this.descArticulo = descArticulo;

        if (cantArticulo > 0)
            this.cantArticulo = cantArticulo;
        else
            this.cantArticulo = 0;

        if (precioArticulo > 0.0)
            this.precioArticulo = precioArticulo;
        else
            this.precioArticulo = 0.0;

    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getNumArticulo() {
        return numArticulo;
    }

    public void setNumArticulo(String numArticulo) {
        this.numArticulo = numArticulo;
    }

    public String getDescArticulo() {
        return descArticulo;
    }

    public void setDescArticulo(String descArticulo) {
        this.descArticulo = descArticulo;
    }

    public int getCantArticulo() {
        return cantArticulo;
    }

    public void setCantArticulo(int cantArticulo) {
        if (cantArticulo > 0)
            this.cantArticulo = cantArticulo;
        else
            this.cantArticulo = 0;
    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(double precioArticulo) {
        if (precioArticulo > 0.0)
            this.precioArticulo = precioArticulo;
        else
            this.precioArticulo = 0.0;
    }

    public double obtenerMontoFactura(){
        return cantArticulo * precioArticulo;
    }
}
