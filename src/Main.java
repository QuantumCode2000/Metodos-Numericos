import Interpolacion.DifDiv;
import Interpolacion.PolLagrange;
import Interpolacion.Simple;
import consola.Menu;
import consola.MenuCallback;
import metodos.*;
import Multivariante.*;
import Interpolacion.*;
import edos.*;
public class Main
{
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.setTitulo("Aplicacion de Consola para Metodos Numericos");

        menu.agregar("Punto Fijo", new MenuCallback() {
            public void ejecutar() {
                PuntoFijo metodo = new PuntoFijo();
                metodo.operar();
            }
        });
        menu.agregar("Newton Raphson ", new MenuCallback() {
            public void ejecutar()
            {
                NewtonRaphson metodo = new NewtonRaphson();
                metodo.operar();
            }
        });
        menu.agregar("Posicion Falsa ", new MenuCallback() {
            public void ejecutar()
            {
                FalsaPosicion metodo = new FalsaPosicion();
                metodo.operar();
            }
        });

        menu.agregar("Punto Fijo Multivariable ", new MenuCallback() {
            public void ejecutar()
            {
                puntoFijo metodo = new puntoFijo();
                metodo.operar2();
            }
        });
        menu.agregar("Newton Raphson Multivariable ", new MenuCallback() {
            public void ejecutar()
            {
                NewtonRapsonM metodo = new NewtonRapsonM();
                metodo.operar();
            }
        });
        menu.agregar("Newton Raphson Multivariable Mejorado ", new MenuCallback() {
            public void ejecutar()
            {
                NewtonMejorado metodo = new NewtonMejorado();
                metodo.Operar();
            }
        });
        menu.agregar("Broyden ", new MenuCallback() {
            public void ejecutar()
            {
                Broyden metodo = new Broyden();
                metodo.Operacion();
            }
        });
        menu.agregar("Aproximacion Polinomial Simple", new MenuCallback() {
            public void ejecutar()
            {
                Simple metodo = new Simple();
                metodo.operaciones();
            }
        });
        menu.agregar("Aproximacion Polinomial Lagrange", new MenuCallback() {
            public void ejecutar()
            {
                PolLagrange metodo = new PolLagrange();
                metodo.Operacion();
            }
        });
        menu.agregar("Aproximacion Polinomial Newton por Diferencias \n        Finitas", new MenuCallback() {
            public void ejecutar()
            {
                DifDiv metodo = new DifDiv();
                metodo.operar();
            }
        });

        menu.agregar("Regresion Lineal Multiple ", new MenuCallback() {
            public void ejecutar()
            {
                regMult metodo = new regMult();
                metodo.Operacion();
            }
        });

        menu.agregar("Trapezoidal", new MenuCallback() {
            public void ejecutar()
            {
                Simpson13Normal metodo = new Simpson13Normal();
                metodo.operar();
            }
        });
        menu.agregar("Trapezoidal Compuesto", new MenuCallback() {
            public void ejecutar()
            {
                Simpson13Normal metodo = new Simpson13Normal();
                metodo.operar();
            }
        });
        menu.agregar("Simpsom 1/3 ", new MenuCallback() {
            public void ejecutar()
            {
                Simpson13Normal metodo = new Simpson13Normal();
                metodo.operar();
            }
        });
        menu.agregar("Simpsom 1/3 Compuesto ", new MenuCallback() {
            public void ejecutar()
            {
                Simpson13Compuesta metodo = new Simpson13Compuesta();
                metodo.operar();
            }
        });
        menu.agregar("Simpsom 3/8 ", new MenuCallback() {
            public void ejecutar()
            {
                Simpson38Normal metodo = new Simpson38Normal();
                metodo.operar();
            }
        });
        menu.agregar("Simpsom 3/8 Compuesto ", new MenuCallback() {
            public void ejecutar()
            {
                Simpson38Compuesta metodo = new Simpson38Compuesta();
                metodo.operar();
            }
        });

        menu.agregar("Euler", new MenuCallback() {
            public void ejecutar()
            {
                Euler metodo = new Euler();
                metodo.operacion();
            }
        });
        menu.agregar("Euler Modificado", new MenuCallback() {
            public void ejecutar()
            {
                EulerModificado metodo = new EulerModificado();
                metodo.operacion();
            }
        });
        menu.agregar("Taylor", new MenuCallback() {
            public void ejecutar()
            {
                Taylor metodo = new Taylor();
                metodo.operacion();
            }
        });

        menu.agregar("Runge Kutta ", new MenuCallback() {
            public void ejecutar()
            {
                RungeKutta metodo = new RungeKutta();
                metodo.operar();
            }
        });

        menu.agregar("Runge Kutta para Sistemas", new MenuCallback() {
            public void ejecutar()
            {
                RKuta metodo = new RKuta();
                metodo.Operacion();
            }
        });


        menu.mostrar();

    }
}
