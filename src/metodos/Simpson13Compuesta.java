package metodos;

import consola.Consola;
import Funcion.*;

public class Simpson13Compuesta extends Base {

    public Simpson13Compuesta() {}

    public double evaluar(Funcion funcion, double a, double b, int n) {
        
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("n: " + n);
        System.out.println();
        
        double resultado = 0;
        resultado += funcion.evaluar(a);


        double h = (b - a) / n;

        double partes_pares = 0, partes_impares = 0;
        for (int i = 1; i < n; i++)
        {
            if ((i % 2) == 0) {
                partes_pares += funcion.evaluar(a + i * h);
            } else {
                partes_impares += funcion.evaluar(a + i * h);
            }
        }
        resultado += (2 * partes_pares);
        resultado += (4 * partes_impares);

        resultado += funcion.evaluar(b);
        resultado *= ((b - a) / (3 * n));
        System.out.println("");
        System.out.println("Resultado:");
        System.out.printf( " %.3f ",resultado);




        return resultado;

    }

    public void operar()
    {
        Consola consola = new Consola();
        String funcion_cadena = consola.getCadena("Ingresa la Funcion");
        double a = consola.getNumero("Ingresa el Valor para a");
        double b = consola.getNumero("Ingresa el Valor para b");
        int n = consola.getEntero("Ingresa el Numero de Particiones");

        Funcion funcion = new Funcion(funcion_cadena);
        this.evaluar(funcion, a, b, n);

    }
}
