package Ejercicio_2;

/*
Realizar una aplicación sencilla para simular una cuenta bancaria (caja de ahorro).
Una cuenta bancaria vista como un objeto tiene, por una parte, atributos que definen su estado,
como Tipo de interés y Saldo, y por otra, operaciones que definen su comportamiento, como Establecer tipo
de interés,
Ingresar dinero, Retirar dinero, Saldo actual o Abonar intereses. Asegúrese que el monto a retirar no exceda
 el saldo de Cuenta.
 Si lo hace, el saldo debe permanecer sin cambio y el método debe imprimir un mensaje que indique
  " El monto a retirar excede el saldo de la cuenta.” Realice la clase PruebaCuenta para probar los
  diferentes métodos.
*/

public class Cuenta {

    private double tipoInteres;
    private double saldo;

    public Cuenta() {
    }

    public Cuenta(double tipoInteres, double saldoInicial) {
        this.tipoInteres = tipoInteres;

        if (saldoInicial >= 0)
            this.saldo = saldoInicial;
        else
            saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public void ingresarDinero(double monto){
        if (monto > 0)
            saldo += monto;
    }

    public void retirarDinero(double monto){
        if (monto <= saldo && monto > 0)
            saldo -= monto;
        else
            System.out.println("El monto a retirar exede el saldo de la cuenta.");
    }

    public void abonarInteres(){
        saldo += (saldo * tipoInteres) / 100;
    }
}
