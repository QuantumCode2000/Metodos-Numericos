package metodos;

import consola.Consola;
import Funcion.*;

public class TrapecioNormal extends Base {

    public TrapecioNormal()
    {
    }

    public double evaluar(Funcion funcion, double a, double b) {

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println();

        double resultado = ((b - a) / 2) * (funcion.evaluar(a) + funcion.evaluar(b));

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

        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, a, b);

    }
}
