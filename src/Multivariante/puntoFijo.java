	package Multivariante;
import Funcion.*;
	
public class puntoFijo 
{
	Double x,y,x0,y0;
	int i=0,l=0;
	Funcion fx,fy;
	
	public puntoFijo()
	{
		System.out.println("ingrese la funcion 1");
		String f1=Leer.dato();
		fx=new Funcion(f1);
		System.out.println("ingrese la funcion 2");
		String f2=Leer.dato();
		fy=new Funcion(f2);
		x=0.0;
		y=0.0;
		x0=x;
		y0=y;
	}
	
	public void generate()
	{
		//x=-100+200*Math.random();
		//y=-100+200*Math.random(); //con neg -100_100
		x=100*Math.random();
		y=100*Math.random();

		x0=x;
		y0=y;
	}
	public void generate(Double x1,Double y1)
	{
		x=x1;
		y=y1;
		x0=x;
		y0=y;
	}

	public void mostrar()
	{
		System.out.println("i "+i+" x0="+x0+" y0="+y0);
	}
	
	public void operar1()
	{
		for(int k=0;k<110;k++)
		{
			i=0;
			generate();
			System.out.println("n:"+l);
			mostrar();
			for(int j=0;j<10;j++)
			{
				x=fx.evaluar(x0,y0);
				y=fy.evaluar(x0,y0);
				x0=x;
				y0=y;
				i++;
				mostrar();
			}
			System.out.println();
			l++;
		}
	}
	
	public void operar2()
	{
			int n;
			System.out.print("x0:");
			x0=Leer.datoDouble();
			System.out.print("y0:");
			y0=Leer.datoDouble();
			generate(x0,y0);
			System.out.print("num de iteraciones:");
			n=Leer.datoInt();
			mostrar();
			for(int j=0;j<n;j++)
			{
				x=fx.evaluar(x0,y0);
				y=fy.evaluar(x0,y0);
				
				x0=x;
				y0=y;
				
				i++;
				mostrar();
			}	
	}
}
