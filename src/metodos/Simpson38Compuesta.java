package metodos;

import consola.Consola;
import Funcion.*;

public class Simpson38Compuesta extends Base {

    public Simpson38Compuesta() {

    }

    public double evaluar(Funcion funcion, double a, double b, int n) {

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("n: " + n);
        System.out.println();

        double resultado = 0;
        resultado += funcion.evaluar(a);

        double h = ((b - a) / n);

        double partes_1 = 0, partes_2 = 0, partes_3 = 0;
        int pos = 1;
        for (int i = 1; i < n; i++) {
            if (pos > 3) {
                pos = 1;
            }

            if (pos == 1) {
                partes_1 += funcion.evaluar(a + i * h);
            } else if (pos == 2) {

                partes_2 += funcion.evaluar(a + i * h);
            } else if (pos == 3) {

                partes_3 += funcion.evaluar(a + i * h);
            }

            pos++;

        }
        resultado += (3 * partes_1);
        resultado += (3 * partes_2);
        resultado += (2 * partes_3);


        resultado += funcion.evaluar(b);

        resultado *= ((3.0 / 8.0) * h);
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
