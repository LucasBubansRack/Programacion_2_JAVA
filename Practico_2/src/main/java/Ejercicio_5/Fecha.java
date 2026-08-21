package Ejercicio_5;

/*
* Cree una clase llamada Fecha, que incluya tres variables de instancia:
* un mes (int), un día (int) y un año (int). Su clase debe tener un constructor que
* inicialice las tres variables de instancia, y debe verificar que los valores que se
* proporcionan son correctos. Proporcione los métodos get y set para cada variable de instancia.
* Proporcione un metodo mostrarFecha para Imprimir la fecha en varios formatos, como
     05/21/2010
     Junio 14, 2012
     20 Agosto 11
Usar constructores sobrecargados para crear objetos Fecha inicializados con fechas de los
* formatos solicitados para imprimir. En el primer caso, el constructor debe recibir tres
* valores enteros. En el segundo, debe recibir un objeto String y dos valores enteros.
* En el tercero debe recibir un valor entero, string y otro entero. Escriba una aplicación de
* prueba llamada PruebaFecha, que demuestre las capacidades de la clase Fecha.
* */

public class Fecha {

    private int mes;
    private int dia;
    private int anio;

    // Constructor 1: (mes, dia, anio)
    public Fecha(int mes, int dia, int anio) {
        setMes(mes);
        setDia(dia);
        setAnio(anio);
    }

    // Constructor 2: (nombreMes, dia, anio)
    public Fecha(String nombreMes, int dia, int anio) {
        setMes(convertirMes(nombreMes));
        setDia(dia);
        setAnio(anio);
    }

    // Constructor 3: (dia, nombreMes, anio)
    public Fecha(int dia, String nombreMes, int anio) {
        setMes(convertirMes(nombreMes));
        setDia(dia);
        setAnio(anio);
    }

    // Getters
    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public int getAnio() {
        return anio;
    }

    // Setters con validación
    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            this.mes = 1;
        }
    }

    public void setDia(int dia) {

        int maximo;

        switch (mes){
            case 2:
                maximo = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maximo = 30;
                break;
            default:
                maximo = 31;
        }

        if (dia >= 1 && dia <= maximo) {
            this.dia = dia;
        } else {
            this.dia = 1;
        }
    }

    public void setAnio(int anio) {
        if (anio >= 0) {
            this.anio = anio;
        } else {
            this.anio = 2000;
        }
    }

    // Convierte el nombre del mes a número
    private int convertirMes(String nombreMes) {

        switch (nombreMes.toLowerCase()) {
            case "enero":
                return 1;
            case "febrero":
                return 2;
            case "marzo":
                return 3;
            case "abril":
                return 4;
            case "mayo":
                return 5;
            case "junio":
                return 6;
            case "julio":
                return 7;
            case "agosto":
                return 8;
            case "septiembre":
                return 9;
            case "octubre":
                return 10;
            case "noviembre":
                return 11;
            case "diciembre":
                return 12;
            default:
                return 1;
        }
    }

    // Convierte número de mes a nombre
    private String nombreMes() {

        switch (mes) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "";
        }
    }

    // Imprime la fecha en los tres formatos
    public void mostrarFecha() {

        System.out.printf("%02d/%02d/%04d%n", mes, dia, anio);

        System.out.println(nombreMes() + " " + dia + ", " + anio);

        System.out.println(dia + " " + nombreMes() + " " + (anio % 100));
    }
}
