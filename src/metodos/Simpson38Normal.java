package metodos;

import consola.Consola;
import Funcion.*;

public class Simpson38Normal extends Base {

    public Simpson38Normal()
    {

    }

    public double evaluar(Funcion funcion, double x0, double x1, double x2, double x3) {

        System.out.println("x0: " + x0);
        System.out.println("x1: " + x1);
        System.out.println("x2: " + x2);
        System.out.println("x3: " + x3);
        System.out.println();

        double resultado = 0;
        resultado += funcion.evaluar(x0);

        double partes = 0;

        partes += 3 * funcion.evaluar(x1);
        partes += 3 * funcion.evaluar(x2);


        resultado += partes;

        resultado += funcion.evaluar(x3);
        resultado /= 8;
        resultado *= (x3 - x0);
        System.out.println("");
        System.out.println("Resultado:");
        System.out.println(this.redondear(resultado));




        return resultado;

    }

    public void operar() {

        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double x0 = consola.getNumero("Ingresa el Valor para X0");
        double x1 = consola.getNumero("Ingresa el Valor para X1");
        double x2 = consola.getNumero("Ingresa el Valor para X2");
        double x3 = consola.getNumero("Ingresa el Valor para X3");

        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, x0, x1, x2, x3);

    }
}
