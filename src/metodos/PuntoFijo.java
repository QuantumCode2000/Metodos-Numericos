package metodos;

import java.util.Scanner;
import Funcion.*;

public class PuntoFijo
{
    int maxit;
    double tol;
    double no;
    Funcion fx;
    public PuntoFijo()
    {
        System.out.println("ingrese funcion:");
        String fs=leer.next();
        fx=new Funcion(fs);
    }

    Scanner leer=new Scanner(System.in);


    public int iteraciones()
    {
        System.out.println("INSERTE EL NUMERO DE ITERACIONES");
        maxit = leer.nextInt();
        return maxit;
    }

    public double tolerancia()
    {
        System.out.println("INSERTE LA TOLERANCIA");
        tol = leer.nextDouble();
        return tol;
    }

    public double aproximacinI()
    {
        System.out.println("Aproximacion inicial");
        no = leer.nextDouble();
        return no;
    }

    public void operar()
    {
        double tol,po,p = 0;
        int no,i;
        boolean ok=true;
        po=aproximacinI();
        tol=tolerancia();
        no=iteraciones();
        if(ok)
        {
            i=1;
            ok=true;
            System.out.println("|I|      XI     |    XI+ - XI   |  ");
            while(i <= no && ok)
            {
                p=fx.evaluar(po);

                System.out.printf("| %d |  %.3f  | %.3f  | \n",i,po,Math.abs(p-po));
                if(Math.abs(p-po) < tol)
                {
                    System.out.println("solucion aproximada P = "+p);
                    ok=false;
                }
                else
                {
                    i++;
                    po=p;
                }
            }
            if(ok)
            {
                System.out.println("\nLa iteracion numero %3d"+ no);
                System.out.println("da la aproximacio "+ p);
                System.out.println("fuera de la tolerancia aceptada\n");
            }
        }

    }

}
