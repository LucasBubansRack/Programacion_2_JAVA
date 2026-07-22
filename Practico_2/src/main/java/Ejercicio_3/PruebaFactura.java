package Ejercicio_3;

public class PruebaFactura {

    public static void main(String[] args) {

        Factura factura = new Factura("FA15JK", "CB5243", "Llave Inglesa", 3, 15500.50);

        System.out.println("Numero factura: " + factura.getNumFactura() +
                "\nNumero articulo: " + factura.getNumArticulo() +
                "\nDescripcion del articulo: " + factura.getDescArticulo() +
                "\nCantidad: " + factura.getCantArticulo() +
                "\nPrecio unitario: $" + factura.getPrecioArticulo() +
                "\nPrecio NETO: $" + factura.obtenerMontoFactura());

        // Prueba con valores inválidos
        factura.setCantArticulo(-3);
        factura.setPrecioArticulo(-100);

        System.out.println("\nDespués de ingresar valores negativos:");
        System.out.println("Cantidad: " + factura.getCantArticulo());
        System.out.println("Precio por artículo: $" + factura.getPrecioArticulo());
        System.out.println("Monto total: $" + factura.obtenerMontoFactura());
    }
}
