package metodos;

import consola.Consola;
import Funcion.*;

public class Simpson13Normal
{

    public Simpson13Normal()
    {
    }

    public double evaluar(Funcion funcion, double a, double b)
    {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println();
        
        double resultado = 0;
        resultado += funcion.evaluar(a);
        double xm = (a + b) / 2;
        resultado += 4 * funcion.evaluar(xm);
        resultado += funcion.evaluar(b);
        resultado *= ((b - a) / 6);

        System.out.println("Aproximacion :");
        System.out.println(resultado);
        return resultado;

    }

    public void operar()
    {
        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double a = consola.getNumero("Ingresa el Valor para a");
        double b = consola.getNumero("Ingresa el Valor para b");
        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, a, b);

    }
}
