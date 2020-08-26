
package Multivariante;

import Funcion.*;

public class NewtonMejorado 
{
	
	Funcion f1,f2,f1dx,f2dy;
	
	public NewtonMejorado()
	{
		String s;
		System.out.println("funcion 1");
		s=Leer.dato();
		f1=new Funcion(s);
		System.out.println("funcion 1 derivado en x");
		s=Leer.dato();
		f1dx=new Funcion(s);
		System.out.println("funcion 2");
		s=Leer.dato();
		f2=new Funcion(s);
		System.out.println("funcion 2 derivado en x");
		s=Leer.dato();
		f2dy=new Funcion(s);
	}
	
	public void Operar()
	{
		Double x0=1.0,y0=1.0,x1,y1;
		System.out.print("x0:");
		x0=Leer.datoDouble();
		System.out.print("y0:");
		y0=Leer.datoDouble();
		x1=x0;y1=y0;
		System.out.println("x1="+x1+" y1="+y1);
		for(int i=0;i<50;i++)
		{
			x1=x1-(f1.evaluar(x0,y0)/f1dx.evaluar(x0,y0));
			x0=x1;
			y1=y1-(f2.evaluar(x0,y0)/f2dy.evaluar(x0,y0));
			y0=y1;
			System.out.println("x1="+x1+" y1="+y1);
		}		
	}
	
}
