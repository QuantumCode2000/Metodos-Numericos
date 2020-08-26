package metodos;

import consola.Consola;
import Funcion.*;

public class TrapecioCompuessto extends Base {

    public TrapecioCompuessto() {}


    public double evaluar(Funcion funcion, double a, double b, int n) {

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("n: " + n);
        System.out.println();

        double resultado = 0;
        resultado += funcion.evaluar(a);

        double h = (b - a) / n;
        double partes = 0;
        for (int i = 1; i < n; i++) {

            partes += funcion.evaluar(a + i * h);
        }
        resultado += (2 * partes);
        resultado += funcion.evaluar(b);
        resultado *= ((b - a) / (2 * n));
        System.out.println("");
        System.out.println("Resultado:");
        System.out.println(this.redondear(resultado));

        return resultado;

    }

    public void operar() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double a = consola.getNumero("Ingresa el Valor para a");
        double b = consola.getNumero("Ingresa el Valor para b");
        int n = consola.getEntero("Ingresa el Numero de Particiones");


        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, a, b, n);

    }
}
