
package metodos;

import consola.Consola;
import Funcion.*;

public class FalsaPosicion extends Base {

    public double evaluar(Funcion funcion, double xa, double xb, double e)
    {
        return this.evaluar(funcion, xa, xb, e, 100);
    }

    public double evaluar(Funcion funcion, double xa, double xb, double e, int n) {

        this.funcion = funcion;
        double fb = funcion.evaluar(xb);
        double xi = 0;
        double fi = 0;
        int i = 0;
        n = n > 0 ? n - 1 : n;

        System.out.println(
                this.redondear("N", 5, true)
                + this.redondear("Xa")
                + this.redondear("Xb")
                + this.redondear("X inter.")
                + this.redondear("f(X inter)"));

        do {
            i++;
            xi = this.getInterpolacion(xa, xb);
            fi = funcion.evaluar(xi);

            System.out.println(
                    this.redondearString(i + "", 5, true)
                    + this.redondear(xa)
                    + this.redondear(xb)
                    + this.redondear(xi)
                    + this.redondear(fi));

            if ((fb * fi) > 0) {
                xb = xi;
            } else {
                xa = xi;
            }


        } while (i <= n && Math.abs(fi) > e);



        System.out.println("");

        System.out.println("Solucion Aproximada:" + this.redondear(xi));

        return xi;
    }

    public void operar() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double Xa = consola.getNumero("Ingresa el Valor para Xa");
        double Xb = consola.getNumero("Ingresa el Valor para Xb");
        double error = consola.getNumero("Ingresa la Tolerancia");
        int limite = consola.getEntero("Ingresa el maximo de Iteraciones" );
        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, Xa, Xb, error, limite);
    }
}
