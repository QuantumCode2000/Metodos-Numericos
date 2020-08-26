package edos;


import java.text.DecimalFormat;
import java.util.Scanner;
import Funcion.*;

public class Euler 
{
	Double h,x0,x1,X,Y;
	int n;
	Funcion y;
	
	DecimalFormat df = new DecimalFormat("#.0000");

	Scanner leer=new Scanner(System.in);
	public Euler()
	{
		System.out.println("ingrese la funcion y'");
		String s=Leer.dato();
		y=new Funcion(s);
		
		System.out.println("ingresa n");
		n=leer.nextInt();
		System.out.println("x0__x1");
		x0=leer.nextDouble();
		x1=leer.nextDouble();
		
	}
	
	
	public void operacion()
	{
		h=(x1-x0)/n;
		System.out.println("ingresa y(x0)");
		Y=leer.nextDouble();
		X=x0;
		System.out.println("X: "+df.format(X)+" Y: "+df.format(Y));		
		while(X<=x1)
		{
			Y=Y+h*y.evaluar(X,Y);
			X=X+h;
			System.out.println("X: "+df.format(X)+" Y: "+df.format(Y));		
			
		}
	}
	
}

//DecimalFormat df = new DecimalFormat("#.0000");
//System.out.println("X: "+df.format(X)+" Y: "+df.format(Y));		
