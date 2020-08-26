package metodos;

import consola.Consola;
import Funcion.*;

public class RungeKutta extends Base {

    public RungeKutta() { }

    public double orden4(Funcion funcion, double x0, double y0, double h) {
        double F1 = funcion.evaluar(x0, y0);
        double F2 = funcion.evaluar(x0 + 0.5 * h, y0 + 0.5 * h * F1);
        double F3 = funcion.evaluar(x0 + 0.5 * h, y0 + 0.5 * h * F2);
        double F4 = funcion.evaluar(x0 + h, y0 + h * F3);
        //System.out.println(+F1);
        //System.out.println(+F2);
        //System.out.println(+F3);
        //System.out.println(+F4);

        System.out.println("" + this.redondear(y0) + " + (" + this.redondear(h) + " * (" + this.redondear(F1) + " + 2 * (" + this.redondear(F2) + " + " + this.redondear(F3) + ") + " + this.redondear(F4) + ")) / 6 = " + this.redondear(y0 + (h * (F1 + 2 * (F2 + F3) + F4)) / 6));
        return y0 + (h * (F1 + 2 * (F2 + F3) + F4)) / 6.0;
    }


    public double[] evaluar(Funcion funcion, double x0, double y0, double xn, int n) {

        System.out.println("x0: " + x0);
        System.out.println("y0: " + y0);
        System.out.println("xn: " + xn);
        System.out.println(" n: " + n);
        System.out.println();

        double[] Y = new double[n + 1];
        double[] X = new double[n + 1];

        this.inicializar(X, x0);
        double h = (xn - x0) / n;
        Y[0] = y0;
        X[0] = x0;
        for (int i = 0; i < n; i++) {
            System.out.println("I=" + i);
            y0 = this.orden4(funcion, x0, y0, h);
            x0 += h;
            X[i + 1] = x0;
            Y[i + 1] = y0;
        }


        System.out.println("Resultado:");
        this.reportarcoordenadas(X, Y);



        return Y;
    }

    public void operar() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double x0 = consola.getNumero("Ingresa el Valor inicial de X");
        double y0 = consola.getNumero("Ingresa el Valor inicial de Y");
        double xn = consola.getNumero("Ingresa el Valor final de X");
        int n = consola.getEntero("Ingresa el Numero de Iteraciones");

        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, x0, y0, xn, n);

    }
}
